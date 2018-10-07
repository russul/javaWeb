package cn.scut.jsp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.scut.vertifycode.VertifyCode;

public class LoginServlet extends HttpServlet {

//处理验证码检验的请求
//1.得到客户端验证码数据
//2.和session中的进行比较
//3.成功就保存用户信息，并重定向到登录成功界面
//4.失败，就保存错误信息，并转发到登录页面
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String vcode=request.getParameter("vertify");
		String nameString = request.getParameter("username");
		String pString= request.getParameter("password");
		if(vcode.equalsIgnoreCase((String)request.getSession().getAttribute("session_vcode"))){
			HttpSession session = request.getSession();
			session.setAttribute("username", nameString);
			session.setAttribute("password", pString);
			response.sendRedirect("/JavaWeb/session2/succ1.jsp");
			
		}else{
			request.setAttribute("msg", "验证码错误！");
			
			RequestDispatcher rq=request.getRequestDispatcher("/session2/login.jsp");
			rq.forward(request, response);
			
		}
		
		
//		String nameString = request.getParameter("username");
//		String pString= request.getParameter("password");
		
		//校验用户名（如果不是scut就成功，规则随便定）
//		if(!nameString.equalsIgnoreCase("scut")){
//			Cookie cookie=new Cookie("username", nameString);
//			cookie.setMaxAge(60*60);
//			response.addCookie(cookie);
//			HttpSession session = request.getSession();
//			session.setAttribute("username", nameString);
//			session.setAttribute("password", pString);
//			
//			response.sendRedirect("/JavaWeb/sessionlogin/succ1.jsp");
//			
//		}else{
//			request.setAttribute("msg", "登录失败，请重新登录！");
//			
//			RequestDispatcher rq=request.getRequestDispatcher("/sessionlogin/login.jsp");
//			rq.forward(request, response);
//		}
//		
	
		
	}

}
