package com.crud.tasks.domain.badges;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AttachmentsByType {
    private Trello trello;

    public AttachmentsByType() {
    }

    @Override
    public String toString()
    {
        return "ClassPojo [trello = "+trello+"]";
    }
}
