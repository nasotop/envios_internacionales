package com.envios_internacionales.envios_internacionales.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;

public class ShipmentMapper {

    public static ShipmentInfoDto toDto(Shipment entity) {
        return ShipmentInfoDto.builder()
                .shippingAddress(entity.getShippingAddress())
                .content(toShipmentContentDtos(entity.content))
                .build();
    }

    public static List<ShipmentInfoDto> toShipmentDtos(List<Shipment> entities) {
        return entities.stream().map(ShipmentMapper::toDto).collect(Collectors.toList());
    }

    public static ShipmentContentDto toDto(ShipmentContent entity) {
        return ShipmentContentDto.builder()
                .itemsAmount(entity.getItemsAmount())
                .weight(entity.getWeight())
                .build();
    }

    public static List<ShipmentContentDto> toShipmentContentDtos(List<ShipmentContent> entities) {
        return entities.stream().map(ShipmentMapper::toDto).collect(Collectors.toList());
    }

}
