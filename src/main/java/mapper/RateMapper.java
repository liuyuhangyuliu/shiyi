package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface RateMapper {

    @Select("select rate from rate where articleID =#{articleID} and uid =#{uid}")
    float selectMyRate(@Param("articleID")String articleID,@Param("uid")String uid);

    @Select("select COUNT(*) from rate where articleID =#{articleID} and uid =#{uid}")
    int hasRate(@Param("articleID")String articleID,@Param("uid")String uid);

    @Update("update rate set rate =#{rate} where articleID =#{articleID} and uid =#{uid}")
    void updateRate(@Param("rate")int rate,@Param("articleID")String articleID,@Param("uid")String uid);

    @Insert("insert into rate (rate,articleID,uid) values (#{rate},#{articleID},#{uid})")
    void insertRate(@Param("rate")int rate,@Param("articleID")String articleID,@Param("uid")String uid);
}
