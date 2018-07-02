package com.xp.demo;

import java.math.BigDecimal;

/**
 * 目标类
 * @author XP
 *
 */
public class Jacket implements IClothes {
	/**
	 * 原价
	 */
	public BigDecimal price() {
		return new BigDecimal(100);
	}
	/**
	 * 不打折，返回原价
	 */
	public BigDecimal discout() {
		return price();
	}
}