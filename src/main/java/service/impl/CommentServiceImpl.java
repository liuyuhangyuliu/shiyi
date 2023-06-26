package service.impl;

import mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Comment;
import service.CommentService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Comment>SelectAllComments(String article_id){

        SqlSession sqlSession = factory.openSession();
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);

        List <Comment>comments = mapper.SelectAllComments(article_id);
        sqlSession.close();
        return comments;

    }


    public int InsertComments(String articleID,String content,String uid){
        //ctrl+alt+v生成变量
        //ctrl+shift+/ 代码块注释
        //alt+shift+insert/click 多行编辑
        SqlSession sqlSession = factory.openSession(true);
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        int i = mapper.InsertComment(articleID, content, uid);

        sqlSession.close();

        return i;

    }
}
