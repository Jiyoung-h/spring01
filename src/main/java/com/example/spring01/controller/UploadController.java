package com.example.spring01.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
    String uploadPath = "C:/upload";
    
    @RequestMapping(value="upload/uploadForm", method=RequestMethod.GET)
    public void fileupload() {
    }
    
    @RequestMapping(value="upload/uploadForm", method=RequestMethod.POST)
    public ModelAndView uploadForm(MultipartFile file, ModelAndView mv) {
 
        String fileName = file.getOriginalFilename();
        UUID uid = UUID.randomUUID();
    	String savedName = uid.toString() + "_" + fileName;
        File target = new File(uploadPath, savedName);
        
        //경로 생성
        if ( ! new File(uploadPath).exists()) {
            new File(uploadPath).mkdirs();
        }
        //파일 복사
        try {
            FileCopyUtils.copy(file.getBytes(), target);
            mv.addObject("file", file);
        } catch(Exception e) {
            e.printStackTrace();
            mv.addObject("file", "error");
        }
        //View 위치 설정
        mv.setViewName("upload/uploadResult");
        return mv;
    } 
}
