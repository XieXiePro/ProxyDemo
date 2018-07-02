package com.xp.demo;

import java.math.BigDecimal;

public class MyProxyDemo {

	public static void main(String[] args) {
		//定义目标对象
		final Clothes cloths=new Clothes();
		//定义目标对象的代理对象
		
		Clothes jacket=new ClothesProxyFactory(cloths).myProxyCreator();
		
		BigDecimal price=jacket.price();
		System.out.println("Jacket,原价："+price+"块/件");
		BigDecimal discout=jacket.discout();
		System.out.println("Jacket,打折后售价："+discout+"块/件");
	}
}
