package com.envios_internacionales.envios_internacionales.mapper;

import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.model.Tracking;

public class TrackingMapper {
    public static TrackingDto toDto(Tracking entity){
        return  TrackingDto.builder()
        .status(entity.getStatus())
        .currentLocation(entity.getCurrentLocation())
        .trackingCode(entity.getTrackingCode())
        .shipmentInfo(ShipmentMapper.toDto(entity.getShipmentInfo()))
        .build();
    }
}
