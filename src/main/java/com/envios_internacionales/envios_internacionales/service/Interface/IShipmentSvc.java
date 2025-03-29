package com.envios_internacionales.envios_internacionales.service.Interface;

import java.util.List;

import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;

public interface IShipmentSvc {
    /**
     * Metodo para consultar envio por Id
     * 
     * @param id id del envio
     * @return devuelve DTO con informacion del envio
     */
    ShipmentInfoDto getShipmentInfoById(int id);

    /**
     * Metodo para consultar información del contenido del envio
     * 
     * @param shipmentId id del envio
     * @return lista del contenido del envio
     */
    List<ShipmentContentDto> getShipmentContentByShipmentId(int shipmentId);
}
