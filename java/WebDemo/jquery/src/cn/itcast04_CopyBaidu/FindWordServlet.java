package cn.itcast04_CopyBaidu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FindWordServlet
 */
public class FindWordServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1先获取参数
			String word = request.getParameter("word");
			System.out.println("word:"+word);
			//2 让dao执行查询
			WordDao dao  = new WordDaoImpl();
			List<Word> list = new ArrayList<Word>();
			list = dao.findWords(word);
			for (Word word1: list){
				System.out.println(word1.getWord());
			}
			//3返回相应的数据
			response.setContentType("text/html;charset=UTF-8");
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
