package com.crud.tasks.domain.badges;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Trello
{
    private String card;
    private String board;

    public Trello() {
    }

    @Override
    public String toString()
    {
        return "ClassPojo [card = "+card+", board = "+board+"]";
    }

}

