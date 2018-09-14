package org.study.mboard.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.study.mboard.VO.Criteria;
import org.study.mboard.VO.MemberVO;
/**
 * 데이터 베이스 요청을 처리하는 클래스.
 * @author Song
 *
 */
@Repository
public class MemberDAO {
	private static final String nameSpace = "org.study.mboard.Mapper";
	@Autowired
	private SqlSession session;
	
	/**
	 * 회원정보를 리스트로 불러온다.
	 * @param cri 현제 리스트 페이지의 번호와 리스트 개수를 갖는 VO클래스.
	 * @return List<MemberVO>
	 * @throws Exception
	 */
	public List<MemberVO> list(Criteria cri) throws Exception{
		return session.selectList(nameSpace +".list", cri);
	}
	
	/**
	 * 회원정보의 총 수.
	 * @param cri 현제 리스트 페이지의 번호와 리스트 개수를 갖는 VO클래스. 
	 * @return int 회원정보의 총 수.
	 * @throws Exception
	 */
	public int countPaging(Criteria cri) throws Exception{
		return session.selectOne(nameSpace + ".countPaging", cri);
	}
	
	/**
	 * 회원 등록처리.
	 * @param vo 입력한 등록대상의 회원 정보.
	 * @throws Exception
	 */
	public void regist(MemberVO vo) throws Exception{
		session.insert(nameSpace +".regist", vo);
	}
	
	/**
	 * 회원 삭제처리.
	 * @param m_num 삭제를 위한 회원의 번호.
	 * @throws Exception
	 */
	public void delete(int m_num) throws Exception{
		session.delete(nameSpace+".delete", m_num);
	}
}
