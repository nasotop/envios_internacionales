package com.envios_internacionales.envios_internacionales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envios_internacionales.envios_internacionales.dto.GenericResponseDto;
import com.envios_internacionales.envios_internacionales.dto.GenericSingleResponseDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.mapper.GenericResponseMapper;
import com.envios_internacionales.envios_internacionales.service.Interface.IShipmentSvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/shipment")
public class ShipmentController {
    @Autowired
    private IShipmentSvc _shipmentSvc;

    @GetMapping("/get-by-id/{shipment-id}")
    public GenericSingleResponseDto<ShipmentInfoDto> getShipmentById(@PathVariable("shipment-id") Long shipmentId) {
        GenericSingleResponseDto<ShipmentInfoDto> response = new GenericSingleResponseDto<>();

        try {
            response = GenericResponseMapper.ToGenericSingleResponseDto(_shipmentSvc.getShipmentInfoById(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @GetMapping("/get-content/{shipment-id}")
    public GenericResponseDto<ShipmentContentDto> getShipmentContetByShipmentId(
            @PathVariable("shipment-id") Long shipmentId) {
        GenericResponseDto<ShipmentContentDto> response = new GenericResponseDto<>();

        try {
            response = GenericResponseMapper
                    .ToGenericResponseDto(_shipmentSvc.getShipmentContentByShipmentId(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @GetMapping("/get-content-by-id/{shipment-content-id}")
    public GenericSingleResponseDto<ShipmentContentDto> getShipmentContetById(
            @PathVariable("shipment-content-id") Long shipmentContentId) {
        GenericSingleResponseDto<ShipmentContentDto> response = new GenericSingleResponseDto<>();

        try {
            response = GenericResponseMapper
                    .ToGenericSingleResponseDto(_shipmentSvc.getShipmentContentById(shipmentContentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @GetMapping
    public GenericResponseDto<ShipmentInfoDto> getAllShipments() {
        GenericResponseDto<ShipmentInfoDto> result = new GenericResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericResponseDto(_shipmentSvc.getAllShipments());
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PutMapping("/delete-shipment/{shipment-id}")
    public GenericSingleResponseDto<String> deleteShipment(@PathVariable("shipment-id") Long id) {
        GenericSingleResponseDto<String> response = new GenericSingleResponseDto<>();
        try {
            _shipmentSvc.deleteShipment(id);
            response.setContent("Envío eliminado de forma correcta");

        } catch (Exception ex) {
            response.loadError(ex.getMessage());
        }
        return response;
    }

    @PostMapping("/create-shipment")
    public GenericSingleResponseDto<ShipmentInfoDto> createShipment(@RequestBody ShipmentInfoDto dto) {
        GenericSingleResponseDto<ShipmentInfoDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_shipmentSvc.createShipment(dto));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/update-shipment/{shipment-id}")
    public GenericSingleResponseDto<ShipmentInfoDto> updateShipment(@RequestBody ShipmentInfoDto dto,
            @PathVariable("shipment-id") Long shipmentId) {
        GenericSingleResponseDto<ShipmentInfoDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_shipmentSvc.updateShipment(dto, shipmentId));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/create-shipment-content/{shipment-id}")
    public GenericSingleResponseDto<ShipmentContentDto> createShipmentContent(@RequestBody ShipmentContentDto dto,
            @PathVariable("shipment-id") Long shipmentId) {
        GenericSingleResponseDto<ShipmentContentDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper
                    .ToGenericSingleResponseDto(_shipmentSvc.createShipmentContent(dto, shipmentId));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/create-shipment-contents/{shipment-id}")
    public GenericResponseDto<ShipmentContentDto> createShipmentContents(@RequestBody List<ShipmentContentDto> dto,
            @PathVariable("shipment-id") Long shipmentId) {
        GenericResponseDto<ShipmentContentDto> result = new GenericResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericResponseDto(_shipmentSvc.createShipmentContent(dto, shipmentId));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/update-shipment-content/{shipment-content-id}")
    public GenericSingleResponseDto<ShipmentContentDto> updateShipmentContents(@RequestBody ShipmentContentDto dto,
            @PathVariable("shipment-content-id") Long shipmentContentId) {
        GenericSingleResponseDto<ShipmentContentDto> result = new GenericSingleResponseDto<>();
        try {
            result = GenericResponseMapper.ToGenericSingleResponseDto(_shipmentSvc.updateShipmentContent(dto));
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

    @PutMapping("/delete-content/{shipment-content-id}")
    public GenericSingleResponseDto<String> deleteShipmentContent(
            @PathVariable("shipment-content-id") Long shipmentContentId) {
        GenericSingleResponseDto<String> result = new GenericSingleResponseDto<>();

        try {
            _shipmentSvc.deleteShipmentContent(shipmentContentId);
            result.setContent("Se eliminó el contenido de forma correcta");
        } catch (Exception ex) {
            result.loadError(ex.getMessage());
        }
        return result;
    }

}
