import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.Task;
import com.todolist.TaskService;


@RestController
@RequestMapping(value = "/api/task")
public class TaskRestController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "/task", method = RequestMethod.POST)
    public boolean addTask( Task task) {
        System.out.println("开始新增...");
        return taskService.addTask(task);
    }

    @RequestMapping(value = "/task", method = RequestMethod.PUT)
    public boolean updateTask( Task task) {
        System.out.println("开始更新...");
        return taskService.updateTask(task);
    }

    @RequestMapping(value = "/task", method = RequestMethod.DELETE)
    public boolean delete(@RequestParam(value = "id", required = true) int taskId) {
        System.out.println("开始删除...");
        return taskService.deleteTask(taskId);
    }


    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public User findByTaskName(@RequestParam(value = "id", required = true) int id) {
        System.out.println("开始查询...");
        return taskService.findTaskById(id);
    }

}