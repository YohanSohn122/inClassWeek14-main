package com.example;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    @Autowired
    SqlSessionTemplate sqlSessionTemplate;
    public UserVO getUser(UserVO vo){
        return sqlSessionTemplate.selectOne("User.getUser", vo);
    }
}
