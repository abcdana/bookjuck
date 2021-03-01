package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.BookDTO;
import com.test.bookjuck.dto.EBookDTO;

public class EBookDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookDAO() {
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

	//############# 주혁 시작
	
	//EBookList 서블릿 -> ebooklist 반환
	public ArrayList<EBookDTO> getEBookList(HashMap<String, String> map) {
		
		try {
			
			String sql = "";
			String innerSql = "";
			
			if (map.get("seqSCategory") == null) {
				//E-Book 리스트 첫 화면
				//innerSql = "select eb.*, lc.seq as seqLCategory, mc.seq as seqMCategory, lc.lCategory as lCategory, mc.mCategory as mCategory, sc.sCategory as sCategory, (select name from tblAuthor where seq = eb.seqAuthor) as author from tblEbook eb inner join tblSCategory sc on eb.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq inner join tblLCategory lc on mc.seqLCategory = lc.seq order by eb.pubDate desc, eb.title asc";
				innerSql = "select * from viewEBook order by pubDate desc, title asc";

			} else {
				//도서 리스트 좌측 소분류 선택
				//innerSql = String.format("select eb.*, lc.seq as seqLCategory, mc.seq as seqMCategory, lc.lCategory as lCategory, mc.mCategory as mCategory, sc.sCategory as sCategory, (select name from tblAuthor where seq = eb.seqAuthor) as author from tblEbook eb inner join tblSCategory sc on eb.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq inner join tblLCategory lc on mc.seqLCategory = lc.seq where eb.seqSCategory = %s order by eb.pubDate desc, eb.title asc", map.get("seqSCategory"));
				innerSql = String.format("select * from viewEBook where seqSCategory = %s order by pubDate desc, title asc", map.get("seqSCategory"));

			}
			
			sql = String.format("select * from (select a.*, rownum as rnum from (%s) a) where rnum between %s and %s", innerSql, map.get("begin"), map.get("end"));
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<EBookDTO> eblist = new ArrayList<EBookDTO>();
			
			while (rs.next()) {
				EBookDTO dto = new EBookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setImage(rs.getString("image"));
				dto.setTitle(rs.getString("title"));
				dto.setAuthor(rs.getString("author"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setIntro(rs.getString("intro"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				eblist.add(dto);
			}
			
			return eblist;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	//EBookDetail 서블릿 -> E-Book 상세정보 호출
	public EBookDTO getEBookDetail(String seq) {
		
		try {
			
			String sql = "select eb.*, lc.seq as seqLCategory, mc.seq as seqMCategory, lc.lCategory as lCategory, mc.mCategory as mCategory, sc.sCategory as sCategory, (select name from tblAuthor where seq = eb.seqAuthor) as author, (select intro from tblAuthor where seq = eb.seqAuthor) as authorIntro from tblEBook eb inner join tblSCategory sc on eb.seqSCategory = sc.seq inner join tblMCategory mc on sc.seqMCategory = mc.seq inner join tblLCategory lc on mc.seqLCategory = lc.seq where eb.seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			EBookDTO dto = new EBookDTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setTitle(rs.getString("title"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setIntro(rs.getString("intro"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setCopy(rs.getString("copy"));
				dto.setImage(rs.getString("image"));
				dto.setContents(rs.getString("contents"));
				dto.seteFile(rs.getString("eFile"));
				
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				
				dto.setsCategory(rs.getString("sCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				
				return dto;
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	//EBookList 서블릿 -> E-Book 수 반환
	public int getEBookCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqSCategory") != null) {
				//소분류 선택
				where = String.format("where seqSCategory = %s", map.get("seqSCategory"));
			}
			
			String sql = String.format("select count(*) as cnt from tblEBook %s", where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}

	//EBookList 서블릿 -> EBook 리스트 반환
	public ArrayList<EBookDTO> getAdminEBookList(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqLCategory") != null) {
				where = "where veb.seqLCategory = " + map.get("seqLCategory");
			}
			
			String sql = String.format("select * from (select a.*, rownum as rnum from (select veb.* from viewEBook veb %s) a) where rnum between %s and %s"
					, where
					, map.get("begin")
					, map.get("end"));
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			ArrayList<EBookDTO> list = new ArrayList<EBookDTO>();
			
			while (rs.next()) {
				EBookDTO dto = new EBookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setCopy(rs.getString("copy"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setIntro(rs.getString("intro"));
				dto.setImage(rs.getString("image"));
				dto.seteFile(rs.getString("eFile"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				list.add(dto);
				
			}
			
			return list;
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return null;
	}

	//EBookList 서블릿 -> (페이징) E-Book 수 반환
	public int getAdminEBookCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("seqLCategory") != null) {
				//대분류 선택
				where = String.format("where seqLCategory = %s", map.get("seqLCategory"));
			}
			
			String sql = String.format("select count(*) as cnt from viewEBook %s", where);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return 0;
	}

	//EBookList 서블릿 -> 총 E-Book 수
	public int getWholeEBookCount() {
		
		try {
			
			String sql = "select count(*) as cnt from viewEBook";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return 0;
	}

	//EBookList 서블릿 -> 국내E-Book 수
	public int getInternalEBookCount() {
		
		try {
			
			String sql = "select count(*) as cnt from viewEBook where seqLCategory = 1";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}			
		
		return 0;
	}

	//EBookList 서블릿 -> 해외E-Book 수
	public int getExternalEBookCount() {
		
		try {
			
			String sql = "select count(*) as cnt from viewEBook where seqLCategory = 2";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}				
		
		return 0;
	}

	//EBookAddOk 서블릿 -> EBook 추가
	public int add(EBookDTO ebdto) {
		
		try {
			
			String sql = "insert into tblEBook (seq, seqAuthor, seqSCategory, title, publisher, price, salePrice, pubDate, intro, isbn, copy, image, eFile, contents) values (seqBook.nextVal, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, ebdto.getSeqAuthor());
			pstat.setString(2, ebdto.getSeqSCategory());
			pstat.setString(3, ebdto.getTitle());
			pstat.setString(4, ebdto.getPublisher());
			pstat.setInt(5, ebdto.getPrice());
			pstat.setInt(6, (ebdto.getPrice() / 10) * 9);
			pstat.setString(7, ebdto.getPubDate());
			pstat.setString(8, ebdto.getIntro());
			pstat.setString(9, ebdto.getIsbn());
			pstat.setString(10, ebdto.getCopy());
			pstat.setString(11, ebdto.getImage());
			pstat.setString(12, ebdto.geteFile());
			pstat.setString(13, ebdto.getContents());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return 0;
	}

	//EBookEdit 서블릿 -> EBook 상세
	public EBookDTO getAdminEBookDetail(String seq) {
		
		try {
			
			String sql = "select * from viewEBook where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				EBookDTO dto = new EBookDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setTitle(rs.getString("title"));
				dto.setSeqAuthor(rs.getString("seqAuthor"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPubDate(rs.getString("pubDate"));
				dto.setPrice(rs.getInt("price"));
				dto.setSalePrice(rs.getInt("salePrice"));
				dto.setCopy(rs.getString("copy"));
				dto.setIsbn(rs.getString("isbn"));
				dto.setIntro(rs.getString("intro"));
				dto.setImage(rs.getString("image"));
				dto.seteFile(rs.getString("eFile"));
				dto.setContents(rs.getString("contents"));
				dto.setAuthor(rs.getString("author"));
				dto.setAuthorIntro(rs.getString("authorIntro"));
				dto.setSeqLCategory(rs.getString("seqLCategory"));
				dto.setSeqMCategory(rs.getString("seqMCategory"));
				dto.setSeqSCategory(rs.getString("seqSCategory"));
				dto.setlCategory(rs.getString("lCategory"));
				dto.setmCategory(rs.getString("mCategory"));
				dto.setsCategory(rs.getString("sCategory"));
				
				return dto;
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return null;
	}

	//EBookEditOk 서블릿 -> 이미지 수정 안한 경우 이미지 파일명 가져오기
	public String getImageFileName(String seq) {

		try {
			
			String sql = "select image from tblEBook where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("image");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return null;
	}

	//EBookEditOk 서블릿 -> eFile 수정 안한 경우 EBook 파일명 가져오기
	public String getEBookFileName(String seq) {

		try {
			
			String sql = "select eFile from tblEBook where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				return rs.getString("eFile");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return null;
	}

	//EBookEditOk 서블릿 -> 도서 수정
	public int edit(EBookDTO ebdto) {

		try {
			
			String sql = "update tblEBook set seqAuthor = ?, seqSCategory = ?, title = ?, publisher = ?, price = ?, salePrice = ?, pubDate = ?, intro = ?, isbn = ?, copy = ?, image = ?, eFile = ?, contents = ? where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, ebdto.getSeqAuthor());
			pstat.setString(2, ebdto.getSeqSCategory());
			pstat.setString(3, ebdto.getTitle());
			pstat.setString(4, ebdto.getPublisher());
			pstat.setInt(5, ebdto.getPrice());
			pstat.setInt(6, (ebdto.getPrice() / 10) * 9);
			pstat.setString(7, ebdto.getPubDate());
			pstat.setString(8, ebdto.getIntro());
			pstat.setString(9, ebdto.getIsbn());
			pstat.setString(10, ebdto.getCopy());
			pstat.setString(11, ebdto.getImage());
			pstat.setString(12, ebdto.geteFile());
			pstat.setString(13, ebdto.getContents());
			
			pstat.setString(14, ebdto.getSeq());
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}		
		
		return 0;
	}

	//EBookDelOk 서블릿 -> 주문 있는지 확인
	public boolean isOrder(String seq) {
		
		try {
			
			String sql = "select distinct seqEBook from tblEOrderDetail where seqEBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				//주문내역 있으면
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("EBookDAO.isOrder()");
			e.printStackTrace();
		}
		
		return false;
	}

	//EBookDelOk 서블릿 -> EBook 삭제
	public int del(String seq) {

		try {
			
			//EBook 장바구니에서 삭제 (장바구니에 없을 수도 있음)
			String sql = "delete from tblECart where seqEBook = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			pstat.executeUpdate();
					
			//E-Book테이블에서 삭제
			sql = "delete from tblEBook where seq = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("EBookDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	//############# 주혁 끝
	
} //EBookDAO
