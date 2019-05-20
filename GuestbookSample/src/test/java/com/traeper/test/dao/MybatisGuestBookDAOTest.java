package com.traeper.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.traeper.guestbookapp.dao.MybatisGuestBookDAO;
import com.traeper.guestbookapp.vo.GuestBookVO;

public class MybatisGuestBookDAOTest {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	MybatisGuestBookDAO mybatisGueestBookDAO;
	
	@Before
	public void instanciate() {
		mybatisGueestBookDAO = new MybatisGuestBookDAO();
	}
	
	@Test 
	public void crudTest() {
//		retrieve();
//		String lastInsertedKey = create();
//		update();
//		delete(lastInsertedKey);
//		retrieve();
	}
	
	private String create() {
		GuestBookVO guestBookVO = new GuestBookVO("1", "title", "content", "", "password");
		mybatisGueestBookDAO.create(guestBookVO);
		return guestBookVO.getGuestbookId();
	}
	
	private void retrieve() {
		List<GuestBookVO> list = mybatisGueestBookDAO.retrieve();
		for (GuestBookVO guestBookVO : list) {
			System.out.println(guestBookVO);
			logger.debug(guestBookVO.toString());
		}
		Assert.assertTrue(true);
	}

	private void update() {
		mybatisGueestBookDAO.update(new GuestBookVO("1", "updatedtitle", "updatedcontent", "", "password"));
	}
	
	private void delete(String lastInsertedKey) {
		mybatisGueestBookDAO.delete(lastInsertedKey);
	}
	
	
	
}
