package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

@RestController // 스프링이 알아서 컨트롤러로 인식하는 어노테이션

public class UserProfileController {

	private UserProfileMapper mapper; //UserProfileMapper를 선언함
	

	public UserProfileController(UserProfileMapper mapper) { //생성자를 통해서 객체를 받겠다 
		this.mapper = mapper;
	}

	//get 조회(Read) / put 삽입 (Create) / post 수정 (Update) / delete 삭제 (Delete)
	
	@GetMapping("/user/{id}") //localhost:8080/user/{id}로 원하는 아이디의 정보를 조회할 수 있음
		public UserProfile getUserProfile(@PathVariable("id")String id) {
			return mapper.getUserProfile(id);
			
		}
	
	@GetMapping("/user") //등록된 전체 user를 조회할 수 있음
	public List<UserProfile> getUserProfileList(){
		return mapper.getUserProfileList();
	}
	
	@PutMapping("/user/{id}") // 생성  / 추가할 아이디, 이름, 주소를 파라미터로 전달 받음
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
				@RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.insertUserProfile(id, name, phone, address);
		
	}
	
	@PostMapping("/user/{id}") //수정
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
				@RequestParam("phone") String phone, @RequestParam("address") String address) {
		mapper.updateUserProfile(id, name, phone, address);
		
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(@PathVariable("id") String id) {
		mapper.deleteUserProfile(id);
		
	}
			
		
	
	


}

//public class TestController {
//
//	 // MySQL Connector 의 클래스. DB 연결 드라이버 정의
//	    private static final String DRIVER = "org.mariadb.jdbc.Driver";
//	    // DB 경로
//	    private static final String URL = "jdbc:mariadb://localhost:3305/test";
//	    private static final String USER = "root";
//	    private static final String PASSWORD = "1234";
//
//	    @Test
//	    public void testConnection() throws Exception {
//	        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
//	        Class.forName(DRIVER);
//	        try {
//	            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//	            System.out.println(connection);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//	}
