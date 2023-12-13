package com.spring.coverletter.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.coverletter.impl.BoardDAO;
import com.spring.coverletter.impl.BoardDO;
import com.spring.coverletter.impl.QuestionDAO;
import com.spring.coverletter.impl.QuestionsDO;

@Controller
@RequestMapping("/board")
public class BoardController {

	private BoardDAO bdao = new BoardDAO();
	private QuestionDAO qdao = new QuestionDAO();
	
	// 내 자소서 전체 보기
	@RequestMapping(value = "/main")
	public String Main(HttpServletRequest request,ArrayList<BoardDO> bList,Model model) {
		System.out.println("MainController ==>");

		HttpSession session = request.getSession();

		if (session.getAttribute("id") != null) {
			String writer_id = (String) session.getAttribute("id");
			bList = bdao.getMyBoardList(writer_id);
			model.addAttribute("bList", bList);

			return "/board/main";
		} else {
			return "redirect:/";
		}

	}

	// 내 자소서 상세 보기
	@RequestMapping(value = "/myPage")
	public String MyPage(HttpServletRequest request,@RequestParam Integer boardNum ,BoardDO bdo, ArrayList<QuestionsDO> qList, Model model) {
		System.out.println("MyPageController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

		bdo = bdao.goMyPage(boardNum, user_id);
		qList = qdao.getQuestionList(boardNum);
		model.addAttribute("board", bdo);
		model.addAttribute("qList", qList);

		return "/board/myPage";
	}
	
	// 내 자소서 등록 페이지 이동
	@RequestMapping(value = "/upload")
	public String Upload() {
		System.out.println("UploadController ==>");

		return "/board/upload";
	}

	// 내 자소서 등록
	@RequestMapping(value = "/uploadProc")
	public String UploadProc(HttpServletRequest request,@RequestParam String company,
			@RequestParam String job,@RequestParam String open,@RequestParam String question,
			@RequestParam String content,BoardDO bdo,QuestionsDO qdo,Model model) {
		System.out.println("UploadProcController ==> ");

		HttpSession session = request.getSession();

		String writer_id = (String) session.getAttribute("id");
		
		bdo.setWriter_id(writer_id);
		bdo.setCompany(company);
		bdo.setJob(job);
		bdo.setOpen(open);

		int board_id = bdao.uploadBoard(bdo);
		qdo.setContent(content);
		qdo.setQuestion(question);
		qdao.uploadQuestions(qdo, board_id);

		ArrayList<BoardDO> bList = bdao.getMyBoardList(writer_id);
		model.addAttribute("bList", bList);

		return "/board/main";
	}
	
	// 내 자소서에서 검색
	@RequestMapping(value = "search")
	public String Search(HttpServletRequest request,@RequestParam String type,@RequestParam String keyword,
						ArrayList<BoardDO> bList, Model model) {
		System.out.println("SearchController ==>");

		bList = bdao.SearchBoard(type, keyword);

		model.addAttribute("bList", bList);
		return "/board/main";
	}
	
	// 내 자소서 수정 페이지로 이동
	@GetMapping(value = "/modifyPage")
	public String ModifyPage(HttpServletRequest request,@RequestParam Integer boardNum,
			BoardDO bdo,ArrayList<QuestionsDO> qList,Model model) {
		System.out.println("ModifyPageController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

		bdo = bdao.goMyPage(boardNum, user_id);
		qList = qdao.getQuestionList(boardNum);

		model.addAttribute("board", bdo);
		model.addAttribute("qList", qList);

		return "/board/modifyPage";
	}

	// 내 자소서 수정
	@PostMapping(value = "/modifyPageProc")
	public String ModifyPageProc(HttpServletRequest request,@RequestParam Integer boardNum,
			@RequestParam String question,@RequestParam String content,
			@ModelAttribute BoardDO bdo,QuestionsDO qdo,ArrayList<QuestionsDO> qList,Model model) {
		System.out.println("ModifyPageProcController ==>");

		bdo.setBoard_id(boardNum);

		bdao.modifyBoard(bdo);

		qdo.setQuestion(question);
		qdo.setContent(content);
		qdo.setBoard_id(boardNum);

		qList = qdao.modifyQuestions(qdo);

		model.addAttribute("board", bdo);
		model.addAttribute("qList", qList);

		return "/board/myPage";
	}

	// 내 자소서 삭제
	@RequestMapping(value = "/deletePage")
	public String DeletePage(HttpServletRequest request,@RequestParam Integer boardNum,
			ArrayList<BoardDO> bList, Model model) {
		System.out.println("DeletePageController ==>");

		HttpSession session = request.getSession();

		String user_id = (String) session.getAttribute("id");

		bdao.deleteBoard(boardNum, user_id);

		bList = bdao.getMyBoardList(user_id);
		model.addAttribute("bList", bList);

		return "/board/main";
	}

	// 공개 자소서 전체 보기
	@RequestMapping(value = "/total")
	public String Total(ArrayList<BoardDO> bList, Model model) {
		System.out.println("TotalController ==>");

		bList = bdao.getPublicBoardList();

		model.addAttribute("bList", bList);

		return "/board/total";
	}

	// 공개 자소서 상세 보기
	@RequestMapping(value = "/page")
	public String Page(HttpServletRequest request,@RequestParam Integer boardNum ,BoardDO bdo, ArrayList<QuestionsDO> qList, Model model) {
		System.out.println("PageController ==>");

		bdo = bdao.goTotalPage(boardNum);
		qList = qdao.getQuestionList(boardNum);

		model.addAttribute("board", bdo);
		model.addAttribute("qList", qList);

		return "/board/page";
	}

	// 공개 자소서 검색
	@RequestMapping(value = "/publicSearch")
	public String PublicSearch(HttpServletRequest request, BoardDAO bdao, ArrayList<BoardDO> bList, Model model) {
		System.out.println("PublicSearchController ==>");

		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");

		bList = bdao.PublicSearchBoard(type, keyword);

		model.addAttribute("bList", bList);
		
		return "/board/total";
	}
}
