package service.impl;

import mapper.FavoritesMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Favorites;
import service.FavoritesService;
import utils.SqlSessionFactoryUtils;

import java.util.List;

public class FavoritesServiceImpl implements FavoritesService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public int isFavorites(String articleID, String uid) {
        SqlSession sqlSession = factory.openSession();
        FavoritesMapper favoritesMapper = sqlSession.getMapper(FavoritesMapper.class);
        return favoritesMapper.isFavorites(articleID, uid);
    }

    public List<Favorites>selectMyFavorites(String uid){
        SqlSession sqlSession = factory.openSession();
        FavoritesMapper favoritesMapper = sqlSession.getMapper(FavoritesMapper.class);
        List<Favorites> MyFavorites = favoritesMapper.selectMyFavorites(uid);
        sqlSession.close();
        return MyFavorites;
    }

    public void addFavorites(String articleID,String uid,String title,String imgSrc){
        SqlSession sqlSession = factory.openSession(true);
        FavoritesMapper favoritesMapper = sqlSession.getMapper(FavoritesMapper.class);
        favoritesMapper.addFavorites(articleID,uid,title,imgSrc);
        sqlSession.close();
    }

    @Override
    public void removeFavorites(String articleID, String uid) {
        SqlSession sqlSession = factory.openSession(true);
        FavoritesMapper favoritesMapper = sqlSession.getMapper(FavoritesMapper.class);
        favoritesMapper.removeFavorites(articleID,uid);
        sqlSession.close();
    }
}
