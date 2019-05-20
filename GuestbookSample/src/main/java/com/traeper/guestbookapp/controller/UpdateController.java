package com.traeper.guestbookapp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.traeper.guestbookapp.dao.GuestBookDAO;
import com.traeper.guestbookapp.dao.JDBCGuestBookDAO;
import com.traeper.guestbookapp.dao.MybatisGuestBookDAO;
import com.traeper.guestbookapp.vo.GuestBookVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UpdateController {   
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GuestBookDAO guestBookDAO;
	
	
	@RequestMapping(value = "/update/{guestbookId}")
	public ModelAndView update(@PathVariable("guestbookId") String guestbookId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("guestbook", guestBookDAO.getGuestbook(guestbookId));
		mv.setViewName("update");
		return mv;
	}
		
	@RequestMapping(value = "/updateRequest", method = RequestMethod.POST)
	public void updateRequest(@ModelAttribute GuestBookVO guestBookVO, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		logger.info(guestBookVO.toString());
		//TODO 1. 예외처리 코드 작성 필요. ( XSS방어 등 )
		//TODO 2. 비밀번호 체크 필요. ( AOP? if문? )
		guestBookDAO.update(guestBookVO);
		response.sendRedirect("/");
	}
	
	
}
