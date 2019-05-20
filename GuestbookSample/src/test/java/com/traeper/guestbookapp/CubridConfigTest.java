package com.traeper.guestbookapp;

import org.junit.Assert;
import org.junit.Test;

/**
 * Cubrid Configuration Test
 * @author traeper
 *
 */
public class CubridConfigTest {

	@Test
	public void cubridConfigTest() throws ClassNotFoundException {
		Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
		Assert.assertTrue(true);
	}
	
}
