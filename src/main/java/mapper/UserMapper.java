package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import pojo.User;

public interface UserMapper {

    @Select("select * from user where username =#{username} and password =#{password}")
    User SelectUser(@Param("username") String username,@Param("password") String password);

    @Select("select * from user where username =#{username}")
    User SelectUserByUsername(String username);

    @Insert("insert into user(username,password,email,coverSrc,avatarSrc,uid) values(#{username},#{password},default,default,default,0)")
    int InsertUser(@Param("username")String username,@Param("password")String password);

    @Select("select * from user where uid =#{uid}")
    User SelectUserByUid(String uid);

    @Update("update user set coverSrc =#{coverSrc} where uid =#{uid}")
    void UpdateCover(@Param("coverSrc") String coverSrc,@Param("uid") String uid);
}
