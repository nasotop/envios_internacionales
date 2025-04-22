package com.envios_internacionales.envios_internacionales.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.model.Tracking;

public class TrackingMapper {
    public static TrackingDto toDto(Tracking entity){
        return  TrackingDto.builder()
        .status(entity.getStatus())
        .currentLocation(entity.getCurrentLocation())
        .trackingCode(entity.getTrackingCode())
        .build();
    }

    public static List<TrackingDto> toDtos(List<Tracking> entities){
        return entities.stream().map(TrackingMapper::toDto).collect(Collectors.toList());
    }
    public static Tracking toEntity(TrackingDto dto){
        return Tracking.builder()
        .currentLocation(dto.getCurrentLocation())
        .trackingCode(dto.getTrackingCode())
        .status(dto.getStatus())
        .build();
    }
}
