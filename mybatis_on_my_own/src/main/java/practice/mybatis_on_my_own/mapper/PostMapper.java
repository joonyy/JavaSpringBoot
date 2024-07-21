package practice.mybatis_on_my_own.mapper;

import org.apache.ibatis.annotations.*;
import practice.mybatis_on_my_own.domain.Post;
import practice.mybatis_on_my_own.service.UserService;

import java.util.List;

@Mapper
public interface PostMapper {
//    @Select("select * from posts")
    List<Post> findAll();

//    @Insert("insert into posts (writer, title, content) values (#{writer}, #{title}, #{content})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(Post post);

//    @Select("select * from posts where id = #{id}")
    Post findById(int id);

//    @Update("update posts set content = #{content}, title=#{title} where id = #{id}")
    void update(Post post);

//    @Delete("delete from posts where id  = #{id}")
    void delete(int id);

}
