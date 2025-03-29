package com.envios_internacionales.envios_internacionales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GenericSingleResponseDto<T> {
    private boolean status;
    private String errorMessage;
    private T content;
    public GenericSingleResponseDto(){
        status = true;
    }

    public void loadError(String errorMessage){
        status = false;
        this.errorMessage =  errorMessage;
    }
}
