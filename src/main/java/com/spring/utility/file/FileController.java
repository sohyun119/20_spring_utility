package com.spring.utility.file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file") //컨트롤러 자체에 url 경로 지정
public class FileController {
	
	/*

	# 스프링 파일관련기능(업로드 , 조회 , 다운로드 , 삭제 , 수정) 구현 방법

	1) application.properties 파일에 파일업로드 관련 설정을 추가한다.
	
		# 멀티파트 요청에서 개별 파일의 최대 허용 크기 (기본값 1MB)
		spring.servlet.multipart.max-file-size=30MB
		
		# 멀티파트 요청 전체의 최대 허용 크기 (기본값 10MB)         
		spring.servlet.multipart.max-request-size=100MB
		
		# 파일저장 경로 
		file.repo.path=C:/spring_file_test/
	
    2) MultipartFile 객체를 사용하여 파일관련 기능을 구현한다.

	 */
	
	
	@Value("${file.repo.path}") // application.properties 파일의 file.repo.path 경로 대입
	private String fileRepositoryPath;
	
	@GetMapping("/fileEx01")
	public String fileEx01() {
		return "fileEx01/fileEx01";
	}
	
	
	@PostMapping("/upload1")
	@ResponseBody
	public String upload1(@RequestParam("upFile") MultipartFile upFile) throws IllegalStateException, IOException { // *** RequestParam 어노테이션을 사용하여 MultipartFile 타입으로 받으면 된다 ***
		
		String responseMessage = "fail";
		
		if(!upFile.getOriginalFilename().isEmpty()) { //전송된 파일이 있으면
			
			File targetFile = new File(fileRepositoryPath + upFile.getOriginalFilename()); // 파일 객체를 생성한다. 
			upFile.transferTo(targetFile); // transferTo(파일객체) 메서드를 사용하여 파일저장소에 파일을 저장한다. 
			
			responseMessage = "success";
		}
		
		return responseMessage;
	}
	
	
	@PostMapping("/upload2")
	@ResponseBody		 //@RequestParam("name명") 어노테이션을 사용하여 List<MultipartFile>타입으로 파일을 전달받는다. 	
	public String upload2(@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		String responseMessage = "fail";
		
		// 업로드 날짜 생성
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String uploadDate = sdf.format(new Date());
		
		for (MultipartFile file : files) {
			
			if (!file.getOriginalFilename().isEmpty()) {  // 전송된 파일이 있으면
				
				// 원본 파일 이름
				String originalFilename = file.getOriginalFilename();
				
				// 범용고유식별자 UUID생성
				UUID uuid = UUID.randomUUID();
				
				// 파일 이름 수정
				String uploadFileName = uploadDate + "_" + uuid + "_" + originalFilename;
				
				// transferTo() 메서드를 사용하여 저장
				file.transferTo(new File(fileRepositoryPath + uploadFileName));
				
				responseMessage = "success";
				
			}
		
		}
		return responseMessage;
	}
	
	
	/*
	
	import org.springframework.core.io.InputStreamResource;
	import org.springframework.core.io.Resource;
	import org.springframework.core.io.UrlResource;
	import org.springframework.http.ContentDisposition;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	
*/
	
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException {
		// new UrlResource("file:" + 파일접근경로) 객체를 반환하여 이미지를 조회한다.
		return new UrlResource("file:" + fileRepositoryPath + fileName); 
	}
	
	@GetMapping("/downloadFile")
	public ResponseEntity<Object> downloadFile(@RequestParam("fileName") String fileName) throws MalformedURLException{
		
		String downloadFile = fileRepositoryPath + fileName;  // 이미지 경로 수정하여 사용
		
		try {
			
			Path filePath = Paths.get(downloadFile);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath));
			
			File file = new File(downloadFile);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	        
	}
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("deleteFileName") String deleteFileName) {
		
		String responseMessage = "fail";
		
		File deleteFile = new File(fileRepositoryPath + deleteFileName);
		
		if(deleteFile.exists()) { // 파일이 존재하면
			deleteFile.delete();
			responseMessage = "success";
		}
		
		return responseMessage;
	}
	
	
	@PostMapping("/update")
	@ResponseBody
	public String update(@RequestParam("deleteFileName") String deleteFileName
						,@RequestParam("modifyFile") MultipartFile modifyFile) throws IllegalStateException, IOException {
		
		String responseMessage = "fail";
		
		File deleteFile = new File(fileRepositoryPath + deleteFileName);
		if(deleteFile.exists() && !modifyFile.getOriginalFilename().isEmpty()) {
			deleteFile.delete(); // 파일삭제
			
			modifyFile.transferTo(new File(fileRepositoryPath + modifyFile.getOriginalFilename()));
			
			responseMessage = "success";
		}
		
		return responseMessage;
	}
	
	
	
	
	
	
	

}
