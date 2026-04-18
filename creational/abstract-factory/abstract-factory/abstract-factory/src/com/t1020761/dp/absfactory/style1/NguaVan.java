package com.t1020761.dp.absfactory.style1;

import com.t1020761.dp.absfactory.DongVatAnCo;

public class NguaVan implements DongVatAnCo {

	@Override
	public void chạy() {
		System.out.printf("Ngựa vằn châu Phi chạy :D", this.toString());
	}
}
