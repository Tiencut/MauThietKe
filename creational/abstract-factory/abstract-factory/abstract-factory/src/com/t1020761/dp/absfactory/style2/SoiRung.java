package com.t1020761.dp.absfactory.style2;

import com.t1020761.dp.absfactory.DongVatAnCo;
import com.t1020761.dp.absfactory.DongVatAnThit;

public class SoiRung implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sói rừng châu Á đuổi\n", this.toString());
		x.chạy();
	}

}
