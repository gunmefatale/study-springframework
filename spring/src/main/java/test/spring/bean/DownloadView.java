package test.spring.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


public class DownloadView extends AbstractView {
	
	public DownloadView() {
		setContentType("application/download; charset=utf-8"); 
	}

	@Override							
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		// Map<String, Object> model 매개변수에 ModelAndView를 통해 보내온 인자를 맵형태로 받아줌.
		
		
		File file = (File)model.get("downloadFile");			// ModelAndView에 modelName으로 지정한 이름을 주고 File객체 꺼내기 
		response.setContentType(getContentType()); 		
		response.setContentLength((int)file.length());			// 파일 용량 전달	
		
		// 다운시키는 파일 이름 인코딩 별도처리 
		String fileName = java.net.URLEncoder.encode(file.getName(), "UTF-8"); 
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";"); 
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		// 파일 보내기위해 output 정보 읽어서 객체에 담기 
		OutputStream out = response.getOutputStream();		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);					// 서버(pc) 파일객체 가져와 input
			FileCopyUtils.copy(fis, out);						// output으로 전달 (서버pc에서 파일을 카피하여 밖으로 송출)
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fis != null) { try {fis.close();}catch(Exception e2) { e2.printStackTrace(); } }
			out.flush();
		}
		
		
		
	}
	
}
