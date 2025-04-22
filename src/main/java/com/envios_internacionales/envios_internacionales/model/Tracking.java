package com.envios_internacionales.envios_internacionales.model;

import com.envios_internacionales.envios_internacionales.enums.TrackingStatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Tracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long trackingId;

    private String currentLocation;

    private String trackingCode;

    @Enumerated(EnumType.STRING)
    private TrackingStatusType status;
    @OneToOne
    @JoinColumn(name = "shipmentId")
    private Shipment shipment;
}
