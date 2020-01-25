package com.sprhiber.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.sprhiber.model.UserFile;
import com.sprhiber.service.UserFileService;

@Controller
public class FileController {

	@Autowired
	UserFileService userFileService;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@ModelAttribute("userFile")
    public UserFile formBackingObject() {
        return new UserFile();
    }
	@GetMapping("/newFile")
	public String newFile(Model model){
		model.addAttribute("list",userFileService.list());
		return "newFileForm";
	}

	@PostMapping("/uploadFile")
	public String saveFile(@RequestParam("description") String description,	@RequestParam("id") Long id,@RequestParam("content") CommonsMultipartFile[] content) {
		if (content != null && content.length > 0) {
			for (CommonsMultipartFile aFile : content){
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                UserFile uploadFile = new UserFile();
                uploadFile.setName(aFile.getOriginalFilename());
                uploadFile.setDescription(description);
                uploadFile.setContent(aFile.getBytes());
                //id=null;
                if(id!=null) {
                	if(id>0) {
                		uploadFile.setId(id);
                	}
                }
                userFileService.update(uploadFile);
             }
        }
		return "redirect:/newFile";
	}
	@RequestMapping(value="/updateFile")
	public String update(@RequestParam("description") String description,@RequestParam("id") Long id,
			@RequestParam("content") CommonsMultipartFile[] content) {
			if (content != null && content.length > 0) {
            for (CommonsMultipartFile aFile : content){
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                UserFile uploadFile = new UserFile();
                uploadFile.setName(aFile.getOriginalFilename());
                uploadFile.setDescription(description);
                uploadFile.setContent(aFile.getBytes());
                uploadFile.setId(id);
                userFileService.update(uploadFile);               
            }
        }
		return "redirect:/newFile";	
	}
	
	@GetMapping("/updateUserFile")
	public String updateFileForm(HttpServletRequest request,Model model) {
		Long id=Long.parseLong(request.getParameter("id"));
		model.addAttribute("userFile",userFileService.getUserFile(id));
		model.addAttribute("list",userFileService.list());
//		return "updateFileForm";
		return "newFileForm";	
	}
	@GetMapping("/deleteUserFile")
	public String deleteUserFile(HttpServletRequest request) {
		Long id=Long.parseLong(request.getParameter("id"));
		userFileService.remove(id);
		return "redirect:/newFile";
	}
	@GetMapping("/downloadDoc" )
    public void downloadDocument(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		UserFile document = userFileService.getUserFile(id);
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getName() +"\"");
        FileCopyUtils.copy(document.getContent(), response.getOutputStream());  
    }
	@GetMapping("/viewImg")
	public  void showImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id=Long.parseLong(request.getParameter("id"));
		UserFile document = userFileService.getUserFile(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(document.getContent());
		response.getOutputStream().close();
	}
}