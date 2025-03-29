package com.envios_internacionales.envios_internacionales.repository.Interface;

import java.util.List;

import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;
import com.envios_internacionales.envios_internacionales.model.Tracking;

public interface IShipmentRepository {
    /**
     * Metodo para consultar la informacion de seguimiento de un envio y todos sus
     * detalles mediante el codigo de seguimiento
     * 
     * @param trackingCode codigo de seguimiento
     * @return devuelve la informacion de seguimiento
     * @throws Exception arroja error si no encuentra informacion asociada al codigo
     *                   ingresado
     */
    Tracking getTrackinByCode(String trackingCode) throws Exception;

    /**
     * Metodo para consultar la informacion de seguimiento de un envio y todos sus
     * detalles mediante el id del envio
     * 
     * @param shipmentId id del envio
     * @return devuelve la informacion de seguimiento
     * @throws Exception arroja error si no encuentra informacion asociada al id
     *                   ingresado
     */
    Tracking getTrackinByShipmentId(int shipmentId) throws Exception;

    /**
     * Metodo para consultar contenido del envio mediante el id
     * 
     * @param shipmentId id del envio
     * @return devuelve lista del contenido del envio
     */
    List<ShipmentContent> getShipmentContentById(int shipmentId);

    /**
     * Metodo para consultar envio por id
     * 
     * @param shipmentId id del envio
     * @return devuelve informacion del envio
     */
    Shipment getShipmentById(int shipmentId);
}
