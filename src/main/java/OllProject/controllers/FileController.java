package OllProject.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//upload file
@Controller
@RequestMapping(path="/file")
public class FileController {
	@PostMapping(path="/upload")
	@ResponseBody
	public ResponseEntity<Object> upload(@RequestParam("file") MultipartFile multipart) throws IOException{ 
		 File convFile = new File("fileName.txt");
		 FileOutputStream fos = new FileOutputStream(convFile); 
		 if(FilenameUtils.getExtension(multipart.getOriginalFilename()).equals("txt"))
		 {
			 convFile.createNewFile(); 
			 fos.write(multipart.getBytes());
			 fos.close(); 	
			 return ResponseEntity.status(HttpStatus.OK).body(convFile);   
		 }
		 else {
			 return extracted();
		}
    }
	private ResponseEntity<Object> extracted() {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\n" + 
		 		"    \"code\": 400,\n" + 
		 		"    \"message\": \"Invalid file format\"\n" + 
		 		"}");
	} 

	//download file
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void getFile(
	    HttpServletResponse response) {
	    try {
	    	String fileName = "fileName.txt";
	    	InputStream is = new FileInputStream(fileName);
	    	org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	    	response.setContentType("applecation/txt");
	    	response.flushBuffer();
	    } catch (IOException ex) {
	      throw new RuntimeException("IOError writing file to output stream");
	    }

	}
}
