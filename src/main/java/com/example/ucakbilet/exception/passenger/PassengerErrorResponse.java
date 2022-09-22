package com.example.ucakbilet.exception.passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
