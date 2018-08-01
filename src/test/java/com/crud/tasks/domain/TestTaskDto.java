package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTaskDto {
    @Test
    public void testCreateTestTaskDto() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title", "Content");
        //When
        //Then
        assertEquals((Long) 1L, taskDto.getId());
        assertEquals("Title", taskDto.getTitle());
        assertEquals("Content", taskDto.getContent());
    }
}
