package com.example.ucakbilet.exception.company;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
