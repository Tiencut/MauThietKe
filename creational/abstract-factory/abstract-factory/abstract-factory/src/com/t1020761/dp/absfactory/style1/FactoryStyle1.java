package com.t1020761.dp.absfactory.style1;

import com.t1020761.dp.absfactory.DongVatAnCo;
import com.t1020761.dp.absfactory.DongVatAnThit;
import com.t1020761.dp.absfactory.DongVatFactory;

public class FactoryStyle1 extends DongVatFactory {

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new NguaVan();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SuTu();
	}

}
