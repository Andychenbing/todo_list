import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;
import com.todolist.Task;

@Mapper
public interface TaskDao {

    @Insert("insert into spring(id,content,createdTime) values (#{id},#{content},#{createdTime})")
    void addTask(Task task);

    @Update("update spring set content=#{content},createdTime=#{createdTime} where id=#{id}")
    void updateTask(Task task);

    @Delete("delete from spring where id=#{id}")
    void deleteTask(int id);

    @Select("SELECT id,content,createdTime FROM spring where id=#{id}")
    Task findTaskById(@Param("id") int id);


}