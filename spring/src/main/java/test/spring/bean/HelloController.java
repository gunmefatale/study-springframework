package test.spring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



// Controller 생성 
// @Controller 어노테이션 : 컨트롤러의 역할을 하는 클래스라고 어노테이션(@Controller)이라고 선선.
@Controller

// 클래스 level에 RequestMapping 적용 : 클래스 내의 모든 mapping경로들의 주소를 지정.
// 		localhost:8080/spring"/hello/"hello.git 경로 중간에 한번 더 거치게 된다.
//@RequestMapping("/hello/")				
@RequestMapping("/hello/*")					// @GetMapping, @PostMapping 사용시 /'*'을 추가해야 사용가능.
public class HelloController {
	
	// @RequestMapping 어노테이션 : 요청 주소와 () 안에 작성된 주소가 동일하면 어노테이션이 붙은 메서드들 실행시켜줌.
	// 메서드 : 리턴타입 Stiring, 리턴값은 요청이 들어왔을때 보여줘야하는 jsp 파일의 전체 경로 
//	@RequestMapping("hello.git")	
//	@RequestMapping("*.git")										// 와일드카드 매핑 
//	@RequestMapping({"hello.git", "hi.git", "ciao.git"})			// 여러경로
//	@RequestMapping("?.git")										// 한글자.git 
//	@RequestMapping("hello?.git")									// helllo'한글자'.git 
//	@RequestMapping(value="hello.git", method=RequestMethod.GET)	// GET방식의 metod지								
//	@RequestMapping(value="hello.git", method=RequestMethod.POST)	// POST방식의 metod지								
	@RequestMapping(value="hello.git", method=RequestMethod.POST)									
	public String hello() {
		// 로직처리 // Model 호출 
		System.out.println("hello");
		
		return "/WEB-INF/views/spring01/hello.jsp";
	} 
	
	// @GetMapping
	@GetMapping("hello2.git")
	public String hello2() {
		System.out.println("hello2!!! GetMapping");
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	// @PostMapping
	@PostMapping("hello3.git")
	public String hello3() {
		System.out.println("hello3!!! PostMapping");
		
		return "/WEB-INF/views/spring01/hello.jsp";
	}
	
	
	// http://localhost:8080/spring/hello/hello.git
	// 						  ^		  ^			^
	//						  |		  |			|
	// 					  contextPath |			|
	//				class level @RequestMapping	|
	//							method level @RequestMapping
}
