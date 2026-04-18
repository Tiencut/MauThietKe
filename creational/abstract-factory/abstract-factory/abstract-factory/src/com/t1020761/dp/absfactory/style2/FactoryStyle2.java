package com.t1020761.dp.absfactory.style2;

import com.t1020761.dp.absfactory.DongVatAnCo;
import com.t1020761.dp.absfactory.DongVatAnThit;
import com.t1020761.dp.absfactory.DongVatFactory;

public class FactoryStyle2 extends DongVatFactory{

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new Soc();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SoiRung();
	}

}
