package com.traeper.guestbookapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.traeper.guestbookapp.vo.GuestBookVO;

public class SampleGuestBookDAO implements GuestBookDAO {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public String create(GuestBookVO guestBookVO) {
		logger.debug("SampleGuestBookDAO create!!");
		return null;
	}

	@Override
	public List<GuestBookVO> retrieve() {
		List<GuestBookVO> list = new ArrayList<GuestBookVO>();
		list.add(new GuestBookVO("1", "title", "content", "registerDate", "password"));
		list.add(new GuestBookVO("2", "title", "content", "registerDate", "password"));
		list.add(new GuestBookVO("3", "title", "content", "registerDate", "password"));
		list.add(new GuestBookVO("4", "title", "content", "registerDate", "password"));
		return list;
	}

	@Override
	public void update(GuestBookVO guestBookVO) {
		logger.debug("SampleGuestBookDAO update!!");
	}

	@Override
	public void delete(String guestBookId) {
		logger.debug("SampleGuestBookDAO delete!!");
	}

	@Override
	public GuestBookVO getGuestbook(String guestbookId) {
		logger.debug("SampleGuestBookDAO getGuestbook!!");
		return null;
	}

}
