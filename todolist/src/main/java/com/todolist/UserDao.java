import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import com.todolist.User;

@Mapper
public interface UserDao {

    /**
     * 用户数据新增
     */
    @Insert("insert into spring(id,content,createdTime) values (#{id},#{content},#{createdTime})")
    void addUser(User user);

    /**
     * 用户数据修改
     */
    @Update("update spring set content=#{content},createdTime=#{createdTime} where id=#{id}")
    void updateUser(User user);

    /**
     * 用户数据删除
     */
    @Delete("delete from spring where id=#{id}")
    void deleteUser(int id);

    /**
     * 根据用户名称查询用户信息
     *
     */
    @Select("SELECT id,content,createdTime FROM spring where id=#{id}")
    User findById(@Param("id") int id);

    /**
     * 查询所有
     */
    @Select("SELECT id,content,createdTime FROM spring")
    List<User> findAll();


}