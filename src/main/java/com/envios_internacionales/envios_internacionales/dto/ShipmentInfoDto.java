package com.envios_internacionales.envios_internacionales.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipmentInfoDto {
    
    public String shippingAddress;


    public List<ShipmentContentDto> content;
}
