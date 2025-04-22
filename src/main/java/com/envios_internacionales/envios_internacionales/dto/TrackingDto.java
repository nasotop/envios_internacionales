package com.envios_internacionales.envios_internacionales.dto;

import com.envios_internacionales.envios_internacionales.enums.TrackingStatusType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrackingDto {
    private TrackingStatusType status;


    private String currentLocation;

    private String trackingCode;
}
