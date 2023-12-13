package com.spring.coverletter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.coverletter.impl.BoardDAO;
import com.spring.coverletter.impl.BoardDO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest request,
			BoardDAO bdao,ArrayList<BoardDO> bList) {
		
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("id");
		
		if(id == null) {
			bList = bdao.getPublicBoardList();

			model.addAttribute("bList",bList);
		}
		
		return "home";
	}
	
}
