package service.impl;

import mapper.ArticleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Article;
import service.ArticleService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Article> selectAll() {

        SqlSession sqlSession = factory.openSession();

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        List<Article> articles = mapper.selectAll();

        sqlSession.close();
        return articles;
    }

    @Override
    public Article selectByID(int ID) {
        SqlSession sqlSession = factory.openSession(true);

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        Article article = mapper.selectByID(ID);

        sqlSession.close();
        return article;
    }

    public void addClick(int ID){
        SqlSession sqlSession = factory.openSession(true);

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        mapper.addClick(ID);

        sqlSession.close();


    }

    public void addCommentNumber(int ID){
        SqlSession sqlSession = factory.openSession(true);

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        mapper.addCommentNumber(ID);

        sqlSession.close();
    }

    @Override
    public void addMarkNumber(int ID) {
        SqlSession sqlSession = factory.openSession(true);

        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);

        mapper.addMarkNumber(ID);

        sqlSession.close();
    }

    public List<Article>selectByAuthor(String uid){
        SqlSession sqlSession = factory.openSession();
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article>MyArticles = mapper.selectByAuthor(uid);
        sqlSession.close();
        return MyArticles;

    }

    @Override
    public void postArticle(String title, String username, String content, String preview, String uid,String cover) {
        SqlSession sqlSession = factory.openSession(true);
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        mapper.postArticle(title, username, content, preview, uid, cover);
        sqlSession.close();
    }

    public void updateAvgRate(String articleID){
        SqlSession sqlSession = factory.openSession(true);
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        mapper.updateAvgRate(articleID);
        sqlSession.close();
    }

}
