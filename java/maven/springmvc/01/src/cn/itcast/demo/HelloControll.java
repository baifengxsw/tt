package cn.itcast.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloControll {
	//绑定请求地址
	@RequestMapping("hello")
	public ModelAndView hello() {
		System.out.println("hello world");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "hello dfsf");
		//相应的地址
		mav.setViewName("jsp/hello.jsp");
		return mav;
	}
}
