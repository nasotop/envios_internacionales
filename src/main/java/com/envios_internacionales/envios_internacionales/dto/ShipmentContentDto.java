package com.envios_internacionales.envios_internacionales.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentContentDto {
    public double weight;

    public int itemsAmount;
}
