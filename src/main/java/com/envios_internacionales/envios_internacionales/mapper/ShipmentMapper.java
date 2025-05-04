package com.envios_internacionales.envios_internacionales.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.helper.LinkHelper;
import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;

public class ShipmentMapper {

    public static ShipmentInfoDto toDto(Shipment entity) {
        TrackingDto trackingDto = entity.getTracking() != null
                ? TrackingMapper.toDto(entity.getTracking())
                : null;
        List<ShipmentContentDto> contentDto = entity.getContent() != null
                ? toDtos(entity.getContent())
                : null;
        var dto = ShipmentInfoDto.builder()
                .shippingAddress(entity.getShippingAddress())
                .id(entity.getShipmentId())
                .content(contentDto)
                .tracking(trackingDto)
                .build();

        return addLinks(dto);
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
        var dto = ShipmentContentDto.builder()
                .itemsAmount(entity.getItemsAmount())
                .weight(entity.getWeight())
                .shipmentContentId(entity.getShipmentContentId())
                .build();
        return addLinks(dto);
    }

    public static List<ShipmentContentDto> toDtos(List<ShipmentContent> entities) {
        return entities.stream().map(ShipmentMapper::toDto).collect(Collectors.toList());
    }

    public static ShipmentContent toEntity(ShipmentContentDto dto) {
        return ShipmentContent.builder()
                .itemsAmount(dto.getItemsAmount())
                .weight(dto.getWeight())
                .build();
    }

    public static List<ShipmentContent> toEntities(List<ShipmentContentDto> entities) {
        return entities.stream().map(ShipmentMapper::toEntity).collect(Collectors.toList());
    }

    private static ShipmentInfoDto addLinks(ShipmentInfoDto dto) {
        return dto.add(LinkHelper.buildShipmentLinks(dto.getId()));

    }

    private static ShipmentContentDto addLinks(ShipmentContentDto dto) {
        return dto.add(LinkHelper.buildShipmentContentLinks(dto.getShipmentContentId()));

    }
}
