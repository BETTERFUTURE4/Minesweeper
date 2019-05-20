package com.traeper.guestbookapp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.traeper.guestbookapp.vo.GuestBookVO;

@Service
public class MybatisGuestBookDAO implements GuestBookDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public String create(GuestBookVO guestBookVO) {
		sqlSession.insert("createGuestbook", guestBookVO);
		return guestBookVO.getGuestbookId();
	}

	@Override
	public List<GuestBookVO> retrieve() {
		return sqlSession.selectList("getGuestbooks");
	}

	@Override
	public void update(GuestBookVO guestBookVO) {
		sqlSession.update("updateGuestbook", guestBookVO);
	}

	@Override
	public void delete(String guestBookId) {
		sqlSession.delete("deleteGuestbook", guestBookId);
	}

	@Override
	public GuestBookVO getGuestbook(String guestbookId) {
		return sqlSession.selectOne("getGuestbook", guestbookId);
	}

}
