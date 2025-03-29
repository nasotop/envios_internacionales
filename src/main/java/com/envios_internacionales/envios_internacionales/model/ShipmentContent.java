package com.envios_internacionales.envios_internacionales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentContent {
    public double weight;

    public int itemsAmount;
    
    public int shipmentId;
}
