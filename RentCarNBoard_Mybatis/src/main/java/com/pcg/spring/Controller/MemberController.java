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
import com.pcg.spring.dao.JSPMemberDao;
import com.pcg.spring.dto.JSPBoard;
import com.pcg.spring.dto.JSPMember;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/MemberList")
	public String memberList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);

		int rowCount = dao.selectAll().size();
		List<JSPMember> list = dao.selectAll();

		model.addAttribute("rowCount", rowCount);
		model.addAttribute("list", list);

		return joinroot + "MemberList";
	}

	@RequestMapping("/MemberJoin")
	public String memberJoin(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);

		return joinroot + "MemberJoin";
	}
	
	
	
	

	@RequestMapping("/MemberInfo")
	public String memberInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);
		// JSPMember dto = sqlSession.getMapper(JSPMember.class);

		String id = request.getParameter("id");

		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberInfo";
	}

	@RequestMapping("/MemberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);
		// JSPMember dto = sqlSession.getMapper(JSPMember.class);

		String id = request.getParameter("id");

		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberUpdateForm";
	}

	@RequestMapping("/MemberUpdateProc")
	public String MemberUpdateProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);

		// JSPMember dto = sqlSession.getMapper(JSPMember.class);

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String job = request.getParameter("job");
		String age = request.getParameter("age");
		String hobby = request.getParameter("hobby");

		String pass = request.getParameter("pass");

		JSPMember dto = dao.select(id);

		int res = 0;
		if (dto.getPass().equals(pass)) {
			dao.update(email, tel, job, hobby, id);
			res = 1;
		}

		model.addAttribute("res", res);
		model.addAttribute("dto", dto);

		return joinroot + "MemberUpdateProc";
	}

	@RequestMapping("/MemberDeleteForm")
	public String memberDeleteForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);
		// JSPMember dto = sqlSession.getMapper(JSPMember.class);

		String id = request.getParameter("id");

		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		return joinroot + "MemberDeleteForm";
	}

	@RequestMapping("/MemberDeleteProc")
	public String memberDeleteProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);
		// JSPMember dto = sqlSession.getMapper(JSPMember.class);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		JSPMember dto = dao.select(id);

		model.addAttribute("dto", dto);

		int res = 0;
		if (dto.getPass().equals(pass)) {
			dao.delete(id);
			res = 1;
		}

		model.addAttribute("res", res);
		model.addAttribute("dto", dto);

		return joinroot + "MemberDeleteProc";
	}

	@RequestMapping("/JoinProc")
	public String JoinProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String joinroot = (String) session.getAttribute("joinroot");
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String age = request.getParameter("age");
		String job = request.getParameter("job");
		String[] hobbys = request.getParameterValues("hobby");

		int res = 0;
		if(hobbys == null) {
			model.addAttribute("res", res);
			return joinroot + "JoinProc";
		}
		
		String hobby = "";
	
		for (String x : hobbys) {
			hobby += x + " ";
		}
		hobby = hobby.trim();

		if ((id != null && !id.equals("")) && (pass != null && !pass.equals("")) && (email != null && !email.equals(""))
				&& (tel != null && !tel.equals("")) && (age != null && !age.equals(""))
				&& (job != null && !job.equals("")) && (hobby != null && !hobby.equals(""))) {

			
			dao.insert(id, pass, email, tel, age, job, hobby);
			res = 1;
		}
	
		model.addAttribute("res", res);
		
		return joinroot + "JoinProc";
	}

}
