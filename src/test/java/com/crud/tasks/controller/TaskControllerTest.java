package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void testGetTasks() throws Exception {
        //Given
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1L,"title", "content"));
        when(taskMapper.mapToTaskDtoList(dbService.getAllTasks())).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/tasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1)))//1L nie pasuje, nie odróżnia longów
                .andExpect(jsonPath("$[0].title", is("title")))
                .andExpect(jsonPath("$[0].content", is("content")));
    }
    @Test
    public void testGetTask() throws Exception {
        //Given
        Long id = 1L;
        TaskDto taskDto = new TaskDto(1L,"title", "content");
        Task task = new Task(1L, "title", "content");
        when(dbService.getTask(anyLong())).thenReturn(java.util.Optional.ofNullable(task));
        when(taskMapper.mapToTaskDto(ArgumentMatchers.any(Task.class))).thenReturn(taskDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        //When & Then
        mockMvc.perform(get("/v1/tasks" + "/" + id)
                //.param("taskId", "1" )
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("title")))
                .andExpect(jsonPath("$.content", is("content")));
    }
    @Test
    public void testDeleteTask() throws Exception {
        //Given
        Long id = 1L;
        doNothing().when(dbService).deleteTask(anyLong());

        //When & Then
        mockMvc.perform(delete("/v1/tasks" + "/" + id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));
    }
    @Test
    public void testUpdateTask() throws Exception {
        //Given
        TaskDto taskDto = new TaskDto(1L,"title", "content");
        TaskDto taskDtoUpdate = new TaskDto(10L,"title update", "content update");

        when(taskMapper.mapToTaskDto(dbService.saveTask(taskMapper.mapToTask((ArgumentMatchers.any(TaskDto.class))))))
        .thenReturn(taskDtoUpdate);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        // When & Then
        mockMvc.perform(put("/v1/tasks").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", is(10)))
                .andExpect(jsonPath("$.title", is("title update")))
                .andExpect(jsonPath("$.content", is("content update")));
    }
    @Test
    public void testCreateTask() throws Exception {
        //Given
        Task task = new Task(1L,"title", "content");
        TaskDto taskDto = new TaskDto(1L,"title", "content");

        when(dbService.saveTask(taskMapper.mapToTask(ArgumentMatchers.any(TaskDto.class)))).thenReturn(task);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskDto);

        // When & Then
        mockMvc.perform(post("/v1/tasks").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200));
    }
}
