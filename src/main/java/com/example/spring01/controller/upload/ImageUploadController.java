package com.example.spring01.controller.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageUploadController {
	
	@ResponseBody
	@RequestMapping(value="imageUpload.do", method=RequestMethod.POST)
	public void imageUpload(HttpServletRequest request, 
			HttpServletResponse response, 
			@RequestParam MultipartFile upload,
			@RequestParam(value="CKEditorFuncNum", required=false) String CKEditorFuncNum ) 
					throws Exception{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String fileName = upload.getOriginalFilename();
		byte[] bytes=upload.getBytes();
		String uploadPath="C:\\workspace-spring-tool-suite-4-4.8.0.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\spring01\\WEB-INF\\views\\images\\";
		OutputStream out=new FileOutputStream(new File(uploadPath + fileName));
		out.write(bytes);
		String callback=request.getParameter("CKEditorFuncNum");
		PrintWriter printWriter=response.getWriter();
		String fileUrl=request.getContextPath()+"/images/"+fileName;
		printWriter.println("<script>window.parent.CKEDITOR.tools.callFunction(" 
				+ callback + ",'" + fileUrl + "','이미지가 업로드되었습니다.')" 
				+ "</script>");
		printWriter.flush();
	}
}
