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
    ShipmentInfoDto getShipmentInfoById(Long id) throws Exception;

    /**
     * Metodo para consultar información del contenido del envio
     * 
     * @param shipmentId id del envio
     * @return lista del contenido del envio
     */
    List<ShipmentContentDto> getShipmentContentByShipmentId(Long shipmentId) throws Exception;

    /**
     * Metodo para consultar contenido del envio por id
     * 
     * @param shipmentContentId id del contenido
     * @return contenido del envio
     * @throws Exception
     */
    ShipmentContentDto getShipmentContentById(Long shipmentContentId) throws Exception;

    /**
     * Metodo para eliminar envío
     * 
     * @param shipmentId id del envio
     * @throws Exception
     */
    void deleteShipment(Long shipmentId) throws Exception;

    /**
     * Metodo para crear envío
     * 
     * @param dto objeto por crear
     * @return objeto creado
     * @throws Exception
     */
    ShipmentInfoDto createShipment(ShipmentInfoDto dto) throws Exception;

    /**
     * Metodo para actualizar envío
     * 
     * @param dto        objeto para actualizar
     * @param shipmentId id de envío
     * @return objeto actualizado
     * @throws Exception
     */
    ShipmentInfoDto updateShipment(ShipmentInfoDto dto, Long shipmentId) throws Exception;

    /**
     * Metodo para crear contenido de envío
     * 
     * @param dto        contenido del envío
     * @param shipmentId id del envío
     * @return devuelve contenido creado
     * @throws Exception
     */
    ShipmentContentDto createShipmentContent(ShipmentContentDto dto, Long shipmentId) throws Exception;

    /**
     * Metodo para varios contenidos de envìo
     * 
     * @param dto        contenidos de envío
     * @param shipmentId id del envío
     * @return devuelve contenido creado
     * @throws Exception
     */
    List<ShipmentContentDto> createShipmentContent(List<ShipmentContentDto> dto, Long shipmentId)
            throws Exception;

    /**
     * Metodo para actualizar contenido del envío
     * 
     * @param dto contenido por editar
     * @return contenido editado
     * @throws Exception
     */
    ShipmentContentDto updateShipmentContent(ShipmentContentDto dto) throws Exception;

    /**
     * Metodo para eliminar contenido del envio
     * 
     * @param shipmentContentId id del contenido
     * @throws Exception
     */
    void deleteShipmentContent(Long shipmentContentId) throws Exception;

    /**
     * Metodo para traer todos los envíos
     * 
     * @return devuelve lista con todos los envíos
     * @throws Exception
     */
    List<ShipmentInfoDto> getAllShipments() throws Exception;
}
