package com.envios_internacionales.envios_internacionales.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrackingStatusType {
    PREPARING(1),
    INTRANSIT(2),
    DELIVERED(3);

    private final int value;

    public static TrackingStatusType fromValue(int value) {
        for (TrackingStatusType role : TrackingStatusType.values()) {
            if (role.value == value) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor no válido para UserRole: " + value);
    }
}
