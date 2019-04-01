package com.josh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.josh.dao.GuestBookDao;
import com.josh.dto.GuestBookDto;
import com.josh.util.GuestBookUtil;

@WebServlet("/GBC")
public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// handling GET method Request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Execute GuestBookController...");

		String action = request.getParameter("action");
		if("insert".equals(action)){
			System.out.println("Register list...");

			String name = request.getParameter("name");
			String password = request.getParameter("pwd");
			String content = request.getParameter("content");
			GuestBookDto dto = new GuestBookDto();
			dto.setName(name);
			dto.setPassword(password);
			dto.setContent(content);

			GuestBookDao dao = new GuestBookDao();
			dao.insert(dto);

			GuestBookUtil.redirect(request, response, "/guestbook2/GBC?action=showList");
		}else if("delete".equals(action)){
			System.out.println("Delete list...");

			String no = request.getParameter("no");
			String pwd = request.getParameter("pwd");

			GuestBookDao dao = new GuestBookDao();
			GuestBookDto dto = new GuestBookDto();
			dto.setNo(Integer.parseInt(no));
			dto.setPassword(pwd);
			dao.delete(dto);

			GuestBookUtil.redirect(request, response, "/guestbook2/GBC?action=showList");
		}else if("changePassword".equals(action)) {
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			String nPwd = request.getParameter("nPwd");

			GuestBookDao dao = new GuestBookDao();
			GuestBookDto dto = new GuestBookDto();
			String temp = dao.getPwd(name);
			System.out.println(temp);
			if(pwd.equals(dao.getPwd(name))) {
				dto.setName(name);
				dto.setPassword(nPwd);
				dao.changePwd(dto);
			}
			System.out.println("test");
			GuestBookUtil.redirect(request, response, "/guestbook2/GBC?action=showList");
		}else if("changePwd".equals(action)){
			System.out.println("find password...");

			GuestBookUtil.forward(request, response, "/WEB-INF/changePwd.jsp");
		}else if("deleteList".equals(action)){
			System.out.println("Confirm password...");

			GuestBookUtil.forward(request, response, "/WEB-INF/deleteList.jsp");
		}else{
			System.out.println("Show list...");

			GuestBookDao dao = new GuestBookDao();
			List<GuestBookDto> list = dao.getList();
			request.setAttribute("GuestBookList", list);
			GuestBookUtil.forward(request, response, "/WEB-INF/showList.jsp");
		}

	}

	// handling POST method Request
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	}

}
