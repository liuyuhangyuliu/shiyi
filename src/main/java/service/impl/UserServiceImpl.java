package service.impl;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import service.UserService;
import utils.SqlSessionFactoryUtils;

public class UserServiceImpl implements UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User SelectUser(String username, String password){

        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);



        User user = userMapper.SelectUser(username,password);

        sqlSession.close();

        return user;

    }

    @Override
    public boolean SelectUserByUsername(String username) {
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.SelectUserByUsername(username);

        sqlSession.close();

        if(user == null)
            return false;
        else
            return true;
    }

    @Override
    public int InsertUser(String username, String password) {
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int rows = userMapper.InsertUser(username,password);
        sqlSession.close();
        return rows;
    }

    public User SelectUserByUid(String uid){
        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.SelectUserByUid(uid);
        sqlSession.close();
        return user;
    }

    public void UpdateCover(String coverSrc,String uid){
        SqlSession sqlSession = factory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.UpdateCover(coverSrc,uid);
        sqlSession.close();
    }
}
