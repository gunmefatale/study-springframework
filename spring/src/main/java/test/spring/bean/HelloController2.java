package test.spring.bean;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/sample/*")
public class HelloController2 {
	
	
	@RequestMapping("form.git")
	public String form() {
		
		System.out.println("form commint!!!");
		
		return "/WEB-INF/views/spring01/form.jsp";
	}

	
//	@RequestMapping("pro.git")
//	public String pro(String id, int pw) {
//		
//		System.out.println("pro page !!!");
//		System.out.println("id : " + id);
//		System.out.println("pw : " + pw);
//		System.out.println("pw : " + (pw+1));
//		
//	
//		return "/WEB-INF/views/spring01/pro.jsp";
//	}
	
	@RequestMapping("pro.git")
	public String pro(SampleDTO dto, String id, int pw) {
		
		System.out.println("pro page !!!");
		
		System.out.println("dto id : " + dto.getId());
		System.out.println("dto pw : " + dto.getPw()); 
		System.out.println("id : " + id);
		System.out.println("id : " + pw);
		
		
		return "spring01/pro";
	}
	
	
	
	@RequestMapping("hello.git")
	public String hello(@RequestParam("name") String name, @RequestParam("age") int age) {
		// ..8080/spring/sample/hello.git?name=java&age=10
		System.out.println("username : " + name);
		System.out.println("number : " + age);
		
		
		
		return "spring01/hello";
	}
	
	// List 처리 
	// Spring은 파라미터(매개변수)의 타입을 보고 객체를 생성한 후 바인딩(값 저장) 하므로,
	// 파라미터의 타입은 List와 같은 인페이스 타입이 아닌, 실제적인 클래스 타입으로 지정한다.
	@RequestMapping("hello2.git")
	public String hello2(@RequestParam("ids") ArrayList<String> ids) {
		// ...8080/spring/sample/hello2.git?ids=111&ids=222&ids=333
		System.out.println("ids : " + ids);
		
		return "spring01/hello";
	}
	
	
	// Array 배열 
//	@RequestMapping("hello3.git")
//	public String hello3(String[] ids) {
//		// ...8080/spring/sample/hello3.git?ids=111&ids=222&ids=333
//		
//		System.out.println("Stirng ids : " + ids);
//		System.out.println("Stirng ids : " + Arrays.toString(ids));
//		
//		return "/WEB-INF/views/spring01/hello.jsp";
//	}
	
	// Array 배열 
	@RequestMapping("hello3.git")
	public String hello3(String[] ids, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// ...8080/spring/sample/hello3.git?ids=111&ids=222&ids=333
		
		System.out.println("Stirng ids : " + ids);
		System.out.println("Stirng ids : " + Arrays.toString(ids));
		
		return "spring01/hello";
	}
	
	
	
	// request 통해 view로 데이터 전달 
	@RequestMapping("hello4.git")
	public String hello4(String id, String pw, HttpServletRequest request) {
		// ..8080/spring/sample/hello4.git?id=java&pw=1234 요청 
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		
		return "spring01/hello";
	}
	
	// Model 통해 view로 데이터 전달  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!(자주 사용함)
	@RequestMapping("hello5.git")
	public String hello5(String id, int pw, Model model) {
		// ..8080/spring/sample/hello5.git?id=java&pw=1234 요청 
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		// DTO 만들어 model로 보내기.
		SampleDTO dto = new SampleDTO();
		dto.setId("test");
		dto.setPw(1010);
		model.addAttribute("dto", dto);
		
		return "spring01/hello";
	}
	
	// ModelAndView 통해 데이터와 view 경로 한번에 리턴 
	@RequestMapping("hello6.git")
	public ModelAndView Hello6(String id, int pw) {
		// ..8080/spring/sample/hello6.git?id=java&pw=1234 요청 
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		ModelAndView mv = new ModelAndView(); 	// 객체생성 
		mv.addObject("id", id); 				// view로 전달할 데이터 추가 
		mv.addObject("pw", pw);
		// view경로 추가
		mv.setViewName("/WEB-INF/views/spring01/hello.jsp");
		
		return mv;
	}
		
	
	// @ModelAttribute
	@RequestMapping("hello7.git")
	public String hello7(String id, String pw, SampleDTO dto) {
		// ..8080/spring/sample/hello7.git?id=java&pw=1234 요청 
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		System.out.println("dto.id : " + dto.getId());
		System.out.println("dto.pw : " + dto.getPw());
		
		return "spring01/hello";
	}
	
	// @ModelAttribute
//	@RequestMapping("hello7.git")
//	public String hello7(@ModelAttribute("id") String id,
//			@ModelAttribute("pw") String pw, 
//			@ModelAttribute("dto") SampleDTO dto) {
//		// ..8080/spring/sample/hello7.git?id=java&pw=1234 요청 
//		System.out.println("id : " + id);
//		System.out.println("pw : " + pw);
//		System.out.println("dto.id : " + dto.getId());
//		System.out.println("dto.pw : " + dto.getPw());
//		
//		return "/WEB-INF/views/spring01/hello.jsp";
//	}
		
	// ..8080/spring/sample/hello8.git?col=red
	@RequestMapping("hello8.git")
	public String hello8() {
		
		System.out.println("hello8 !!! ");
		
		return "spring01/hello";
	}
	
	// 이 클래스 안에 있는 모든 mapping 메서드가 호출되기 전에 자동으로 먼저 호출되고,
	// 리턴되는 객체는 암묵적으로 Model에 추가되서 view까지 전달된다.
//	@ModelAttribute("tv")
//	public TvDTO getTv(String col) {
//		System.out.println("getTv 호출!!!");
//		
//		TvDTO tv = new TvDTO();
//		tv.setPower(true);
//		tv.setCh(10);
//		tv.setColor(col);
//		
//		return tv; // 암묵적으로 Model에 추가 TvDTO(.java) -> tvDTO(.jsp)
//	}
	
	@ModelAttribute
	public void getTv(String col, Model model) {
		System.out.println("getTv 호출!!!");
		
		TvDTO tv = new TvDTO();
		tv.setPower(true);
		tv.setCh(10);
		tv.setClolr(col);
		
		model.addAttribute("tv", tv);	// 명시적으로 Model에 추가하는 방식 
		
	}
	
	@RequestMapping("hello9.git")
	public String hello9() {
		
		System.out.println("hello9 !!! ");
		
		return "spring01/hello";
	}
	
}