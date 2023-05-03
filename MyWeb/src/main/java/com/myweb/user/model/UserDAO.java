package com.myweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DAO(Data Access Object)

//웹 프로그램에서 데이터베이스 CRUD작업이 요구될 때마다 데이터베이스 접속 및 SQL문 실행을 전담하는 비즈니스 로직이다.

//그리고! 무분별한 객체 생성을 막기 위해 싱글톤 디자인 패턴으로 구축한다.
//순서 1. 생성자를 단 하나만 뽑고 private으로 막음 
//순서 2. 생성자 막았으니까 스스로의 객체를 단 하나만 생성
//순서 3. 외부에서 객체를 요구 할 때마다 스스로 만든 객체를 리턴해주는 static메서드(객체생성없어도 불러줄수있어야하니까 static)생성

public class UserDAO {
	private DataSource ds; // ds는 커넥션 풀의 정보를 담을 변수를 선언했다.

	private UserDAO() {
		// 객체가 생성되자마자 커넥터드라이버가 생성되게하자

		/*
		 * 그러나 try { Class.forName("oracle.jdbc.driver.OracleDriver"); } catch
		 * (ClassNotFoundException e) { e.printStackTrace(); }
		 * 
		 * 이렇게 안쓸거다 탐캣에서 제공하는 기본 커넥션풀을 Servers파일에 context.xml에 적어주자. 적고 왔으니 이제 불러주자
		 */

		// 이제 커넥션 풀 정보를 context.xml에 적었으니 위에서 private DataSource ds;를 불러오자
		// InitialContext ct = new InitialContext(); 생성자에 빨간줄 긁히는 이유는 예외처리강요하고있다~
		// 트라이 캐치 해주면 이렇게 변함
		
		
		
		
		
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/myOracle"); // 커넥션풀에서 찾아봐~, 그리고 myOracle은 커넥션 풀을 적었던 name
																		// 부분이다. 이게 이제 커넥션풀의 정보를 객체로 리턴하는데, 이 객체 형태가
																		// 오브젝트이다. 그걸 우리는 준비한 ds에 넣으면 된다.
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 이제 스스로 객체를 단 하나만 선언해주자
	private static UserDAO dao = new UserDAO();

	// 이제 외부에서 요구하면 얘를 불러~
	public static UserDAO getInstance() { // getInstance는 관례이다.
		// 혹시 가비지컬렉터가 가져가든가 한다는 등의 객체가 소멸되어버리는 것을 방지하기 위해 자체적으로 하나 만들어주자
		if (dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}

	/////////////////////////////////////////////////////////////// 이제 싱글톤과 커넥션 풀에
	/////////////////////////////////////////////////////////////// 대한 얘기가 끝났다.

	// 그럼이제뭐해? 회원 중복 여부 확인해야지
	public boolean confirmId(String id){ //매개값으로 id주세요~, 타입을 boolean으로 잡았다. 왜냐하면 중복 여부만 확인하면 되니까
		
		String sql = "SELECT * FROM my_user WHERE user_id = ?";
		boolean flag = false;
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				//그리고 나서 리턴할꺼다
				if(rs.next()) flag = true; //존재하면 true    
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//dao야 인서트해줘 내가너한테 포장한 vo줄게^^ <ㅡ 이거 이어받아서 여기서 써주자~
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?, ?, ?, ?, ?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1,  vo.getUserId());
			pstmt.setString(2,  vo.getUserPw());
			pstmt.setString(3,  vo.getUserName());
			pstmt.setString(4,  vo.getUserEmail());
			pstmt.setString(5,  vo.getUserAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
