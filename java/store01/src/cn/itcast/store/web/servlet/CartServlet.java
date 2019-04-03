package cn.itcast.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.store.domain.Cart;
import cn.itcast.store.domain.CartItem;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImpl.ProductServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	//添加购物项到购物车
	public String addCartItemToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从session获得购物车
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		if(null == cart) {
			//如果获取不到重新创建
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
			//能获取到 使用
			String pid = request.getParameter("pid");
			int num = Integer.parseInt(request.getParameter("quantity"));
			//通过商品id查询商品对象
			ProductService productService = new ProductServiceImpl();
			try {
				Product product = productService.findProductByPid(pid);
				CartItem cartItem = new CartItem();
				cartItem.setNum(num);
				cartItem.setProduct(product);
				cart.addCartItem(cartItem);
				response.sendRedirect("/store01/jsp/cart.jsp");
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return null;
		
	}
	public String removeCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		cart.removeCartItem(pid);
		response.sendRedirect("/store01/jsp/cart.jsp");
		return null;
	}
	public String clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		cart.clearCart();
		response.sendRedirect("/store01/jsp/cart.jsp");
		return null;
	}

}
