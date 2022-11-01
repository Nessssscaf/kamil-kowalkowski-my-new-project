package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //Given
        List<TrelloListDto> list1 = List.of(
                new TrelloListDto("1","Test list 1", true),
                new TrelloListDto("2","Test list 2", false)
        );
        List<TrelloListDto> list2 = List.of(
                new TrelloListDto("3","Test list 3", true),
                new TrelloListDto("4","Test list 4", false)
        );
        List<TrelloBoardDto> trelloBoardsDto = List.of(
                new TrelloBoardDto("1","First Board",list1),
                new TrelloBoardDto("2","Second board",list2)
        );

        //When
        List<TrelloBoard> mappedBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        assertEquals(2, mappedBoards.size());
        assertEquals("First Board", mappedBoards.get(0).getName());
        assertTrue(mappedBoards.get(1).getLists().get(0).isClosed());
    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> list1 = List.of(
                new TrelloList("1","Test list 1", true),
                new TrelloList("2","Test list 2", false)
        );
        List<TrelloList> list2 = List.of(
                new TrelloList("3","Test list 3", true),
                new TrelloList("4","Test list 4", false)
        );
        List<TrelloBoard> trelloBoards = List.of(
                new TrelloBoard("1","First Board",list1),
                new TrelloBoard("2","Second board",list2)
        );

        //When
        List<TrelloBoardDto> mappedBoardsDto = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(2, mappedBoardsDto.size());
        assertEquals("First Board", mappedBoardsDto.get(0).getName());
        assertTrue(mappedBoardsDto.get(1).getLists().get(0).isClosed());
    }

    @Test
    void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = List.of(
                new TrelloListDto("1","Test list 1", true),
                new TrelloListDto("2","Test list 2", false)
        );

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListDto);

        //Then
        assertEquals("Test list 1", mappedList.get(0).getName());
        assertFalse(mappedList.get(1).isClosed());
    }

    @Test
    void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloList = List.of(
                new TrelloList("1","Test list 1", true),
                new TrelloList("2","Test list 2", false)
        );

        //When
        List<TrelloListDto> mappedListDto = trelloMapper.mapToListDto(trelloList);

        //Then
        assertEquals("Test list 1", mappedListDto.get(0).getName());
        assertFalse(mappedListDto.get(1).isClosed());
    }

    @Test
    void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test", "Test", "1", "666");

        //When
        TrelloCardDto mappedDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Test",mappedDto.getName());
        assertEquals("1", mappedDto.getPos());
    }

    @Test
    void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test", "Test", "1", "666");

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Test",mappedCard.getName());
        assertEquals("1", mappedCard.getPos());
    }
}
