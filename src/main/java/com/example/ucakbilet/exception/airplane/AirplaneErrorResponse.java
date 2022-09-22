package com.example.ucakbilet.exception.airplane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirplaneErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
