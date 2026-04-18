package com.t1020761.dp.absfactory.style1;

import com.t1020761.dp.absfactory.DongVatAnCo;
import com.t1020761.dp.absfactory.DongVatAnThit;

public class SuTu implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sư tử châu Phi đuổi\n", this.toString());
		x.chạy();
	}
}
