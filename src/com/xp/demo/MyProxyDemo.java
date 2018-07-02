package com.xp.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class MyProxyDemo {

	public static void main(String[] args) {
		//定义目标对象
		final IClothes cloths=new Jacket();
		//定义目标对象的代理对象
		
		IClothes jacket=(IClothes) Proxy.newProxyInstance(
				cloths.getClass().getClassLoader(),	//目标类的类加载器
				cloths.getClass().getInterfaces(),	//目标类实现的所有接口
				new InvocationHandler() {			//内部匿名类（动态代理复用性不强）
					//这里完成增强
					//proxy:代理对象
					//method:目标方法
					//args:目标方法的参数列表
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if("discout".equals(method.getName())){
							return ((BigDecimal)method.invoke(cloths, args)).multiply(new BigDecimal(0.5));
						}else{
							return method.invoke(cloths, args);
						}
					}
				});
		
		BigDecimal price=jacket.price();
		System.out.println("Jacket,原价："+price+"块/件");
		BigDecimal discout=jacket.discout();
		System.out.println("Jacket,打折后售价："+discout+"块/件");
	}
}
