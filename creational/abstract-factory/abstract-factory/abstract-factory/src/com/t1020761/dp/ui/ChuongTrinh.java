package com.t1020761.dp.ui;

import com.t1020761.dp.absfactory.DongVatAnCo;
import com.t1020761.dp.absfactory.DongVatAnThit;
import com.t1020761.dp.absfactory.DongVatFactory;
import com.t1020761.dp.absfactory.style1.FactoryStyle1;
import com.t1020761.dp.absfactory.style2.FactoryStyle2;

public class ChuongTrinh {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		// 1. Tạo nhà máy theo style
		DongVatFactory f;
		f = new FactoryStyle1();
//		f = new FactoryStyle2();

		// 2. Tạo & sử dụng các đối tượng thuộc hệ sinh thái 
		// của nhà máy
		DongVatAnThit x = f.createDongVatAnThit();
		DongVatAnCo y = f.createDongVatAnCo();

		// 3. Sử dụng các đối tượng THUỘC CÙNG STYLE
		x.đuổiTheo(y);
	}

}
