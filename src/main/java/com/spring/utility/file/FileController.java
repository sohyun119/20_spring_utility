package com.spring.utility.file;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
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
		
		File targetFile = new File(fileRepositoryPath + upFile.getOriginalFilename()); // 파일 객체를 생성한다. 
		upFile.transferTo(targetFile); // transferTo(파일객체) 메서드를 사용하여 파일저장소에 파일을 저장한다. 
		
		return responseMessage;
	}
	
	
	
	
	
	
	
	

}
