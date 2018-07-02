package com.xp.demo;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ClothesProxyFactory implements MethodInterceptor{
	
	private  Clothes cloths;
	
	public ClothesProxyFactory() {
		super();
	}

	public ClothesProxyFactory(Clothes cloths) {
		super();
		this.cloths = cloths;
	}

	public Clothes myProxyCreator(){
		//增强器
		Enhancer enhancer=new Enhancer();
		//指定父类，即要增强的目标类
		enhancer.setSuperclass(Clothes.class);
		enhancer.setCallback(this);
		return (Clothes) enhancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		if("discout".equals(method.getName())){
			return ((BigDecimal)method.invoke(cloths, args)).multiply(new BigDecimal(0.5));
		}else{
			return method.invoke(cloths, args);
		}
	}
}