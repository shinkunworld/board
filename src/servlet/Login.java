package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
//로그인에 관한 request를 처리하는 컨트롤러
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Get request parameter
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//USERインスタンス（USER情報）の生成
		User user = new User(name, pass);

		//login processing
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		//success login processing
		if (isLogin) {
			//user impormation save to session
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

		}
		//login result view to forward
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/loginResult.jsp");
		dispatcher.forward(request, response);
	}
}