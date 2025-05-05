package com.envios_internacionales.envios_internacionales.dto;

import org.springframework.hateoas.RepresentationModel;

import com.envios_internacionales.envios_internacionales.enums.TrackingStatusType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackingDto extends RepresentationModel<TrackingDto>  {
    private Long id;
    private Long shipmentId;
    private TrackingStatusType status;


    private String currentLocation;

    private String trackingCode;
}
