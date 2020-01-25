package com.sprhiber.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sprhiber.model.UserVideo;
import com.sprhiber.service.UserVideoService;

@Controller
public class UserVideoController {
	
	@Autowired
	UserVideoService userVideoService;
	@ModelAttribute("userVideo")
	public UserVideo fromBackingObject() {
		return new UserVideo();
	}
	@GetMapping("/videoForm")
	public String videoForm(Model model) {
		model.addAttribute("list",userVideoService.allUserVideo());
		return "videoForm";
	}

	@PostMapping("/uploadVideo")
	public String saveVideo(@RequestParam("description") String description,
			@RequestParam("id") Long id,@RequestParam("content") CommonsMultipartFile[] content) {
		if (content != null && content.length > 0) {
			for (CommonsMultipartFile aFile : content){
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                UserVideo uploadVideo = new UserVideo();
                uploadVideo.setName(aFile.getOriginalFilename());
                uploadVideo.setDescription(description);
                uploadVideo.setContent(aFile.getBytes());
                //id=null;
                if(id!=null) {
                	if(id>0) {
                		uploadVideo.setId(id);
                	}
                }
                userVideoService.update(uploadVideo);
             }
        }
		return "redirect:/videoForm";
	}
	@GetMapping("/updateUserVideo")
	public String updateFileForm(HttpServletRequest request,Model model) {
		Long id=Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		model.addAttribute("userVideo",userVideoService.getUserVideo(id));
		model.addAttribute("list",userVideoService.allUserVideo());
//		return "updateFileForm";
		return "videoForm";	
	}
	@GetMapping("/viewVideo")
	public  void showImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		UserVideo document = userVideoService.getUserVideo(id);
		response.setContentType("video/mp4,video/MKV");
		response.getOutputStream().write(document.getContent());
		response.getOutputStream().close();
	}
	@GetMapping("/downloadVideo" )
    public void downloadDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		UserVideo document = userVideoService.getUserVideo(id);
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());  
    }
	@GetMapping("/deleteUserVideo")
	public String deleteUserFile(HttpServletRequest request) {
		Long id=Long.parseLong(request.getParameter("id"));
		userVideoService.remove(id);
		return "redirect:/videoForm";
	}
	
}
