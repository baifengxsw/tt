package cn.itcast.store.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.mchange.v2.codegen.bean.BeangenUtils;

import cn.itcast.store.domain.Category;
import cn.itcast.store.domain.PageBean;
import cn.itcast.store.domain.Product;
import cn.itcast.store.service.CategoryService;
import cn.itcast.store.service.ProductService;
import cn.itcast.store.service.serviceImpl.CategoryServiceImpl;
import cn.itcast.store.service.serviceImpl.ProductServiceImpl;
import cn.itcast.store.utils.UUIDUtils;
import cn.itcast.store.utils.UploadUtils;

/**
 * Servlet implementation class AdminProductServlet
 */
public class AdminProductServlet extends BaseServlet {
	//findAllProductsWithPage
	public String findAllProductsWithPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页
		//调用业务层查看全部商品信息返回PageModel
		//将PageModel放入request
		//转发到/admin/product/list.jsp;
		
		int curNum = Integer.parseInt(request.getParameter("num"));
		ProductService productService = new ProductServiceImpl();
		PageBean pb =null;
		try {
			pb = productService.findAllProduct(curNum);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("page", pb);
		return "/admin/product/list.jsp";
	}
	public String addProductUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService categoryService  =new CategoryServiceImpl();
		
		try {
			System.out.println("sdf");
			List<Category> list = categoryService.getAllCats();
			request.setAttribute("allCats", list);
			request.getRequestDispatcher("/admin/product/add.jsp");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "/admin/product/add.jsp";
		
	}
	public String addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String> map = new HashMap<String,String>();
		Product product = new Product();
		try {
			//利用request.getInputStream(); 获取请求体全部数据 进行拆分和分装
			DiskFileItemFactory fac = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fac);
			List<FileItem> list = upload.parseRequest(request);
			//遍历集合
			//如果当前的fileItem 对象是普通项 ，放入map中  如果是上传项，通过获取输入流 ，创建一个空文件
			for(FileItem item :list) {
				if(item.isFormField()) {
					//是普通项
					map.put(item.getFieldName(), item.getString("utf-8"));
				}else {
					//上传项
					String oldFileName = item.getName();
					String newFileName = UploadUtils.getUUIDName(oldFileName);
					InputStream is = item.getInputStream();
					String realPath = getServletContext().getRealPath("/products/3/");
					System.out.println("realPath:"+realPath);
					String dir = UploadUtils.getDir(newFileName);
					String path = realPath+dir;
					System.out.println("path:"+path);
					File newDir = new File(path);
					if(!newDir.exists()) {
						newDir.mkdirs();
					}
					//在服务端创建一个空文件
					File finalFile = new File(newDir,newFileName);
					if(!finalFile.exists())
						finalFile.createNewFile();
					//建立相对应的输出l流
					OutputStream os = new FileOutputStream(finalFile);
					IOUtils.copy(is, os);
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(os);
					map.put("pimage","/products/3"+dir+"/"+newFileName);
					System.out.println(map.get("pimage"));
				}
			}
			
			//填充数据
			BeanUtils.populate(product, map);
			product.setPid(UUIDUtils.getId());
			product.setPdate(new Date());
			product.setPflag(0);
			ProductService ps = new ProductServiceImpl();
			System.out.println(product);
			ps.addProduct(product);
			response.sendRedirect("/store01/AdminProductServlet?method=findAllProductsWithPage&num=1");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("出现问题");
		}
		return null;
	
	}

}
