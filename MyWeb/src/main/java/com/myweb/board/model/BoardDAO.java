package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.myweb.user.model.UserVO;

public class BoardDAO implements IBoardDAO {

	//싱글톤 패턴
	private DataSource ds; 

	private BoardDAO() { //생성자의 접근을 private으로 막았다.
		try { //커넥션 풀 정보를 땡겨와서 ds에 넣어주자.
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle"); 
																		
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO(); //객체 생성

	public static BoardDAO getInstance() {  //외부에서 요구할 떄, 객체 생성 없이 사용할 수 있게 주는 방법 
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////싱글턴 완성 끝
	
	
	
	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO my_board (board_id, writer, title, content) VALUES(board_seq.NEXTVAL, ?, ?, ?)";
		try (Connection conn = ds.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<BoardVO> listBoard() {
		List<BoardVO> articles = new ArrayList<>(); //포장해서 List에 차곡차곡포장~
		String sql = "SELECT * FROM my_board ORDER BY board_id DESC"; //물음표채울거없고 List로 리턴하는 거니까 List를 하나 선언하자(한줄위에서)
		try(Connection conn = ds.getConnection();  //물음표 채울꺼없으니 ResultSet까지 한번에 뽑자
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){ //sql 결과를 rs가 갖고있겠지. 조회 결과는 전체글목록(여러개니까) 한행씩 가져오는 것을 해야하니 반복문열자
			while(rs.next()) { //rs.next를 부르면 조회할 데이터가있으면 트루, 없으면 폴스를 주지?
				//트루를 주면 한행을 지목한다. 그때마다 데이터 한행씩 꺼내면 된다.
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(), //타임스탬프를 로컬데이트로 바꾸자. .toLocalDateTime()추가
						rs.getInt("hit")
						);
				//articles라는 리스트에다가 지금만든 vo를 추가하자. 계속 조회가 되지 않을때까지 반복한다는 의미이다.
				articles.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articles; //마지막에 articles를 리턴해주겠다~
	}

	
	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null;
		String sql = "SELECT * FROM my_board WHERE board_id=" + bId; //이러면 물음표 안채워도가능하겠지. + bId까지붙여주면.
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) { 
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date").toLocalDateTime(),
						rs.getInt("hit")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	
	
	

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE my_board SET title=?, content=? WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate(); 
	} catch (SQLException e) {
	 	e.printStackTrace();
	}
}
				
				
				
				
				

	
	@Override
	public void deleteBoard(int bId) {

	}
}
