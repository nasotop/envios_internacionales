package com.envios_internacionales.envios_internacionales.dto;

import java.util.List;
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
public class ShipmentInfoDto extends RepresentationModel<ShipmentInfoDto> {

    private Long id;
    private String shippingAddress;
    private List<ShipmentContentDto> content;
    private TrackingDto tracking;
}
