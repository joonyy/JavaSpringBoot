package practice.mybatis_on_my_own.mapper;

import org.apache.ibatis.annotations.*;
import practice.mybatis_on_my_own.domain.User;
import practice.mybatis_on_my_own.service.UserService;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("select * from users")
    List<User> findAll();

//    @Insert("insert into users (username, email) values (#{username}, #{email})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

//    @Select("select * from users where id = #{id}")
    User findById(Long id);

//    @Update("update users set username = #{username}, email=#{email} where id = #{id}")
    void update(User user);

//    @Delete("delete from users where id  = #{id}")
    void delete(Long id);
}
