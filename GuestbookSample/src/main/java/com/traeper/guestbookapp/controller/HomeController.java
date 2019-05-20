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
public class HomeController {   
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	GuestBookDAO guestBookDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		
		if( guestBookDAO instanceof MybatisGuestBookDAO) {
			logger.info("guestBookDAO's instance is MybatisGuestBookDAO's one");
		}
		
		mv.addObject("guestbooks", guestBookDAO.retrieve());
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public void write(@ModelAttribute GuestBookVO guestBookVO, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		logger.info(guestBookVO.toString());
//		guestBookDAO.create(guestBookVO);
		response.sendRedirect("/");
	}	
	
		
	
	
}
