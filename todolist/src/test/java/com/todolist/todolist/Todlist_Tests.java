package com.todolist.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.todolist.User

@SpringBootTest
class TodolistApplicationTests {
    @Autowired
    private UserRestController UserController;

    @Test
    public void testAddUser() throws Exception {
       User user = new User();
        user.setId(1);
        user.setContent("Restful API homework");
        user.setCreatedTime("2019-05-15T00:00:00Z");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .post("/api/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));

        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setContent("Restful API homework222");
        user.setCreatedTime("2019-08-15T00:00:00Z");
        Gson gosn = new Gson();
        RequestBuilder builder = MockMvcRequestBuilders
                .put("/api/user/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(gosn.toJson(user));
        MvcResult result = mvc.perform(builder).andReturn();
    }

    @Test
    public void testQueryUser() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/api/user/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void testDeleteUser() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .delete("/api/user/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult result = mvc.perform(builder).andReturn();


}