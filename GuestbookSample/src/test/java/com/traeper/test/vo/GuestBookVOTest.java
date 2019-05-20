package com.traeper.test.vo;

import junit.framework.Assert;

import org.junit.Test;

import com.traeper.guestbookapp.vo.GuestBookVO;

public class GuestBookVOTest {
	
	@Test
	public void guestbookVONullTest() {
		GuestBookVO vo = new GuestBookVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setRegisterDate("date");
		vo.setPassword("password");
		
		if( vo.getTitle() == null ||
				vo.getContent() == null ||
				vo.getPassword() == null ||
				vo.getRegisterDate() == null) {
			Assert.assertFalse(true);
		} else {
			Assert.assertTrue(true);
		}
	}
	
	
	
	
}
