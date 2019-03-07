package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.PostMutterLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Get borad list 스코프에서 배열 인스턴스 획득.
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		//取得出来なかった場合はリストを新規作成して　アプリケーションに保存
		if (mutterList == null) {
			mutterList = new ArrayList<Mutter>(); //배열선언
			application.setAttribute("mutterList", mutterList);

		}
		//ログインしているか確認するため
		//sessionからget user imformation
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) {
			//redirect
			response.sendRedirect("/board");
		} else {
			//ログイン済みのない
			//forward

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request parameter
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		//入力値check
		if (text != null && text.length() != 0) {
			//application保存されたboardlistを取得
			ServletContext application = this.getServletContext();
			List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
			//sessionに保存された情報取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");

			Mutter mutter = new Mutter(loginUser.getName(), text);
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			PostMutterLogic.execute(mutter, mutterList);

			application.setAttribute("mutterList", mutterList);

		} else {
			//error
			request.setAttribute("errorMsg", "fail");
		}

		//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		//	dispatcher.forward(request, response);

		response.sendRedirect("Redirect");
	}
}
