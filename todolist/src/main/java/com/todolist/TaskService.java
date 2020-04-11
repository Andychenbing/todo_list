import com.todolist.Task;

public interface TaskService {

    boolean addTask(Task task);
    boolean updateTask(Task task);
    boolean deleteTask(int id);
    Task findTaskById(int id);
}