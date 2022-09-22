package com.example.ucakbilet.exception.voyage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoyageErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
