package com.pcg.spring.Controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.pcg.spring.common.RentCarParsing;
import com.pcg.spring.dao.JSPBoardDao;
import com.pcg.spring.dao.JSPMemberDao;
import com.pcg.spring.dao.RentCarDao;
import com.pcg.spring.dao.ReserveDao;
import com.pcg.spring.dto.JSPBoard;
import com.pcg.spring.dto.JSPMember;
import com.pcg.spring.dto.RentCarBDto;
import com.pcg.spring.dto.RentReservedto;
import com.pcg.spring.dto.ReserveView;

/**
 * Servlet implementation class BoardFrontController
 */

@Controller
public class RentcarController {
	private static final Logger logger = LoggerFactory.getLogger(RentcarController.class);

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/Main")
	public String main(HttpServletRequest request, Model model) {

		return "/Main";
	}

	@RequestMapping("/CarReserveMain")
	public String CarReserveMain(HttpServletRequest request, Model model) {
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);
		int num = dao.selectAll().size();

		model.addAttribute("list", dao.selectAll().subList(num - 3, num));

		return "Main.jsp?center=CarReserveMain";
	}

	@RequestMapping("/BatchForm")
	public String BatchForm(HttpServletRequest request, Model model) {

		return "Main.jsp?center=BatchForm";
	}

	@RequestMapping("/BatchProc")
	public String batchProc(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);

		String content = request.getParameter("content");

		String[] contents = content.split("#");
		RentCarBDto dto = null;
		for (String x : contents) {
			if (x == null) {
				continue;
			}
			try {
				dto = RentCarParsing.parsing(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		dao.insert(dto.getNo(), dto.getName(), dto.getCategory(), dto.getPrice(), dto.getUsepeople(), dto.getCompany(),
				dto.getImg(), dto.getInfo());

		return "Main.jsp?center=BatchProc";
	}

	@RequestMapping("/Login")
	public String login(HttpServletRequest request, Model model) {

		return "Main.jsp?center=Login";
	}

	@RequestMapping("/Logout")
	public String logout(HttpServletRequest request, Model model) {

		return "Main.jsp?center=Logout";
	}

	@RequestMapping("/LoginProc")
	public String LoginProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		JSPMemberDao dao = sqlSession.getMapper(JSPMemberDao.class);

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		int res = dao.login(id, pass);

		model.addAttribute("res", res);
		model.addAttribute("id", id);

		return "Main.jsp?center=LoginProc";
	}

	@RequestMapping("/CarAllList")
	public String carAllList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);

		int perPage = 6; // (1) 화면에 보여질 글 갯수
		int perBlock = 5; // (2) 화면 하단에 보여질 패이지 블럭의 페이지 갯수

		int rowCount = dao.selectAll().size(); // 전체 글의 갯수를 저장하는 변수

		// 현재 보고자 하는 페이지 와 페이지 블럭
		// 현재 카운터를 클릭한 번호값을 읽어옴
		String pageNum = request.getParameter("pageNum");

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
		List<RentCarBDto> list = dao.selectAll().subList(pm.startRow - 1, pm.endRow);
		System.out.println(list);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentBlock", currentBlock);
		model.addAttribute("list", list);
		model.addAttribute("number", number);
		model.addAttribute("pagenation", pm.getPagenation("CarAllList"));
		model.addAttribute("pageCount", pm.pageCount);

		return "Main.jsp?center=CarAllList";
	}

	@RequestMapping("/Adjust")
	public String adjust(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ReserveDao dao = sqlSession.getMapper(ReserveDao.class);

		int regno = Integer.parseInt(request.getParameter("regno"));

		RentReservedto vo = dao.selectRegNo(regno);

		model.addAttribute("vo", vo);

		return "Main.jsp?center=Adjust";

	}

	@RequestMapping("/Delete")
	public String delete(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();

		int regno = Integer.parseInt(request.getParameter("regno"));

		session.setAttribute("regno", regno);

		return "Main.jsp?center=Delete";

	}

	@RequestMapping("/DeleteConfirm")
	public String deleteConfirm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ReserveDao dao = sqlSession.getMapper(ReserveDao.class);

		int regno = (int) session.getAttribute("regno");

		dao.delete(regno);

		return "Main.jsp?center=DeleteConfirm";

	}

	@RequestMapping("/AdjustProc")
	public String adjustProc(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ReserveDao dao = sqlSession.getMapper(ReserveDao.class);

		int no = Integer.parseInt(request.getParameter("no"));
		String rday = request.getParameter("rday");
		int dday = Integer.parseInt(request.getParameter("dday"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int insurance = Integer.parseInt(request.getParameter("insurance"));
		int wifi = Integer.parseInt(request.getParameter("wifi"));
		int navigation = Integer.parseInt(request.getParameter("navigation"));
		int babyseat = Integer.parseInt(request.getParameter("babyseat"));

		String memid = request.getParameter("memid");
		int regno = Integer.parseInt(request.getParameter("regno"));

		dao.update(no, rday, dday, qty, insurance, wifi, navigation, babyseat, memid, regno);

		model.addAttribute("memid", memid);

		return "Main.jsp?center=AdjustProc";

	}

	@RequestMapping("/ReserveView")
	public String reserveView(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		ReserveDao dao = sqlSession.getMapper(ReserveDao.class);

		String memid = (String) session.getAttribute("id");
		if (memid == null || memid.equals("GUEST")) {
			List<ReserveView> list = dao.selectAllView("");
			model.addAttribute("list", list);
			return "Main.jsp?center=ReserveView";
		}

		List<ReserveView> list = dao.selectAllView(memid);

		// list = dao.getReserveViewData(memid);

		model.addAttribute("list", list);
		return "Main.jsp?center=ReserveView";

	}

	@RequestMapping("/CarCategoryList")
	public String carCategoryList(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);

		int category = Integer.parseInt(request.getParameter("category"));

		int rowCount = 0;// dao.getAllCount(); //전체 글의 갯수를 저장하는 변수

		List<RentCarBDto> list = dao.selectCategory(category);
		rowCount = list.size();

		model.addAttribute("list", list);
		model.addAttribute("rowCount", rowCount);
		model.addAttribute("category", category);

		return "Main.jsp?center=CarCategoryList";

	}

	@RequestMapping("/CarReserveInfo")
	public String carReserveInfo(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);

		int no = Integer.parseInt(request.getParameter("no"));

		RentCarBDto dto = dao.selectNo(no);

		model.addAttribute("dto", dto);
		model.addAttribute("no", no);

		return "Main.jsp?center=CarReserveInfo";

	}

	@RequestMapping("/CarOptionSelect")
	public String carOptionSelect(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		RentCarDao dao = sqlSession.getMapper(RentCarDao.class);

		int no = Integer.parseInt(request.getParameter("no"));

		RentCarBDto dto = dao.selectNo(no);

		model.addAttribute("dto", dto);
		model.addAttribute("no", no);

		return "Main.jsp?center=CarOptionSelect";

	}

	@RequestMapping("/CarReserveResult")
	public String carReserveResult(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		int no = Integer.parseInt(request.getParameter("no"));

		RentCarDao rdao = sqlSession.getMapper(RentCarDao.class);
		ReserveDao dao = sqlSession.getMapper(ReserveDao.class);

		RentCarBDto dto = rdao.selectNo(no);
		RentReservedto rbean = new RentReservedto();

		rbean.setDday(Integer.parseInt(request.getParameter("dday")));
		rbean.setRday(request.getParameter("rday"));
		rbean.setInsurance(Integer.parseInt(request.getParameter("insurance")));
		rbean.setWifi(Integer.parseInt(request.getParameter("wifi")));
		rbean.setNavigation(Integer.parseInt(request.getParameter("navigation")));
		rbean.setBabyseat(Integer.parseInt(request.getParameter("babyseat")));
		rbean.setQty(Integer.parseInt(request.getParameter("qty")));
		rbean.setNo(Integer.parseInt(request.getParameter("no")));

		model.addAttribute("no", no);
		model.addAttribute("rentCar", dto);
		model.addAttribute("rbean", rbean);
		model.addAttribute("rado", rdao);
		model.addAttribute("dao", dao);

		return "Main.jsp?center=CarReserveResult";

	}

}
