package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.Comment;

import java.util.List;

public interface CommentMapper {
    @Select("select * from comments where article_id =#{article_id}")
    List<Comment> SelectAllComments(String article_id);

    @Insert("insert into comments(article_id,content,from_uid) values (#{article_id},#{content},#{uid})")
    int InsertComment(@Param("article_id") String article_id,@Param("content") String content,@Param("uid") String uid);
}
