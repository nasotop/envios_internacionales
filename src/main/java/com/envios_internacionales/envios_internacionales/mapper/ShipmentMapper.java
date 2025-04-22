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
                .content(toDtos(entity.getContent()))
                .tracking(TrackingMapper.toDto(entity.getTracking()))
                .build();
    }

    public static List<ShipmentInfoDto> toShipmentDtos(List<Shipment> entities) {
        return entities.stream().map(ShipmentMapper::toDto).collect(Collectors.toList());
    }

    public static Shipment toEntity(ShipmentInfoDto dto) {
        return Shipment.builder()
                .shippingAddress(dto.getShippingAddress())
                .build();
    }

    public static ShipmentContentDto toDto(ShipmentContent entity) {
        return ShipmentContentDto.builder()
                .itemsAmount(entity.getItemsAmount())
                .weight(entity.getWeight())
                .shipmentContentId(entity.getShipmentContentId())
                .build();
    }

    public static List<ShipmentContentDto> toDtos(List<ShipmentContent> entities) {
        return entities.stream().map(ShipmentMapper::toDto).collect(Collectors.toList());
    }

    public static ShipmentContent toEntity(ShipmentContentDto dto) {
        return ShipmentContent.builder()
                .itemsAmount(dto.itemsAmount)
                .weight(dto.weight)
                .build();
    }

    public static List<ShipmentContent> toEntities(List<ShipmentContentDto> entities) {
        return entities.stream().map(ShipmentMapper::toEntity).collect(Collectors.toList());
    }

}
