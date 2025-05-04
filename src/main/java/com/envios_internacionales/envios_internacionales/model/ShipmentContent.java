package com.envios_internacionales.envios_internacionales.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ShipmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long shipmentContentId;
    @DecimalMin(value="0.0", inclusive = true, message = "El valor debe ser mayor o igual a 0")
    @Digits(integer = 6, fraction = 2, message = "El valor debe tener una parte entera de hasta 6 dígitos y una parte decimal de 2")
    @Column(precision = 8, scale = 2)
    private BigDecimal weight;

    @Min(value = 1, message = "El valor debe ser mayor a 0" )
    @Column(nullable = false)
    private int itemsAmount;
    
    @ManyToOne
    @JoinColumn(name ="shipmentId")
    private Shipment shipment;
}
