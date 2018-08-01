package com.crud.tasks.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask {
    @Test
    public void testCreateTask() {
        //Given
        Task task = new Task(100L, "Test title", "Top Secret content");
        //When
        //Then
        assertEquals((Long)100L, task.getId());
        assertEquals("Test title", task.getTitle());
        assertEquals("Top Secret content", task.getContent());
    }
}
