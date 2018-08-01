package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(0L,"Title", "Content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals((Long)0L, task.getId());
        assertEquals("Title", task.getTitle());
        assertEquals("Content", task.getContent());
    }
    @Test
    public void testMapToTaskDto() {
        //Given
        Task task = new Task(10L,"title", "content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals((Long)10L, taskDto.getId());
        assertEquals("title", taskDto.getTitle());
        assertEquals("content", taskDto.getContent());
    }
    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(1L,"title one", "content one");
        Task task2 = new Task(2L,"title two", "content two");
        taskList.add(task1);
        taskList.add(task2);
        List<TaskDto> taskDtoList = new ArrayList<>();
        //When
        taskDtoList = taskMapper.mapToTaskDtoList(taskList);
        //Then
        assertEquals((Long)1L, taskDtoList.get(0).getId());
        assertEquals("title one", taskDtoList.get(0).getTitle());
        assertEquals("content one", taskDtoList.get(0).getContent());
        assertEquals((Long)2L, taskDtoList.get(1).getId());
        assertEquals("title two", taskDtoList.get(1).getTitle());
        assertEquals("content two", taskDtoList.get(1).getContent());
    }
}
