package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
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
public class TrelloMapperTestSuite {
    @Autowired
    TrelloMapper trelloMapper;
    @Test
    public void testMapToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("id_1", "board_one", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("id_2", "board_two", new ArrayList<>());
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("id_3", "board_three", new ArrayList<>());

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();

        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);
        trelloBoardDtoList.add(trelloBoardDto3);
        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals("board_one", trelloBoardList.get(0).getName());
        assertEquals("board_two", trelloBoardList.get(1).getName());
        assertEquals("board_three", trelloBoardList.get(2).getName());
    }
    @Test
    public void testMapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("id_one", "board_1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("id_two", "board_2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("id_three", "board_3", new ArrayList<>());

        List<TrelloBoard> trelloBoardList = new ArrayList<>();

        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        trelloBoardList.add(trelloBoard3);
        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);
        //Then
        assertEquals("board_1", trelloBoardDtoList.get(0).getName());
        assertEquals("board_2", trelloBoardDtoList.get(1).getName());
        assertEquals("board_3", trelloBoardDtoList.get(2).getName());
    }
    @Test
    public void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name_1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name_2", false);

        List<TrelloListDto> trelloListDtoList = new ArrayList<>();

        trelloListDtoList.add(trelloListDto1);
        trelloListDtoList.add(trelloListDto2);
        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDtoList);
        //Then
        assertEquals("name_1", trelloListList.get(0).getName());
        assertEquals("name_2", trelloListList.get(1).getName());
        assertEquals(true, trelloListList.get(0).isClosed());
        assertEquals(false, trelloListList.get(1).isClosed());
    }
    @Test
    public void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "nameList_1", true);
        TrelloList trelloList2 = new TrelloList("2", "nameList_2", false);

        List<TrelloList> trelloListList = new ArrayList<>();

        trelloListList.add(trelloList1);
        trelloListList.add(trelloList2);
        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);
        //Then
        assertEquals("nameList_1", trelloListList.get(0).getName());
        assertEquals("nameList_2", trelloListList.get(1).getName());
        assertEquals(true, trelloListList.get(0).isClosed());
        assertEquals(false, trelloListList.get(1).isClosed());
    }
    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("CardDto", "CardDto for tests", "bottom", "one");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("CardDto", trelloCard.getName());
        assertEquals("CardDto for tests", trelloCard.getDescripton());
        assertEquals("bottom", trelloCard.getPos());
        assertEquals("one", trelloCard.getListId());
    }
    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Trello card","Trello card for tests", "up", "1" );
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("Trello card", trelloCardDto.getName());
        assertEquals("Trello card for tests", trelloCardDto.getDescription());
        assertEquals("up", trelloCardDto.getPos());
        assertEquals("1", trelloCardDto.getListId());
    }
}
