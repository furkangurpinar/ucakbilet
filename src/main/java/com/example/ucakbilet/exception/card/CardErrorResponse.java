package com.example.ucakbilet.exception.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
