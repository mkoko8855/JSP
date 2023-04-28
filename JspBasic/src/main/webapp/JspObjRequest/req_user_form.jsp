<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%--
	
		# 폼을 이용한 사용자의 입력값 서버로 전달하기
		
		사용자의 입력 데이터를 서버로 전송하려면 HTML의 form태그를 사용한다.
		
		form말고 a로도 전달할 수 있는 것을 경험했지?
		
		form태그의 action 속성에 데이터를 전달받을 페이지의 url 주소를 작성한다.
	
		input 태그의 name 속성으로 요청 파라미터의 이름을 지정할 수 있다.
		
		이름을 지정하실 때는 입력값과 관련있는 이름으로 지정해 주는 것이 좋다.
		
	 --%>



	<form action="req_user_info.jsp">
        <!-- name을 통해 추후에 서버 내부에서 해당 입력값을 지목할 수 있다. -->
        아이디: <input type="text" name="id" value="메롱메롱"> <br> 
        비밀번호: <input type="password" name="pw" required> <br>

        # 성별 <br>
        <input type="radio" name="gender" value="male"> 남
        <input type="radio" name="gender" value="female"> 여 <br>

        # 취미 <br>
        <input type="checkbox" name="hobby" value="read"> 독서
        <input type="checkbox" name="hobby" value="sleep"> 수면
        <input type="checkbox" name="hobby" value="soccer"> 축구
        <input type="checkbox" name="hobby" value="game"> 게임 <br>

        # 지역 <br>
        <select name="region">   <!-- 셀렉트 같은 경우는, 옵션에서 밸류를 붙인 것도있고 붙이지 않는 것도 있다. 사용자가 선택을 하나 하면, 우리가 requestgetParameter=region이라고 하면, 그때 value가 붙어있다면 이 value가 겟파라미터로 온다. 밸류가 없으면 대전이나 대구 부산이 온다는 것이다. 내가 겟파라미터로 받을 때는 영어로 받고 싶으면 value를 달아주고, 나는 보여주는 것을 한글로 표시하고 싶으면 밸류를 달지 않아도 된다. 대부분은 밸류를 단다. 왜? 사용자는 한글로, 난 영어로 얻길 원하거든. sql에 바로 영어로 때려버리면 되니까, 그리고 프로그래밍에서 한글은 잘 안쓰니까. -->
            <option value="seoul">서울</option>
            <option>대전</option>
            <option>대구</option>
            <option>부산</option>
        </select>


        # 자기소개 <br>  <!-- textarea도 name이 있어야한다. 셀렉트 인풋 모두 name이 있어야 겟파라미터 할 수 있다. -->
        <textarea name="introduce" cols="30" rows="10"></textarea> <br>

        <input type="submit" value="회원가입"> <!-- 서브밋이라는 회원가입을 누르는 순간 form태그의 action주소로 간다! -->

    </form>









</body>
</html>