package com.envios_internacionales.envios_internacionales.mapper;

import java.util.List;

import com.envios_internacionales.envios_internacionales.dto.GenericResponseDto;
import com.envios_internacionales.envios_internacionales.dto.GenericSingleResponseDto;

public class GenericResponseMapper {
    /**
     * Metodo para mapear una lista generica al DTO generico de respuestas
     * 
     * @param <T>      lista generica
     * @param elements contenido de la respuesta
     * @return devuelve DTO de respuesta generica
     */
    public static <T> GenericResponseDto<T> ToGenericResponseDto(List<T> elements) {
        GenericResponseDto<T> response = new GenericResponseDto<T>();
        response.setContent(elements);
        return response;
    }

    /**
     * Metodo para mapear un elemento generico al DTO generico de respuestas
     * 
     * @param <T>
     * @param element contenido de la respueta
     * @return devuelve DTO de respuesta generica
     */
    public static <T> GenericSingleResponseDto<T> ToGenericSingleResponseDto(T element) {
        GenericSingleResponseDto<T> response = new GenericSingleResponseDto<T>();
        response.setContent(element);
        return response;
    }
}
