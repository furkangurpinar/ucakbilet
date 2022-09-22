package com.example.ucakbilet.exception.town;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TownErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
