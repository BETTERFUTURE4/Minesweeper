package com.traeper.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.traeper.guestbookapp.dao.JDBCGuestBookDAO;
import com.traeper.guestbookapp.vo.GuestBookVO;

public class JDBCGuestBookDAOTest {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	JDBCGuestBookDAO jdbcGueestBookDAO;
	
	@Before
	public void instanciate() {
		jdbcGueestBookDAO = new JDBCGuestBookDAO();
	}
	
	@Test 
	public void crudTest() {
		retrieve();
//		create();
//		update();
//		delete();
		retrieve();
	}
	
	@Ignore
	@Test
	public void create() {
		jdbcGueestBookDAO.create(new GuestBookVO("1", "title", "content", "", "password"));
	}
	
	@Ignore
	@Test
	public void retrieve() {
		List<GuestBookVO> list = jdbcGueestBookDAO.retrieve();
		for (GuestBookVO guestBookVO : list) {
			System.out.println(guestBookVO);
			logger.debug(guestBookVO.toString());
		}
		Assert.assertTrue(true);
	}

	@Ignore
	@Test
	public void update() {
		jdbcGueestBookDAO.update(new GuestBookVO("1", "updatedtitle", "updatedcontent", "", "password"));
	}
	
	@Ignore
	@Test
	public void delete() {
//		jdbcGueestBookDAO.delete();
	}
	
	
	
}
