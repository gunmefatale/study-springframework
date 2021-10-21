package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("test.git")
	public String test() {
		
		System.out.println("test.git!!!");
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
}
