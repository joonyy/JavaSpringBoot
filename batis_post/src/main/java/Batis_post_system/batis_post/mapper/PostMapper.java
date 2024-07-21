package Batis_post_system.batis_post.mapper;

import Batis_post_system.batis_post.domain.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostMapper {
    @Select("select * from posts")
    List<Post> findAll();

    @Insert("insert into posts (writer, title, content) values (#{writer}, #{title}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(Post post);

    @Select("select * from posts where id = #{id}")
    Post findById(int id);

    @Update("update posts set writer = #{writer}, content = #{content}, title=#{title} where id = #{id}")
    void update(Post post);

    @Select("SELECT * FROM posts WHERE title LIKE CONCAT('%', #{keyword}, '%') OR content LIKE CONCAT('%', #{keyword}, '%')")
    List<Post> findByTitleOrContent(@Param("keyword") String keyword);

    @Select("SELECT * FROM posts WHERE writer LIKE CONCAT('%', #{writer}, '%')")
    List<Post> findByWriter(String writer);

    @Delete("delete from posts where id  = #{id}")
    void delete(int id);

}