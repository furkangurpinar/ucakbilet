package com.example.ucakbilet.exception.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
