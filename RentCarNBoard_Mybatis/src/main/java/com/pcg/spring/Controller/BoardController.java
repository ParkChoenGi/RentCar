package com.pcg.spring.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pcg.spring.common.PageManager;
import com.pcg.spring.dao.JSPBoardDao;
import com.pcg.spring.dto.JSPBoard;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/BoardList")
	public String boardList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		int perPage = 10; // (1) 화면에 보여질 글 갯수
		int perBlock = 10; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수

		int rowCount = dao.selectAll().size(); // 전체 글의 갯수를 저장하는 변수

		// 현재 보고자 하는 페이지 와 페이지 블럭
		// 현재 카운터를 클릭한 번호값을 읽어옴
		String pageNum = request.getParameter("pageNum");
		// 만약 처음 boardList.jsp 를 클릭하거나 수정 삭제 등 다른 게시글에서 이 페이지로 넘어오면
		// pageNum값이 없어서 null처리를 해줌
		if (pageNum == null) {
			pageNum = "1";
		}
		// (4)------------------------------------
		int currentPage = Integer.parseInt(pageNum);
		String blockNum = request.getParameter("blockNum");
		if (blockNum == null) {
			blockNum = "1";
		}
		// (5)-------------------------------------
		int currentBlock = Integer.parseInt(blockNum);
		// 페이지 관리 객체를 생성 - new PageManager((1), (2))
		PageManager pm = new PageManager(perPage, perBlock);
		// 페이지 관리 객체 환경설정 - pm.setRowCount((3),(4),(5))
		pm.setRowCount(rowCount, currentPage, currentBlock);
		// 테이블에 표시할 번호를 지정 - 거꾸로 줄력해 나갈것임.
		int number = pm.number;
		List<JSPBoard> list = dao.selectAll().subList(pm.startRow - 1, pm.endRow);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("list", list);
		model.addAttribute("number", number);
		model.addAttribute("pagenation", pm.getPagenation(root + "BoardList"));
		model.addAttribute("pageCount", pm.pageCount);

		return root + "BoardList";
	}

	@RequestMapping("/BoardWriteForm")
	public String BoardWriteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");

		return root + "BoardWriteForm";
	}

	@RequestMapping("/BoardWriteProc")
	public String BoardWriteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");

		int res = 0;
		if ((writer != null && !writer.equals("")) && (subject != null && !subject.equals(""))
				&& (content != null && !content.equals("")) && (password != null && !password.equals(""))) {
			dao.insert(writer, email, subject, password, content);
			res = 1;
		}

		model.addAttribute("res", res);

		return root + "BoardWriteProc";

	}

	@RequestMapping("/BoardInfo")
	public String BoardInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		int num = Integer.parseInt(request.getParameter("num"));

		dao.upHit(num);
		JSPBoard dto = dao.select(num);

		model.addAttribute("dto", dto);

		return root + "BoardInfo";
	}

	@RequestMapping("/BoardDeleteForm")
	public String BoardDeleteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");

		return root + "BoardDeleteForm";
	}

	@RequestMapping("/BoardDeleteProc")
	public String BoardDeleteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		String xpwd = (String) request.getParameter("xpwd");

		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		int num = Integer.parseInt(request.getParameter("num"));

		JSPBoard dto = dao.select(num);

		int res = 0;
		if (dto.getPassword().equals(xpwd)) {
			dao.delete(num);
			res = 1;
		}
		model.addAttribute("res", res);

		return root + "BoardDeleteProc";
	}

	@RequestMapping("/BoardUpdateForm")
	public String BoardUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		String subject = (String) session.getAttribute("subject");
		String content = (String) session.getAttribute("content");

		int num = Integer.parseInt(request.getParameter("num"));

		JSPBoard dto = dao.select(num);

		model.addAttribute("dto", dto);

		return root + "BoardUpdateForm";
	}

	@RequestMapping("/BoardUpdateProc")
	public String BoardUpdateProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pass = request.getParameter("password");

		int num = Integer.parseInt(request.getParameter("num"));

		JSPBoard dto = dao.select(num);

		int res = 0;
		if (dto.getPassword().equals(pass)) {
			dao.update(subject, content, num);
			res = 1;
		}

		model.addAttribute("res", res);

		return root + "BoardUpdateProc";
	}

	@RequestMapping("/BoardReWriteForm")
	public String BoardReWriteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String content = request.getParameter("content");

		int num = Integer.parseInt(request.getParameter("num"));

		JSPBoard dto = dao.select(num);

		int ref = dto.getRef();
		int re_step = dto.getRe_step();// 부모글보다 1증가
		int re_level = dto.getRe_level();//

		model.addAttribute("dto", dto);

		return root + "BoardReWriteForm";
	}

	@RequestMapping("/BoardReWriteProc")
	public String BoardReWriteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String root = (String) session.getAttribute("root");
		JSPBoardDao dao = sqlSession.getMapper(JSPBoardDao.class);

		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
			
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));


		int res = 0;
		if ((writer != null && !writer.equals("")) && (subject != null && !subject.equals(""))
				&& (content != null && !content.equals("")) && (password != null && !password.equals(""))
				&& (email != null && !email.equals("")) ) {
			dao.updateLevel(ref, re_level);
			dao.insert2(writer, email, subject, password, ref, re_step, re_level, content);
			res = 1;
		}

		model.addAttribute("res", res);
		
		return root + "BoardReWriteProc";
	}

}
