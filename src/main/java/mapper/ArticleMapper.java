package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.Article;

import java.util.List;

public interface ArticleMapper {
    @Select("select * from article")
    List<Article> selectAll();

    @Select("select * from article where articleID = #{ID}")
    Article selectByID(int ID);

    @Update("update article set articleClick = articleClick + 1 where articleID = #{ID}")
    void addClick(int ID);

    @Update("update article set comment_number = comment_number + 1 where articleID = #{ID}")
    void addCommentNumber(int ID);

    @Update("update article set mark_number = mark_number + 1 where articleID = #{ID}")
    void addMarkNumber(int ID);

    @Select("select * from article where author_uid = #{uid}")
    List<Article>selectByAuthor(String uid);

    @Insert("insert into article (articleTitle,articleAuthor,articleContent,articlePreview,imgSrc,author_uid) values (#{title},#{username},#{content},#{preview},#{cover},#{uid})")
    void postArticle(@Param("title")String title,@Param("username")String username,@Param("content")String content,@Param("preview")String preview,@Param("uid")String uid,@Param("cover")String cover);


    @Update("UPDATE article SET rate = (SELECT AVG(rate) FROM rate WHERE articleID = #{articleID}) WHERE articleID = #{articleID} ")
    void updateAvgRate(String articleID);
}
