package com.todolist.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.todolist.Task

@SpringBootTest
class TodolistApplicationTests {
    @Autowired
    private TaskRestController TaskController;

    @Test
    public void testAddTask() throws Exception {
       Task task = new Task();
        task.setId(1);
        task.setContent("Restful API homework");
        task.setCreatedTime("2019-05-15T00:00:00Z");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/api/task")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));

        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateTask() throws Exception {
        Task task = new Task();
        task.setContent("Restful API homework222");
        task.setCreatedTime("2019-08-15T00:00:00Z");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .put("/api/task/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));
        MvcResult result = mvc.perform(builder).andReturn();
    }

    @Test
    public void testQueryTask() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/api/task/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteTask() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .delete("/api/task/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();


}