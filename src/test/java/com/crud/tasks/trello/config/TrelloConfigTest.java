package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void testGettingTrelloConfigValues() {
        //Given
        String trelloApiEndpoint = "https://api.trello.com/1";
        String trelloUsername = "golehm";
        String trelloAppKey = "ed79fe8a3b56372cad14af2f5a62b63f";
        String trelloToken = "12f190e4dbc1670b045b5aa1343198c06c7ecf2da2310819ec58445ca15982a5";
        //When
        String getApiEnpoint = trelloConfig.getTrelloApiEndpoint();
        String getUsername = trelloConfig.getTrelloUsername();
        String getAppKey = trelloConfig.getTrelloAppKey();
        String getToken = trelloConfig.getTrelloToken();
        //Then
        assertEquals(trelloApiEndpoint, getApiEnpoint);
        assertEquals(trelloUsername, getUsername);
        assertEquals(trelloAppKey, getAppKey);
        assertEquals(trelloToken, getToken);
    }
}
