package com.keola.agq.controller.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * andre on 29/11/2023
 */
@Getter
@Setter
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

}
