package com.crud.tasks.trello.controller;

import com.crud.tasks.controller.TrelloController;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
class TrelloControllerTest {

    @Autowired
    TrelloController controller;

    @Test
    void getTrelloBoards() {
        //when
        ResponseEntity<List<TrelloBoardDto>> response = controller.getTrelloBoards();
        int status = response.getStatusCodeValue();

        response.getBody().stream().map(TrelloBoardDto::getLists)
                .flatMap(Collection::stream)
                .forEach(trelloListDto -> System.out.println(trelloListDto.getId()));

        //then
        assertEquals(200, status);

    }
}