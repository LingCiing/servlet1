package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.Mapper.UserMapper;
import org.example.pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class Mybatis {
    public boolean login(String name,String password) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(name,password);
        User login = mapper.login(user);
        if (login==null){
            return false;
        }else return true;
    }
}
