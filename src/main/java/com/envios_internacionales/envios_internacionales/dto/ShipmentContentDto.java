package com.envios_internacionales.envios_internacionales.dto;

import java.math.BigDecimal;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentContentDto extends RepresentationModel<ShipmentContentDto> {
    private Long id;
    private BigDecimal weight;
    private int itemsAmount;
    private Long shipmentContentId;
}
