package spring.mvc.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String fileUploader(@RequestParam("file") MultipartFile file) {
		
		if(!file.isEmpty()) {
			BufferedOutputStream outputStream = null ;
			try {
				
				byte[] bytes = file.getBytes();
				String rootPath = System.getProperty("catalina.home");
			
				File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
			
				outputStream = new BufferedOutputStream(new FileOutputStream(newFile));
				outputStream.write(bytes);
				
				String returnString = "File is saved under: " + rootPath + File.separator + file.getOriginalFilename();
				System.out.println(returnString);	                
                return returnString;

				
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Exception Occured ! File couldnot be uploaded **** " + e.getMessage();
			}catch(IOException e){
				e.printStackTrace();
				return "Exception Occured ! File couldnot be uploaded **** " + e.getMessage();
			}finally {
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
            return "File upload is failed: File is empty";
        }
		
	}

}
