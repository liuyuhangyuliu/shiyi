package mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Article;
import pojo.Favorites;

import java.util.List;

public interface FavoritesMapper {

    @Select("select count(*) from favorites where article_id = #{articleID} and user_id = #{uid}")
    int isFavorites(@Param("articleID")String articleID,@Param("uid") String uid);

    @Insert("insert into favorites (article_id,user_id,article_title,article_imgSrc) values (#{articleID},#{uid},#{title},#{imgSrc})")
    void addFavorites(@Param("articleID")String articleID,@Param("uid")String uid,@Param("title")String title,@Param("imgSrc")String imgSrc);

    @Delete("delete from favorites where article_id =#{articleID} and user_id=#{uid}")
    void removeFavorites(@Param("articleID")String articleID,@Param("uid")String uid);

    @Select("select * from favorites where user_id = ${uid}")
    List<Favorites>selectMyFavorites(String uid);
}
