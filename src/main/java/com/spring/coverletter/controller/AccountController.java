package com.spring.coverletter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.coverletter.impl.UserDAO;
import com.spring.coverletter.impl.UserDO;

@Controller
@RequestMapping("/account")
public class AccountController {
	UserDAO udao = new UserDAO();
	 
	@RequestMapping(value = "/myAccount")
	public String Account(HttpServletRequest request, UserDO udo,Model model) {
		System.out.println("AccountController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

		udo = udao.getMyInfo(user_id);

		model.addAttribute("user", udo);

		return "/account/account";
	}

	@RequestMapping(value = "/myAccountModify")
	public String AccountModify(HttpServletRequest request,UserDO udo,Model model) {
		System.out.println("AccountModifyController ==>");
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("id");

		udo = udao.getMyInfo(user_id);

		model.addAttribute("user", udo);

		return "/account/accountModify";
	}

	@RequestMapping(value = "/myAccountModifyProc")
	public String AccountModifyProc(HttpServletRequest request,@ModelAttribute UserDO udo,Model model) {
		System.out.println("AccountModifyController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String pw = request.getParameter("pw");
//		Integer age = Integer.valueOf(request.getParameter("age"));
//		udo.setId(id);
//		udo.setName(name);
//		udo.setPw(pw);
//		udo.setAge(age);

		udo = udao.modifyMyinfo(udo, user_id);

		model.addAttribute("user", udo);
		return "/account/account";
	}

	@RequestMapping(value = "/deleteMyAccount")
	public String DeleteAccount(HttpServletRequest request, UserDO udo,Model model) {
		System.out.println("AccountModifyController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

		udao.deleteUser(user_id);

		session.invalidate();

		return "redirect:/";
	}
}
