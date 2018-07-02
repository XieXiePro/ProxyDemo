package com.xp.demo;

import java.math.BigDecimal;

/**
 * 目标类
 * @author XP
 *
 */
public class Jacket implements IClothes {
	/**
	 * 售价
	 */
	public BigDecimal price() {
		return new BigDecimal(100);
	}
}