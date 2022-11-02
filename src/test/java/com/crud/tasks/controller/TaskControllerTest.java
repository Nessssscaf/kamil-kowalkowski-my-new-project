package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskControllerTest {

    @Autowired
    TaskController taskController;


    @Test
    void getTasks() {
        //When & Then
        Assertions.assertDoesNotThrow(()->taskController.getTasks());
    }

    @Test
    void getTask(){
        //Given
        boolean throwException = false;

        //When
        try {
            ResponseEntity<TaskDto> response = taskController.getTask(-1L);
        }catch (TaskNotFoundException e){
            throwException = true;
        }

        //Then
        assertTrue(throwException);
    }
}