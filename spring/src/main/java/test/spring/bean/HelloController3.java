package test.spring.bean;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sample2/*")
public class HelloController3 {

	// 의존성 자동 주입 : spring-servlet.xml 에 <bean> 태그로 등록한 객체를 스프링이 자동으로 체워준다. (빌려쓰는 개념)
//	@Autowired
//	private Date day = null;
	
	// 자동주입시, 변수의 타입을 보고 같은 타입으로 등록된 bean을 찾아서 주입해준다.
	// 이때, 같은 타입의 bean이 두개이상 등록되어 있을 경우 bean의 id속성값과 변수명으로 구분한다. 
	@Autowired
	private TestBean testBean = null;
	
	@Autowired
	private TestBean testBean2 = null;
	
	@RequestMapping("hello.git")
	public String hello() {
		
		//day = new Date();
//		System.out.println(day);
//		System.out.println(testBean);
		
//		testBean.setText("hello");					// 값저장
		System.out.println(testBean.getText());		// 값꺼내서 출력
		System.out.println(testBean.getNumber());	// 값꺼내서 출력
		System.out.println(testBean.getReg());		// 값꺼내서 출력
		System.out.println();
		System.out.println(testBean2.getText());		// 값꺼내서 출력
		System.out.println(testBean2.getNumber());	// 값꺼내서 출력
		System.out.println(testBean2.getReg());		// 값꺼내서 출력
//		testBean.func();							// 메서드 호출 
		
//		return "/WEB-INF/views/spring02/hello.jsp";
		return "spring02/hello";
	}
	
	
	@RequestMapping(value={"hello1.git", "hello2.git"}, params={"id=spring", "pw", "!age", "method=RequestMethod.get"})	// id=spring 파라미터가 요청되어야 한다고 제약 
	public String hello1(String id, String pw) {
		// ...8080/spring/sample2/hello1.git?id=spring&pw=1234
		
		System.out.println(id);
		System.out.println(pw);
		
//		return "/WEB-INF/views/spring02/hello.jsp";
		return "spring02/hello";
	}
	
	@RequestMapping("hello3.git")
//	public String hello3(@RequestParam(value="msg", required=false, defaultValue="lalala") String msg) {
	public String hello3(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "pw", required = true) String pw,
			@RequestParam(value = "auto", required = false, defaultValue = "0") String auto) {
		
		// ..8080/spring/sample2/hello3.git?msg=...
		//System.out.println(msg);
		
//		return "/WEB-INF/views/spring02/hello.jsp";
		return "spring02/hello";
	}
	
	@ResponseBody
	@RequestMapping("hello4.git")
	public String hello4() {
		
		return "hello...4!!!!";
	}
}
