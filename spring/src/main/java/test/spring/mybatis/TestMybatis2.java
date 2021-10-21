package test.spring.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import test.spring.bean.TestDTO;

// 4. src > test.spring.mybatis > TestMybatis2.java 클래스 파일 만들기.
// 		4-1. @Controller, @RequestMapping("") -> ("") 사이에 "web 브라우저 중간에 들어갈 주소 지정해주기."

@Controller
@RequestMapping("/mybatis2/*")
public class TestMybatis2 {
	
	// 4-2 
	@Autowired
	private SqlSessionTemplate sqlSession = null;
	
	// 4-3
	//	6-1 Model model selectIf()메서드 안에 파라미터값으로 넣어주기.
	@RequestMapping("selectIf.git")
	public String selectIf(Model model) {
		
		// 6 src > test.spring.mybatis > TestMybatis2.java > <select>태그의 값 넣어주고 호출하기.
		//		id 하나 넘겨주고 해당 id가 db에 존재하는지 (id 중복여부) 
		// 6-2	webapp > WEB-INF > views > spring05 > select.jsp에 model.addAttribute("result", result); 넘겨준 값 확인하기.
//		int result = sqlSession.selectOne("mybatis.selectIf", "java");
		
		// 7-2 src > sql > mybatisSQL.xml에 <selec> 태그 지정해준 값 가져와 view로 뿌려주기.
//		int result = sqlSession.selectOne("mybatis.selectIf2");					// 총 갯수 나옴 
//		int result = sqlSession.selectOne("mybatis.selectIf2", "java");			// 조건에 맞는것 나
		TestDTO dto = new TestDTO();
//		dto.setId("java"); 			// id 파라미터 값으로 전달하기.
//		dto.setPw("2222"); 			// pw 파라미터 값으로 전달하기.
//		dto.setAge(30); 			// age 파라미터 값으로 전달하기.
		
//		int result = sqlSession.selectOne("mybatis.selectIf3", dto);
//		int result = sqlSession.selectOne("mybatis.selectIf4", dto);
//		int result = sqlSession.selectOne("mybatis.choose", dto);
//		int result = sqlSession.selectOne("mybatis.selectTrim", dto);
//		int result = sqlSession.update("mybatis.updateTest", dto);
		
//		List list = new ArrayList();
//		list.add("Ggobuk");
//		list.add("Ggobugi");
//		list.add("java");
//		list.add("hahaha");
//		list.add("hohoho");
//		int result = sqlSession.selectOne("mybatis.selectIn", list);
		
		// id j 두개 데이터를 파라미터값 hashmap으로 보내기 
		// pw 1 두개 데이터를 파라미터값 hashmap으로 보내기 
//		HashMap map = new HashMap();
//		map.put("column", "id");
//		map.put("keyword", "j");
//		int result = sqlSession.selectOne("mybatis.selectLike", map);
	
		dto.setId("hehehe");
		dto.setPw("3333");
		dto.setAge(30);
		int result = sqlSession.insert("mybatis.insertSeq", dto);
		System.out.println("age : " + dto.getAge());
		
		// view 로 전달.
		model.addAttribute("result", result);
		
		
		// 4-4 webapp > WEB-INF > views > spring05 > select.jsp
		return "spring05/select";
	}
}
