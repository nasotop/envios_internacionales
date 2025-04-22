package com.envios_internacionales.envios_internacionales.service.Interface;

import java.util.List;

import com.envios_internacionales.envios_internacionales.dto.TrackingDto;

public interface ITrackingSvc {
    /**
     * Metodo para consultar seguimiento de envio mediante codigo
     * 
     * @param trackingCode codigo de seguimiento
     * @return devuelve informacion de seguimiento del envio
     * @throws Exception arroja error en caso de que no exista un envio asociado al
     *                   codigo de seguimiento
     */
    TrackingDto getTrackinByCode(String trackingCode) throws Exception;

    /**
     * Metodo para consultar seguimiento de envio mediante id del envio
     * 
     * @param id id del envio
     * @return devuelve informacion de seguimiento del envio
     * @throws Exception arroja error en caso de que no exista un envio asociado al
     *                   id introducido
     */
    TrackingDto getTrackinById(Long id) throws Exception;

    /**
     * Metodo para crear seguimiento
     * 
     * @param dto        objeto para crea
     * @param shipmentId id de envio para asociar
     * @return devuelve seguimiento creado
     * @throws Exception
     */
    TrackingDto createTracking(TrackingDto dto, Long shipmentId) throws Exception;

    /**
     * Metodo para actualizar un seguimiento
     * 
     * @param dto        objeto para actualizar
     * @param trackingId id del seguimiento
     * @return devuelve objeto actualizado
     * @throws Exception
     */
    TrackingDto updateTracking(TrackingDto dto, Long trackingId) throws Exception;

    /**
     * Metodo para eliminar seguimiento
     * 
     * @param trackingId id de seguimiento
     * @throws Exception
     */
    void deleteTracking(Long trackingId) throws Exception;

    /**
     * Metodo para consultar todos los seguimientos
     * 
     * @return devuelve lista de todos los seguimientos
     * @throws Exception
     */
    List<TrackingDto> getAllTracking() throws Exception;
}
