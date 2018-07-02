package com.xp.demo;

import java.math.BigDecimal;

public class MyProxyDemo {

	public static void main(String[] args) {
		//定义目标对象
		IClothes cloths=new Jacket();
		//定义目标对象的代理对象
		IClothes jacket=new JacketProxy(cloths);
		BigDecimal val=jacket.price();
	
		System.out.println("Jacket："+val+"块/件");
	}
}
