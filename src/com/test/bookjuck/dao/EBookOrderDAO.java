package com.test.bookjuck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.bookjuck.DBUtil;
import com.test.bookjuck.dto.EBookOrderDTO;

public class EBookOrderDAO {
	

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public EBookOrderDAO() {
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
	
	
	// (다은) 시작 ---------------------
	
	//교환/취소/환불 리스트 뽑아오기
	public ArrayList<EBookOrderDTO> list(HashMap<String, String> map) {

		
		try {
			
			String where = "";
			
			if (map.get("refundsearch")!= null) {
				
				where = String.format(""
						, map.get("refundsearch"));
				
			}
			

			
			
			String sql = String.format("select * from vwERefundList %s order by applydate desc", where);
			
			pstat = conn.prepareStatement(sql);
			rs = pstat.executeQuery();
			
			ArrayList<EBookOrderDTO> list = new ArrayList<EBookOrderDTO>();
			
			
			while (rs.next()) {
				
				EBookOrderDTO dto = new EBookOrderDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setApplyDate(rs.getString("applyDate"));
				dto.setTitle(rs.getString("title"));
				dto.setTotalAmount(rs.getString("totalAmount"));
				dto.setOrderState(rs.getString("orderState"));
				dto.setSeqMember(rs.getString("seqMember"));
				
				list.add(dto);
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
	
	// (다은) 끝 ---------------------
	

}
