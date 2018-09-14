package org.study.mboard;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.study.mboard.DAO.MemberDAO;
import org.study.mboard.VO.Criteria;
import org.study.mboard.VO.MemberVO;
import org.study.mboard.VO.PageMaker;

/**
 * 애플리케이션의 모든 요청을 담당한다.
 * 메인페이지 리스트, 회원등록, 삭제.
 * @author Song
 *
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	MemberDAO dao;
	/**
	 * 메인 페이지, 회원 리스트를 보여준다.
	 * @param cri 페이지번호,리스트 출력수 를 포함한 VO.
	 * @param model 회원 리스트를 담는 파라메터.
	 * @return 메인페이지
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(@ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		model.addAttribute("list", dao.list(cri));
		PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(dao.countPaging(cri));
	    model.addAttribute("pageMaker", pageMaker);
		return "index";
	}
	
	/**
	 * 등록페이지 이동
	 */
	@RequestMapping(value ="/regist", method = RequestMethod.GET)
	public void regist() {

	}
	
	/**
	 * 등록페이지에서 등록처리
	 * @param vo 등록에 필요한 점보를 담는 MemberVO
	 * @param rttr 요청의 결과를 출력
	 * @return 메인페이지로 이동
	 */
	@RequestMapping(value ="/regist", method = RequestMethod.POST)
	public String registPro(MemberVO vo, RedirectAttributes rttr) {
		logger.info("regist called");
		try {
			dao.regist(vo);
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("msg", "FALSE");
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/";
	}
	
	/**
	 * 삭제처리를 수행
	 * @param m_num 삭제할 리스트의 회원번호
	 * @param rttr 요청의 결과를 출력
	 * @return 메인페이지로 이동
	 */
	@RequestMapping(value ="/delete", method = RequestMethod.GET)
	public String delete(int m_num, RedirectAttributes rttr) {
		logger.info("delete called");
		try {
			dao.delete(m_num);
		} catch (Exception e) {
			e.printStackTrace();
			rttr.addFlashAttribute("msg", "FALSE");
			return "redirect:/";
		}
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/";
	}
}
