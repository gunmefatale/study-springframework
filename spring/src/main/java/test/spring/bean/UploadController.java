package test.spring.bean;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/upload/*")
public class UploadController {

	@RequestMapping("uploadForm.git")
	public String uploadForm() {
		
		System.out.println("uploadForm 요청!!!");
		
		return "spring03/uploadForm";
	}
	
	@RequestMapping("uploadPro.git")
	public String uploadPro(String name, MultipartHttpServletRequest request) {
		
		System.out.println("uploadPro 요청!!!");
		System.out.println("name : " + name);
		System.out.println(request.getRequestURI());
		
		
		try {
			// 파라미터 이름(form에서 전달되는 name속성값) 주며, 해당 파일 정보 변수에 담기 
			MultipartFile mf = request.getFile("img");
			System.out.println("mf " + mf);
			// 파일 size 
//			long fileSize = mf.getSize();
//			System.out.println("fileSize : " + fileSize);
//			String org = mf.getOriginalFilename();
//			System.out.println("orgFileName : " + org);
			
			// 서버에 이미지 파일 저장 webapp(WebContent) > save 폴더 생성 (img,css,js 등은 WEB-INF안에 넣지 않는다!) 
			String path = request.getRealPath("save");					// 폴더 실제 경로 받아오기 
			System.out.println("save폴더 path : " + path);				
			// window 버전 
//			String imgPath = path + "||" + mf.getOriginalFilename();	// window : 저장경로 '||파일명.확장자' 로 저장할 이미지 전체 경로 저장.
			// macOS 버전
//			String imgPath = path + "/" + mf.getOriginalFilename();		// macOS : 저장경로 '/파일명.확장자' 로 저장할 이미지 전체 경로 저장.
//			System.out.println("imgPath : " + imgPath);
			
			// 파일이름 중복처리 : 오리지널파일명+시간(millis) + 확장자 
			String orgName = mf.getOriginalFilename();
			System.out.println("orgName : " + orgName);					
			// 확장자를 뺀 이름 (.이전) 
			String imgName = orgName.substring(0, orgName.lastIndexOf('.'));	// ex) Greece-Santorini02.jpeg 	==> .을 기준으로 전꺼 가져오기.
			System.out.println(".이전 imgName : " + imgName);
			// 확장자만 가져오기 (ex) .jpg)
			String ext = orgName.substring(orgName.lastIndexOf('.'));	// ex) Greece-Santorini02.jpeg 	==> .을 기준으로 뒤에꺼 가져오기.
			System.out.println("확장자만 ext : " + ext);
			// 현재시간 밀리세컨드 
//			long millis = System.currentTimeMillis();
//			// 저장시킬 이미지파일명 조합 
//			String newName = imgName + millis + ext;
//			System.out.println("newName : " + newName);
			
			// UUID + 확장자명 
			UUID uuid = UUID.randomUUID();
			System.out.println("UUID : " + uuid.toString().replace("-", ""));
			String newName = uuid.toString().replace("-", "") + ext;
			
			// 저장될 파일의 전체경로 세팅 : save경로 + 새이미지 파일명 
//			String imgPath = path + "||" + newName;					// window 버전 
			String imgPath = path + "/" + newName;					// macOS 버전 
			System.out.println("imgPath : " + imgPath);
			
			File f = new File(imgPath);					// 파일 객체 생성 
			mf.transferTo(f);							// 이미지 서버에 저장! 하기 위핸 위에것들 포함하여 try-catch로 묶어야 한다.
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "spring03/uploadPro";
	}
	
	
	
	// 다운로드 버튼을 보여줄 경로 매핑 
	@RequestMapping("downPage.git")
	public String downPage() {
		
		return "spring03/downPage";
	}
	
	// 다운로드 요청처리 매핑 
	@RequestMapping("download.git")
	public ModelAndView download(HttpServletRequest request, String imgname) {
		// 어떤 파일을 다운로드 시킬지 연결.
		// 서버상의 폴더에서 다운받을 수 있도록 파일 준비해놓고 경로 잡아서 전달. 
		System.out.println("imgname : " + imgname);
		String path = request.getRealPath("save");
		
		// 다운로드 시킬 파일의 전체 경로 문자열로 조합 
		String filePath = path + "/" + imgname;								// macOS 버전
//		String filePath = path + "||" + imgname;							// window 버전 
		System.out.println("filePath : " + filePath);
		File f = new File(filePath);
		
		//							view 이름,		view에게 전달할 데이터 이름, 데이터 객체 
		//						(String viewName, String modelName, Object modelObject)
		//								"fileDown" -> spring-servlet.xml에 <bean>객체 id와 같은지 확인.
		//								"downloadFile" -> DownloadView.java에 File 객체의 파라미터값이 같은지 확인.
		ModelAndView mv = new ModelAndView("fileDown", "downloadFile", f);
		System.out.println("mv : " + mv);
		
		return mv;
	}
}
