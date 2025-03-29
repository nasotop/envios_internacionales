package com.envios_internacionales.envios_internacionales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envios_internacionales.envios_internacionales.dto.GenericResponseDto;
import com.envios_internacionales.envios_internacionales.dto.GenericSingleResponseDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.mapper.GenericResponseMapper;
import com.envios_internacionales.envios_internacionales.service.Implementation.ShipmentSvcImpl;
import com.envios_internacionales.envios_internacionales.service.Interface.IShipmentSvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/shipment")
public class ShipmentController {

    private final IShipmentSvc _shipmentSvc;

    public ShipmentController(ShipmentSvcImpl shipmentSvc){
        _shipmentSvc = shipmentSvc;
    }
    /**
     * Metodo para consultar envio por id
     * @param shipmentId id del envio
     * @return devuelve DTO con informacion del envio
     */
    @GetMapping("/get-by-id/{shipment-id}")
    public GenericSingleResponseDto<ShipmentInfoDto> getShipmentById(@PathVariable("shipment-id") int shipmentId) {
        GenericSingleResponseDto<ShipmentInfoDto> response = new GenericSingleResponseDto<>();

        try {
            response = GenericResponseMapper.ToGenericSingleResponseDto(_shipmentSvc.getShipmentInfoById(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }
    /**
     * Metodo para consultar el contenido del envio consultando por id
     * @param shipmentId id del envio
     * @return devuelve DTO con contenido del envio
     */
    @GetMapping("/get-content/{shipment-id}")
    public GenericResponseDto<ShipmentContentDto> getShipmentContetById(@PathVariable("shipment-id") int shipmentId) {
        GenericResponseDto<ShipmentContentDto> response = new GenericResponseDto<>();

        try {
            response = GenericResponseMapper.ToGenericResponseDto(_shipmentSvc.getShipmentContentByShipmentId(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }
}
