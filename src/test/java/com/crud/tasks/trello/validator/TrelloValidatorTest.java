package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTest {

    @Autowired
    TrelloValidator trelloValidator;
    @Ignore
    @Test
    public void testValidateTrelloBoards() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("id_1", "board_one", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("id_1", "test", new ArrayList<>());
        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        //When
        List<TrelloBoard> resultList = trelloValidator.validateTrelloBoards(trelloBoardList);
        //Then
        assertEquals("test", resultList.get(0).getName());
    }

    @Test
    public void testValidateCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Trello card","Trello card for tests", "up", "1" );
        //When
        trelloValidator.validateCard(trelloCard);
        //Then
        //See the console
    }
}
