package com.envios_internacionales.envios_internacionales.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.envios_internacionales.envios_internacionales.dto.GenericSingleResponseDto;
import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.mapper.GenericResponseMapper;
import com.envios_internacionales.envios_internacionales.service.Implementation.ShipmentSvcImpl;
import com.envios_internacionales.envios_internacionales.service.Implementation.TrackingSvcImpl;
import com.envios_internacionales.envios_internacionales.service.Interface.ITrackingSvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/tracking")
public class TrackingController {

    private final ITrackingSvc _trackingSvc;

    public TrackingController(TrackingSvcImpl trackingSvcImpl, ShipmentSvcImpl shipmentSvcImpl) {
        _trackingSvc = trackingSvcImpl;
    }

    /**
     * Metodo para consultar información de un envio en base al codigo de
     * seguimiento
     * 
     * @param trackingCode codigo de seguimiento
     * @return devuelve DTO generico de respuesta con informacion del envio
     */
    @GetMapping("/get-by-code/{tracking-code}")
    public GenericSingleResponseDto<TrackingDto> getTrackingInformation(
            @PathVariable("tracking-code") String trackingCode) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {
            response =  GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.getTrackinByCode(trackingCode));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }
   /**
     * Metodo para consultar información de un envio en base al id del
     * envio
     * 
     * @param trackingCode codigo de seguimiento
     * @return devuelve DTO generico de respuesta con informacion del envio
     */
    @GetMapping("/get-by-id/{shipment-id}")
    public GenericSingleResponseDto<TrackingDto> getTrackingInformationById(
            @PathVariable("shipment-id") int shipmentId) {
        GenericSingleResponseDto<TrackingDto> response = new GenericSingleResponseDto<>();

        try {
            response =  GenericResponseMapper.ToGenericSingleResponseDto(_trackingSvc.getTrackinById(shipmentId));
        } catch (Exception ex) {

            response.loadError(ex.getMessage());

        }

        return response;
    }
    

}
