package com.myweb.user.model;


/*
		모델(model)계층은 비즈니스 로직을 처리하는 역할을 담당한다.
		비즈니스 로직이란, 외부 프로그램과 연계 작업 등을 수행하는 로직이다.
		
		
		즉, VO(value object)는
		데이터베이스(DB)에서 조회된 값이나 서버 프로그램에서 요쳥과 함께 얻은 값 등을
		포장해서 운반하는 값에 관련된 객체 이다. 
 		
 		
 		VO클래스는 자바빈 클래스로 생성한다.
 		
 		
 		
 		자바빈(java bean) 이란?
 		웹 프로그래밍에서 어떠한 객체를 가지고 오기 위한 기법이며, 자바로 작성된 클래스를 일반적으로 부르는 호칭이다.
 		
 		
 		자바빈을 설계하기 위한 규약이 존재한다.
 		우린 이미 자바빈을 경험했다.
 	    규약 1. 은닉(캡슐화)을 구현해서 클래스를 제작한다. (변수 private과 getter와 setter를 구현 해야 한다)
 	    규약 2. getter 메서드는 매개변수가 존재하지 않아야 한다.
 	    규약 3. 생성자는, 매개값을 받지 않는 생성자(필수).   매개값을 받는 생성자(선택)가 존재한다. (기본생성자하나 뽑고 모든 필드값을 매개로받는 것을 뽑았었다. 필요하면 뽑고..안뽑고......
 		규약 4. 모든 getter와 setter 메서드는 접근 제한이 public 이어야 한다.
 		
*/


public class UserVO { 

	//비즈니스로직을 처리하는 모델이라는 계층을 처리하자
	//데이터베이스 테이블과 유사하게 생겨서 값을 쉽게 운반할 수 있으니 DB의 테이블이 먼저 필요하다.
	
	//그냥 system계정으로 접속해서
	
	/*
	  	CREATE USER jsp IDENTIFIEd BY jsp;

		GRANT CREATE SESSION TO jsp;

		GRANT CONNECt, RESOURCE TO jsp;
	  	해주고
	  	
	  	jsp_practice라는 계정 명과 사용자이름과 비밀번호는 jsp로 해주고 계정 하나 더 만들어주고 접속해준다.
	  	
	  	CREATE TABLE my_user (
    	user_id VARCHAR2(30) PRIMARY KEY,
    	user_pw VARCHAR2(30) NOT NULL,
    	user_name VARCHAR2(20) NOT NULL,
    	user_email VARCHAR2(100),
    	user_address VARCHAR2(100)
		); 를 만들어 줬다.
	 */
	
	
		private String userId;
		private String userPw;
		private String userName;
		private String userEmail;
		private String userAddress;
	
		public UserVO() {
		}

		public UserVO(String userId, String userPw, String userName, String userEmail, String userAddress) {
			super();
			this.userId = userId;
			this.userPw = userPw;
			this.userName = userName;
			this.userEmail = userEmail;
			this.userAddress = userAddress;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserPw() {
			return userPw;
		}

		public void setUserPw(String userPw) {
			this.userPw = userPw;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getUserEmail() {
			return userEmail;
		}

		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}

		public String getUserAddress() {
			return userAddress;
		}

		public void setUserAddress(String userAddress) {
			this.userAddress = userAddress;
		}

		
		
		//DB에서 값이 제대로 넘어왔는지 혹은 화면에서 파라미터 값이 잘 왔는지 투스트링도 해주면 좋다!
		@Override 
		public String toString() {
			return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail="
					+ userEmail + ", userAddress=" + userAddress + "]";
		}
		
		
		
}
