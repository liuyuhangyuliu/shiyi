package service;

import org.apache.ibatis.annotations.Param;
import pojo.Article;

import java.util.List;

public interface ArticleService {

    List<Article> selectAll();

    Article selectByID(int ID);

    void addClick(int ID);

    void addCommentNumber(int ID);

    void addMarkNumber(int ID);

    List<Article>selectByAuthor(String uid);

    void postArticle(String title,String username,String content,String preview,String uid,String cover);

    void updateAvgRate(String articleID);
}
