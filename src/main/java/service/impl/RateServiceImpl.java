package service.impl;

import mapper.RateMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import service.RateService;
import utils.SqlSessionFactoryUtils;

public class RateServiceImpl implements RateService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public float selectMyRate(String articleID, String uid) {
        SqlSession sqlSession = factory.openSession();
        RateMapper rateMapper = sqlSession.getMapper(RateMapper.class);
        return rateMapper.selectMyRate(articleID, uid);

    }

    @Override
    public void updateRate(int rate, String articleID, String uid) {
        SqlSession sqlSession = factory.openSession(true);
        RateMapper rateMapper = sqlSession.getMapper(RateMapper.class);
        rateMapper.updateRate(rate, articleID, uid);
        sqlSession.close();
    }

    @Override
    public int hasRate(String articleID, String uid) {
        SqlSession sqlSession = factory.openSession(true);
        RateMapper rateMapper = sqlSession.getMapper(RateMapper.class);
        return rateMapper.hasRate(articleID,uid);
    }

    @Override
    public void insertRate(int rate, String articleID, String uid) {

        SqlSession sqlSession = factory.openSession(true);
        RateMapper rateMapper = sqlSession.getMapper(RateMapper.class);
        rateMapper.insertRate(rate, articleID, uid);
        sqlSession.close();
    }
}
