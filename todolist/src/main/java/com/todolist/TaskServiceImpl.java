import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.Task;
import com.todolist.TaskDao;
import com.todolist.TaskService;


@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDao taskDao;


    @Override
    public boolean addTask(Task task) {
        boolean flag=false;
        try{
            taskDao.addTask(task);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateTask(Task task) {
        boolean flag=false;
        try{
            taskDao.updateTask(task);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteTask(int id) {
        boolean flag=false;
        try{
            taskDao.deleteTask(id);
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Task findTaskById(int id) {
        return taskDao.findById(id);
    }

}