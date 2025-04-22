package com.envios_internacionales.envios_internacionales.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.mapper.ShipmentMapper;
import com.envios_internacionales.envios_internacionales.mapper.TrackingMapper;
import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;
import com.envios_internacionales.envios_internacionales.repository.ShipmentContentRepository;
import com.envios_internacionales.envios_internacionales.repository.ShipmentRepository;
import com.envios_internacionales.envios_internacionales.service.Interface.IShipmentSvc;
import com.envios_internacionales.envios_internacionales.service.Interface.ITrackingSvc;

@Service
public class ShipmentSvcImpl implements IShipmentSvc {

    @Autowired
    private ShipmentRepository _shipmentRepository;
    @Autowired
    private ShipmentContentRepository _shipmentContentRepository;
    @Autowired
    private ITrackingSvc _ITrackingSvc;

    public List<ShipmentInfoDto> getAllShipments() throws Exception {
        var entities = _shipmentRepository.findAll();

        if (entities.isEmpty()) {
            throw new Exception("No se encontraron envios para mostrar");
        }

        return ShipmentMapper.toShipmentDtos(entities);
    }

    public ShipmentInfoDto getShipmentInfoById(Long id) throws Exception {
        var content = _shipmentRepository.findById(id);

        if (content.isEmpty())
            throw new Exception("No se encontró un envío para el id " + id);

        return ShipmentMapper.toDto(content.get());
    }

    public List<ShipmentContentDto> getShipmentContentByShipmentId(Long shipmentId) throws Exception {

        var shipment = _shipmentRepository.findById(shipmentId).orElseThrow(() -> new Exception("No se encontró el envío para el id "+shipmentId));

        var content = shipment.getContent();

        if (content.isEmpty())
            throw new Exception("No se encontró el contenido para el id de envío " + shipmentId);

        return ShipmentMapper.toDtos(content);
    }
    public ShipmentContentDto getShipmentContentById(Long shipmentContentId)throws Exception {

        var content = _shipmentContentRepository.findById(shipmentContentId).orElseThrow(() -> new Exception("No se encontró el contenido para el id "+shipmentContentId));

        return ShipmentMapper.toDto(content);
    }

    public ShipmentInfoDto createShipment(ShipmentInfoDto dto) throws Exception {
        var entity = ShipmentMapper.toEntity(dto);

        if (dto.getContent().isEmpty()) {
            throw new Exception("Debe ingresar contenido con el envio");
        }

        var contentEntities = ShipmentMapper.toEntities(dto.getContent());

        for (ShipmentContent content : contentEntities) {
            content.setShipment(entity);
        }
        entity.setContent(contentEntities);

        if (dto.getTracking() == null) {
            throw new Exception("Debe ingresar seguimiento con el envio");
        }

        var trackingEntity = TrackingMapper.toEntity(dto.getTracking());

        trackingEntity.setShipment(entity);

        entity.setTracking(trackingEntity);

        var createdEntity = _shipmentRepository.save(entity);
        var result = ShipmentMapper.toDto(createdEntity);

        result.setContent(ShipmentMapper.toDtos(createdEntity.getContent()));
        result.setTracking(TrackingMapper.toDto(createdEntity.getTracking()));
        return result;
    }

    public ShipmentInfoDto updateShipment(ShipmentInfoDto dto, Long shipmentId) throws Exception {
        var shipmentEntity = _shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new Exception("No se encontró un envío para el id " + shipmentId));

        shipmentEntity.setShippingAddress(dto.shippingAddress);

        if (dto.getTracking() != null) {
            var trackingId = shipmentEntity.getTracking().getTrackingId();

            _ITrackingSvc.updateTracking(dto.getTracking(), trackingId);
        }

        if (!dto.getContent().isEmpty()) {
            var content = dto.getContent();

            for (ShipmentContentDto shipmentContentDto : content) {
                shipmentContentDto = updateShipmentContent(shipmentContentDto);
            }
        }

        return ShipmentMapper.toDto(_shipmentRepository.save(shipmentEntity));
    }

    public void deleteShipment(Long shipmentId) throws Exception {
        if (!_shipmentRepository.existsById(shipmentId)) {
            throw new Exception("No se encontró un envío con id " + shipmentId);
        }
        _shipmentRepository.deleteById(shipmentId);
    }

    public ShipmentContentDto createShipmentContent(ShipmentContentDto dto, Long shipmentId) throws Exception {

        var shipmentEntity = _shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new Exception("No se econtró un envío con el id " + shipmentId));

        var shipmentContentEntity = ShipmentMapper.toEntity(dto);

        shipmentContentEntity.setShipment(shipmentEntity);

        return ShipmentMapper.toDto(_shipmentContentRepository.save(shipmentContentEntity));
    }

    public List<ShipmentContentDto> createShipmentContent(List<ShipmentContentDto> dto, Long shipmentId)
            throws Exception {

        var shipmentEntity = _shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new Exception("No se econtró un envío con el id " + shipmentId));

        var shipmentContentEntities = ShipmentMapper.toEntities(dto);

        shipmentContentEntities.stream().forEach(content -> content.setShipment(shipmentEntity));

        return ShipmentMapper.toDtos(_shipmentContentRepository.saveAll(shipmentContentEntities));
    }

    public ShipmentContentDto updateShipmentContent(ShipmentContentDto dto) throws Exception {
        var contentEntity = _shipmentContentRepository.findById(dto.shipmentContentId)
                .orElseThrow(
                        () -> new Exception(
                                "No se encontró un contenido de envío para el id " + dto.shipmentContentId));

        contentEntity.setItemsAmount(dto.getItemsAmount());
        contentEntity.setWeight(dto.getWeight());
        contentEntity.setShipmentContentId(dto.getShipmentContentId());
        return ShipmentMapper.toDto(_shipmentContentRepository.save(contentEntity));
    }

    public void deleteShipmentContent(Long shipmentContentId) throws Exception {
        if (!_shipmentContentRepository.existsById(shipmentContentId)) {
            throw new Exception("No se encontró un contenido con el id " + shipmentContentId);
        }
        _shipmentContentRepository.deleteById(shipmentContentId);
    }

}
