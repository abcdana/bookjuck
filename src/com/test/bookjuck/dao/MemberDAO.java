package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public MemberDAO() {
		// DB 연결
		conn = DBUtil.open();
	}

	public void close() {

		try {

			conn.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* 최진영 - tos.jsp(이용약관 정보 추가) 시작 */
	public int Tosadd(MemberDTO dto) {
		try {

			String sql = "insert into tblMember(seq, id, pw, name, tel, regDate, address, ssn, login, email, points, privacy, lastDate) values(seqMember.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setInt(4, dto.getTel());
			pstat.setString(5, dto.getRegDate());
			pstat.setString(6, dto.getAddress());
			pstat.setString(7, dto.getSsn());
			pstat.setString(8, dto.getLogin());
			pstat.setString(9, dto.getEmail());
			pstat.setInt(10, dto.getPoints());
			pstat.setInt(11, dto.getPrivacy());
			pstat.setString(12, dto.getLastDate());

			rs = pstat.executeQuery();

			if (rs.next()) {
				return rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	/* 최진영 - tos.jsp(이용약관 정보 추가) 시작 */

	/* 최진영 - registerOK.java(회원가입) 시작 */
	public int add(MemberDTO dto) {

		try {

			String sql = "insert into tblMember (seq, id, pw, name, tel, regdate, address, ssn, login, email, points, privacy, lastdate) values(seqMember.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			String now = format.format(cal.getTime());

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());
			pstat.setString(3, dto.getName());
			pstat.setInt(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			pstat.setString(6, dto.getRegDate());
			pstat.setString(7, dto.getSsn());
			pstat.setString(8, dto.getLogin());
			pstat.setString(9, dto.getEmail());
			pstat.setInt(10, dto.getPoints());
			pstat.setInt(11, dto.getPrivacy());
			pstat.setString(12, dto.getLastDate());

			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	/* 최진영 - registerOK.java(회원가입) 종료 */

	/* 최진영 - Loginok.java(로그인) 시작 */
	public int login(MemberDTO dto) {

		try {

			String sql = "select count(*) as cnt from tblMember where id =? and pw=?";

			pstat = conn.prepareStatement(sql);
			System.out.println("---------------------------------------------------------DAO오류 와드 1");
			pstat.setString(1, dto.getId());
			pstat.setString(2, dto.getPw());

			rs = pstat.executeQuery();
			
			if (rs.next()) {
			

				return rs.getInt("cnt");
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
	/* 최진영 - Loginok.java(로그인) 종료 */

	/* 최진영 - Loginok.java(로그인2) 시작 */
	// Login 서블릿이 id를 건내주면서 회원 정보를 달라고 위임
	public MemberDTO getMember(String id) {
		try {

			String sql = "select * from tblMember where id = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, id);

			rs = pstat.executeQuery();

			if (rs.next()) {
				MemberDTO dto = new MemberDTO();

				dto.setSeq(rs.getString("seq"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getInt("tel"));
				dto.setRegDate(rs.getString("regdate"));
				dto.setAddress(rs.getString("address"));
				dto.setSsn(rs.getString("ssn"));
				dto.setLogin(rs.getString("login"));
				dto.setEmail(rs.getString("email"));
				dto.setPoints(rs.getInt("points"));
				dto.setPrivacy(rs.getInt("privacy"));
				dto.setLastDate(rs.getString("lastDate"));

				return dto;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	/* 최진영 - Loginok.java(로그인2) 종료 */
}
