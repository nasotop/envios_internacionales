package com.envios_internacionales.envios_internacionales.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {
    public int shipmentId;

    public String shippingAddress;

    public List<ShipmentContent> content;

}
