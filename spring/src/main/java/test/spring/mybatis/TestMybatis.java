package test.spring.mybatis;

import java.sql.Timestamp;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.bean.TestDTO;

@Controller
@RequestMapping("/mybatis/*")
public class TestMybatis {

	// 쿼리문 호출 : 커넥션 필요 -> sqlSession bean 객체 가져오기 
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// 테스트할 uri 매핑 메서드 하나 추가 
	@RequestMapping("mybatis.git")
	public String mybatis() {
		
		System.out.println(sqlSession);
		
		return "spring02/hello";
	}
	
	@RequestMapping("test.git")
	public String test(Model model) {
		
		int count = (Integer)sqlSession.selectOne("test.userCount");
		int maxAge = (Integer)sqlSession.selectOne("test.maxAge");
		List<TestDTO> userList = sqlSession.selectList("test.selectAll");
		TestDTO user = sqlSession.selectOne("test.getOneUser", "java");
		Timestamp reg = sqlSession.selectOne("test.getReg", "java");
		// DB에 insert (저장) 하기 
		TestDTO dto = new TestDTO();
		dto.setId("Ggobugi");
		dto.setPw("1234");
		dto.setAge(29);
		int res = sqlSession.insert("test.insertUser", dto);
		
		// 결과 view에 전달 
		model.addAttribute("count", count);
		model.addAttribute("maxAge", maxAge);
		model.addAttribute("userList", userList);
		model.addAttribute("userOne", user);
		model.addAttribute("reg", reg);
		model.addAttribute("res", res);
		
		
		return "spring04/test";
	}
	
	// insert form
	@RequestMapping("insertForm.git")
	public String insertForm() {
		
		
		return "spring04/insertForm";
	}
	// insert pro
	@RequestMapping("insertPro.git")
	public String insertPro(TestDTO dto, Model model) {
		
		int result = sqlSession.insert("test.insertUser", dto);
		
		// view에 insert 결과 전달.
		model.addAttribute("result", result);
		
		
		return "spring04/insertPro";
	}
	
	// update form
	@RequestMapping("updateForm.git")
	public String updateForm(Model model) {
		
		String id = "Ggobuk";
		// id 주고 해당 회원 정보를 모두 DB에서 가져오기 
		TestDTO dto = sqlSession.selectOne("test.getOneUser", id);
		// view에 결과 전달.
		model.addAttribute("user", dto);
		
		
		return "spring04/updateForm";
	}
	// update pro
	@RequestMapping("updatePro.git")
	public String updatePro(TestDTO dto, Model model) {
		
		dto.setId("Ggobuk");
		int result = sqlSession.update("test.updateUser", dto);
		
		// view에 결과 전달.
		model.addAttribute("result", result);
		
		
		return "spring04/updatePro";
	}
	
	// dalete form
	@RequestMapping("deleteUser.git")
	public String deleteUser(Model model) {
		
		String id = "java11";
		int result = sqlSession.delete("test.deleteUser", id);
		
		// view에 결과 전달.
		model.addAttribute("result", result);
		
		return "spring04/deleteResult";
	}
	// dalete pro
}
