package com.myweb.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myweb.board.model.BoardDAO;
import com.myweb.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String category = request.getParameter("category");
		String keyword = request.getParameter("search");
		
		//이 2가지를 DAO의 메서드인 searchboard에게 넘기자
		List<BoardVO> list = BoardDAO.getInstance().searchBoard(keyword, category); //주소값받고 그래야 메서드 부를 수 있으니까
		
		if(list.size() == 0) {
			response.setContentType("text/html; charset=UTF-8"); //자바스크립트 코드를 사용 할꺼니까 이거쳐줘야지
			
			try {
				PrintWriter out = response.getWriter();
				String htmlCode =  "<script>\r\n"
	                    + "alert('검색 결과에 따른 게시물이 없습니다.');\r\n"
						+ "location.href='/MyWeb/list.board';\r\n"
	                    + "</script>";
				out.print(htmlCode);
				out.flush();
				return;
				//out.flush했다는건 응답이 브라우저로 나갔으니 응답을 더 해줄 필요가 없지.
				//근데 우린 리스트의 사이트가 0이라면 응답을 저렇게 내보내는 if문을 썻다.
				//조회결과가 없었다면 request에 데이터를 담을 필요가 없으니 메서드를 강제로 종료시키는 의미에서 return을 쓰자
				//그리고 if문 바깥으로 나가서 만약에 리스트 사이즈가 0이 아니라면 if문을 건너뛰는거니까 request.setAttribute(""
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("boardList", list);
	}
}
