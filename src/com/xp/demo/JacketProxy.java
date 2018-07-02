package com.xp.demo;

import java.math.BigDecimal;

/**
 * 静态代理类
 * @author XP
 * 
 */
public class JacketProxy implements IClothes {
	IClothes jacketProxy;
	public JacketProxy() {
		super();
	}
	
	public JacketProxy(IClothes jacketProxy) {
		super();
		this.jacketProxy = jacketProxy;
	}

	/**
	 * 售价打折方法
	 */
	public BigDecimal price() {
		return jacketProxy.price().multiply(new BigDecimal(0.5));
	}
}