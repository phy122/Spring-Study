package com.aloha.security_method.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.aloha.security_method.domain.UserAuth;
import com.aloha.security_method.domain.Users;

@Mapper
public interface UserMapper {

    // 회원 조회
    public Users select(String id) throws Exception;

    // 회원 가입
    public int join(Users user) throws Exception;

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 권한 등록
    public int insertAuth(UserAuth userAuth) throws Exception;

}

