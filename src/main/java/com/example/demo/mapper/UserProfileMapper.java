package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {

	@Select("SELECT * FROM USERPROFILE WHERE id=${id}") //원하는 아이디의 정보만 조회
	UserProfile getUserProfile(@Param("id") String id);

	@Select("SELECT * FROM USERPROFILE") //리스트 형식으로 등록된 전체 회원 조회
	List<UserProfile> getUserProfileList();

	@Insert("INSERT INTO USERPROFILE (id, name, phone, address) VALUES('${id}', '${name}', '${phone}', '${address}')")//새로운 객체를 생성하는 쿼리
	//쿼리문에서 삽입할 값이 모두 String인데 따옴표를 넣지 않아 오류 발생했었음
	int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);
	
	@Update("UPDATE USERPROFILE SET name='${name}', phone='${phone}', address='${address}' WHERE id=${id}") 
	//원하는 아이디를 url에 포함 후 수정하는 쿼리
	//쿼리문에서 열이름='${변경할값}'의 작은 따옴표를 넣지 않아 오류발생했음
	int updateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone,
			@Param("address") String address);
	
	@Delete("DELETE FROM USERPROFILE WHERE id=${id}")
	int deleteUserProfile(@Param("id") String id);

}
