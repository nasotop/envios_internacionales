package com.envios_internacionales.envios_internacionales.model;

import com.envios_internacionales.envios_internacionales.enums.TrackingStatusType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tracking {

    public TrackingStatusType status;

    public Shipment shipmentInfo;

    public String currentLocation;

    public String trackingCode;

    public int shipmentId;
}
