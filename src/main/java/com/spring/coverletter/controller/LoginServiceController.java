package com.spring.coverletter.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.coverletter.impl.BoardDAO;
import com.spring.coverletter.impl.BoardDO;
import com.spring.coverletter.impl.UserDAO;
import com.spring.coverletter.impl.UserDO;

@Controller
@RequestMapping("/loginService")
public class LoginServiceController {

	private final UserDAO udao = new UserDAO();
	private final BoardDAO bdao = new BoardDAO();
    
	@RequestMapping(value = "/login")
 	public String Login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LoginController ==>");

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			String saveId = "";
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("id")) {
					saveId = cookies[i].getValue();
					break;
				}
			}
			Cookie cookie = new Cookie("saveId", saveId);
			response.addCookie(cookie);
		}

		return "/loginService/login";
	}

	@PostMapping(value = "/loginProc")
	public String LoginProc(HttpServletRequest request, HttpServletResponse response, UserDO udo,
			@RequestParam String id,@RequestParam String pw,@RequestParam(required=false) String rememberId,
			ArrayList<UserDO> uList,ArrayList<BoardDO> bList,Model model) {
		System.out.println("LoginProcController ==>");

		HttpSession session = request.getSession();

		uList = udao.getUserList();

		for (UserDO user : uList) {
			if (user.getId().equals(id) && user.getPw().equals(pw)) {
				if ("1".equals(rememberId)) {
					Cookie cookie = new Cookie("id", id);
					cookie.setSecure(true);
					response.addCookie(cookie);
				}

				session.setAttribute("id", id);

				udao.setLoginDate(id);

				bList = bdao.getMyBoardList(id);
				model.addAttribute("bList", bList);

				return "redirect:/board/main";
			}
		}

		return "/loginService/login";
	}

	@RequestMapping(value = "/memberJoin")
	public String MemberJoin() {
		System.out.println("MemberJoinController ==>");
		return "/loginService/memberJoin";
	}

	@PostMapping(value = "/memberJoinProc")
	public String MemberJoinProc(@RequestParam String id,@RequestParam String pw,
            @RequestParam(required=false) String name, @RequestParam(required=false) Integer age,UserDO udo) {
		System.out.println("MemberJoinProcController ==>");

		udo.setId(id);
		udo.setPw(pw);
		udo.setName(name);
		udo.setAge(age);

		udao.insertUser(udo);

		return "/loginService/login";
	}

	@RequestMapping(value = "/logout")
	public String Logout(HttpServletRequest request,ArrayList<BoardDO> bList, Model model) {
		System.out.println("LogoutController ==>");

		HttpSession session = request.getSession();
		session.invalidate();

		bList = bdao.getPublicBoardList();

		model.addAttribute("bList", bList);

		return "redirect:/";
	}
}