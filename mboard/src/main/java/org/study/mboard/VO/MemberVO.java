package org.study.mboard.VO;

import java.sql.Date;
/**
 * 회원 정보를 담고있는 VO클래스.
 * @author Song
 *
 */
public class MemberVO {
	Integer m_num;
	String m_id;
	String m_name;
	Date regdate;
	Date updatedate;
	public Integer getM_num() {
		return m_num;
	}
	public void setM_num(Integer m_num) {
		this.m_num = m_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	@Override
	public String toString() {
		return "MemberVO [m_num=" + m_num + ", m_id=" + m_id + ", m_name=" + m_name + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + "]";
	}
	
	
}
