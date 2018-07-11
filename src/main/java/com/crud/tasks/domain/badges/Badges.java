package com.crud.tasks.domain.badges;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Badges {

    private AttachmentsByType attachmentsByType;
    private String votes;

    public Badges() {
    }

    @Override
    public String toString()
    {
        return "ClassPojo [attachmentsByType = "+attachmentsByType+", votes = "+votes+"]";
    }
}
