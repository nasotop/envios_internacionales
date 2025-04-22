package com.envios_internacionales.envios_internacionales.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentContentDto {
    public BigDecimal weight;

    public int itemsAmount;

    public Long shipmentContentId;
}
