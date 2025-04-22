package com.envios_internacionales.envios_internacionales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envios_internacionales.envios_internacionales.dto.GenericResponseDto;
import com.envios_internacionales.envios_internacionales.dto.GenericSingleResponseDto;
import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.mapper.GenericResponseMapper;
import com.envios_internacionales.envios_internacionales.service.Implementation.ShipmentSvcImpl;
import com.envios_internacionales.envios_internacionales.service.Implementation.TrackingSvcImpl;
import com.envios_internacionales.envios_internacionales.service.Interface.ITrackingSvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/tracking")
public class TrackingController {
    @Autowired
    private ITrackingSvc _trackingSvc;

    @GetMapping("/get-by-code/{tracking-code}")
    public GenericSingleResponseDto<TrackingDto> getTrackingInformation(
            @PathVariable("tracking-code") String trackingCode) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {
            response = GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.getTrackinByCode(trackingCode));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @GetMapping("/get-by-id/{shipment-id}")
    public GenericSingleResponseDto<TrackingDto> getTrackingInformationById(
            @PathVariable("shipment-id") Long shipmentId) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {
            response = GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.getTrackinById(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @PostMapping("/create-tracking/{shipment-id}")
    public GenericSingleResponseDto<TrackingDto> createTracking(@RequestBody TrackingDto dto,
            @PathVariable("shipment-id") Long shipmentId) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {

            response = GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.createTracking(dto, shipmentId));

        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @PostMapping("/update-tracking/{tracking-id}")
    public GenericSingleResponseDto<TrackingDto> updateTracking(@RequestBody TrackingDto dto,
            @PathVariable("tracking-id") Long trackingId) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {

            response = GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.updateTracking(dto, trackingId));

        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

    @PutMapping("delete/{tracking-id}")
    public GenericSingleResponseDto<String> deleteTracking(@PathVariable("tracking-id") Long trackingId) {
        GenericSingleResponseDto<String> result = new GenericSingleResponseDto<>();
        try {
            _trackingSvc.deleteTracking(trackingId);
            result.setContent("Seguimiento eliminado de forma correcta");
        } catch (Exception e) {
            result.loadError(e.getMessage());

        }
        return result;
    }

    @GetMapping
    public GenericResponseDto<TrackingDto> getAllTrackings() {
        GenericResponseDto<TrackingDto> response = new GenericResponseDto<>();

        try {

            response = GenericResponseMapper.ToGenericResponseDto(_trackingSvc.getAllTracking());

        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }

}
