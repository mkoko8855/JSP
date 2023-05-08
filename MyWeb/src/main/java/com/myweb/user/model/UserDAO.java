package com.myweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle"); // 커넥션풀에서 찾아봐~, 그리고 myOracle은 커넥션 풀을 적었던 name
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
	public boolean confirmId(String id) { // 매개값으로 id주세요~, 타입을 boolean으로 잡았다. 왜냐하면 중복 여부만 확인하면 되니까

		String sql = "SELECT * FROM my_user WHERE user_id = ?";
		boolean flag = false;
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 그리고 나서 리턴할꺼다
			if (rs.next())
				flag = true; // 존재하면 true

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// dao야 인서트해줘 내가너한테 포장한 vo줄게^^ <ㅡ 이거 이어받아서 여기서 써주자~
	public void insertUser(UserVO vo) {
		String sql = "INSERT INTO my_user VALUES(?, ?, ?, ?, ?)";
		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getUserPw());
			pstmt.setString(3, vo.getUserName());
			pstmt.setString(4, vo.getUserEmail());
			pstmt.setString(5, vo.getUserAddress());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int userCheck(String id, String pw) {
		int check = 0; // 트라이캐치 안에서 리턴하면 메서드 안에서 빨간줄이 생기기 떄문이다.
		String sql = "Select user_pw From my_user where user_id = ?"; // 매개변수로 가져온 pw랑 여기적은 user_pw만 비교하면 되니까. 이 조회 결과가
																		// 없다면? 그 사람은 회원이 아닌거잖아. 그럼 -1리턴, 비번틀리면 0, 둘다
																		// 아니면 1 리턴.

		try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery(); // 리턴값으로 result값을 받아야지~
			// sql의 실행 결과를 resultset이 가지고 있는데, 만약 사용자가 존재하지 않은 아이디를 적는다면 조회결과가없지? while문을 써도
			// 되는데 if문으로 쓰자.
			if (rs.next()) { // rs.next가 트루를 줌. 즉, 조회결과가 있다. 즉, 사용자가 id는 제대로 썼으니 비밀번호를 비교해야된다. 매개값인 pw랑 디비에서
								// 가져온 pw가 같은지?
				String dbPw = rs.getString("user_pw"); // 야 디비에서 user_pw라는 컬럼값을 줘봐
				if (dbPw.equals(pw)) { // 이게 트루면 아이디와 비밀번호 조회가 일치하니 로그인이 성공하는 것이다.
					check = 1;
				} else { // 비밀번호가 틀린것이니
					check = 0;
				}
			} else { // 니가 준 sql id를 조회결과가 없다는 것이다. 즉, 저 사람은 회원이 아니다. 즉, 존재하지 않는 아이디이다.
				check = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check; // 트라이캐치 안에서 리턴하면 메서드 안에서 빨간줄이 생기기 떄문이다.
	}// 로그인 서비스로 가자

	
	
	public UserVO getUserInfo(String id) {   //getUserInfo는 로그인이 성공하는 사람들만 사용하는 메서드이다. 
		UserVO user = null; //트라이 문 안에 리턴을 작성하면 에러발생하니까 항상 리턴문은 마지막에 배치해주자~ 그래서 변수로 리턴하는것이다.
		String sql = "SELECT * FROM my_user " + "WHERE user_id='" + id + "'"; //물음표가 하나면 이렇게 써도되는데 2개이상일때는 그냥 ? ? 로쓰자
		
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){  //물음표를 채울 필요가 없었기 때문에 괄호안에다가 한번에 세팅했다.
			    //getUserInfo는 로그인이 성공하는 사람들만 사용하는 메서드이다. 
			    //next를 무조건 불러야 한다. 아니면 타게팅이 안되기 때문이다.
				//조회가 됐니? 라고 물어보는 것은 타게팅을 동시에 해주기 떄문이다.
			if(rs.next()) { //행은 하나만 조회되니까 와일문안써도됨
				//받아오자마자 바로 포장을 해주기 위해 null준 유저 변수에 객체를 생성해주자
				user = new UserVO(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_address")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	public void changePassword(String id, String newPw) { //셀렉만은 리턴이 있다. 나머진 없다.
		String sql = "UPDATE my_user SET user_pw = ? WEHRE user_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.executeUpdate(); 
	} catch (SQLException e) {
	 	e.printStackTrace();
	}
}
	
	public void updateuser(UserVO vo) {
		String sql = "UPDATE my_user SET user_name=?, user_email=?, user_address=? where user_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, vo.getUserName());
			pstmt.setString(2, vo.getUserEmail());
			pstmt.setString(3, vo.getUserAddress());
			pstmt.setString(4, vo.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String id) {
		String sql = "DELETE FROM my_user WHERE user_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, id);
				pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
