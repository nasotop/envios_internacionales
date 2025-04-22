package com.envios_internacionales.envios_internacionales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.envios_internacionales.envios_internacionales.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

}
