package com.crud.tasks.domain;

import com.crud.tasks.domain.badges.Badges;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("badges")
    private Badges badges;
        //int votes

        //AttachmentByType atachments
            //Trello trello
                //int board
                //int card
    public CreatedTrelloCard() {
    }
}
