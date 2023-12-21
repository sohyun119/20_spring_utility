package com.spring.utility.scheduler;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class SchedularService {
	
	/*
	  
	   [ 스프링 배치 스케쥴러 구현 방법 ]
	  
	  
	   1) Application Class를 수정한다.
	  
	  	
		  @EnableScheduling		(추가)					
	  
	  
	   	2) Service로직에서 @Scheduled(cron="초 분 시 일 월 요일 (연도)") 선언 후 배치를 사용한다.
	 
	 	- [ 제약사항 ] 
	 	
	 	 1) return을 사용할 수 없다.
	 	 2) parameter를 사용할 수 없다. 
	 
	*/
	
	
	/*
	 
	  [ 스프링 스케쥴러 설정 ] 
	 
	  @Scheduled(cron="1 2 3 4 5 6 (7)")
	 
	  [ 필드 ]
	  
	 	1) 초	2) 분	3) 시	4) 일	5) 월	6) 요일	  7) 연도(optional) 	
	 
	 
	  [ 표기법 ]
	  
	 	 * : 모든 경우의 수
	 	 ? : 사용하지 않음 
	 	 - : 기간
	 	 , : 복수 선택
	 	 / : 시작시간과 반복 간격 설정  
	     L : 마지막 기간
	 	 W : 가장 가까운 평일 동작
	 
	 
	   [ 샘플 예시 ]    
	    
	 	@Scheduled(cron="0 0 15 * * *")		     > 매일 15시에 실행 
 	 	@Scheduled(cron="0 30 15 * * *")		 > 매일 15시 30분에 실행 
 	  	@Scheduled(cron="0 0/15 * * * *")		 > 매일 15분 간격으로 실행
	 	@Scheduled(cron="0 0/10 12,0 * * *") 	 > 매일 12시 , 0시에 10분 간격으로 실행 
	 	@Scheduled(cron="0 0 9-12 * * *")  		 > 매일 9시 ~ 12시 정각에 실행
	    @Scheduled(cron="0 0 0 ? * MON")	 	 > 매주 월요일 0시에 실행
	 	@Scheduled(cron="0 0 18 ? * MON-FRI")	 > 매주 월~금(평일) 18시에 실행 
	  
	 */
	
	
	@Autowired
	private SchedularDAO schedularDAO;
	
	//@Scheduled(cron="*/10 * * * * *")
	public void getProductList() { 
		
		System.out.println("ex) 00시 배치");
		
		List<Map<String,Object>> productList = schedularDAO.selectListProduct();
		for (Map<String, Object> map : productList) {
			System.out.println(map);
		}
		System.out.println();
		
	}
	
	//@Scheduled(cron="*/10 * 19 20 12 *")
	public void getBrandList() { 
		
		System.out.println("ex) 00시 배치");
		
		List<Map<String,Object>> brandList = schedularDAO.selectListBrand();
		for (Map<String, Object> map : brandList) {
			System.out.println(map);
		}
		
	}
	
	
	
}
