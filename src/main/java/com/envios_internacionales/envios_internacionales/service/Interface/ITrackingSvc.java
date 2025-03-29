package com.envios_internacionales.envios_internacionales.service.Interface;

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
    TrackingDto getTrackinById(int id) throws Exception;
}
