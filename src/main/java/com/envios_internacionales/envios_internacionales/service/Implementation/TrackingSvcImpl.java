package com.envios_internacionales.envios_internacionales.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.mapper.TrackingMapper;
import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.Tracking;
import com.envios_internacionales.envios_internacionales.repository.ShipmentRepository;
import com.envios_internacionales.envios_internacionales.repository.TrackingRepository;
import com.envios_internacionales.envios_internacionales.service.Interface.ITrackingSvc;

@Service
public class TrackingSvcImpl implements ITrackingSvc {

    @Autowired
    private ShipmentRepository _shipmentRepository;
    @Autowired

    private TrackingRepository _trackingRepository;

    @Override

    public TrackingDto getTrackinByCode(String trackingCode) throws Exception {
        var trackingProbe = Tracking.builder().trackingCode(trackingCode).build();

        Example<Tracking> example = Example.of(trackingProbe);

        var trackingOptional = _trackingRepository.findOne(example);

        if (trackingOptional.isEmpty()) {
            throw new Exception("No se encontró el seguimiento con el código " + trackingCode);
        }
        var shipment = trackingOptional.get();

        return TrackingMapper.toDto(shipment);
    }

    @Override

    public TrackingDto getTrackinById(Long id) throws Exception {
        var shipmentProbe = Shipment.builder().shipmentId(id).build();

        Example<Shipment> example = Example.of(shipmentProbe);

        var shipmentOptional = _shipmentRepository.findOne(example);

        if (shipmentOptional.isEmpty()) {
            throw new Exception("No se encontró el envío con el id " + id);
        }

        var tracking = shipmentOptional.get().getTracking();

        return TrackingMapper.toDto(tracking);
    }

    @Override

    public TrackingDto createTracking(TrackingDto dto, Long shipmentId) throws Exception {

        var shipmentEntity = _shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new Exception("No se encontro el envío con el id " + shipmentId));

        if (shipmentEntity.getTracking() != null) {
            throw new Exception("Ya existe un seguimiento para el envío con el id " + shipmentId);
        }
        var trackingEntity = TrackingMapper.toEntity(dto);

        trackingEntity.setShipment(shipmentEntity);

        _trackingRepository.save(trackingEntity);

        return TrackingMapper.toDto(trackingEntity);
    }

    @Override

    public TrackingDto updateTracking(TrackingDto dto, Long trackingId) throws Exception {
        var trackingEntity = _trackingRepository.findById(trackingId)
                .orElseThrow(() -> new Exception("No se encontró el seguimiento con el id " + trackingId));

        trackingEntity.setCurrentLocation(dto.getCurrentLocation());
        trackingEntity.setStatus(dto.getStatus());
        trackingEntity.setTrackingCode(dto.getTrackingCode());

        return TrackingMapper.toDto(_trackingRepository.save(trackingEntity));
    }

    @Override

    public void deleteTracking(Long trackingId) throws Exception {

        var tracking = _trackingRepository.findById(trackingId)
                .orElseThrow(() -> new Exception("No se encontró un seguimiento para el id " + trackingId));
        var shipmentEntity = tracking.getShipment();
        shipmentEntity.setTracking(null);
        _shipmentRepository.save(shipmentEntity);
    }

    @Override

    public List<TrackingDto> getAllTracking() throws Exception {

        var entities = _trackingRepository.findAll();

        if (entities.isEmpty()) {
            throw new Exception("No se encontró ni un seguimiento");
        }

        return TrackingMapper.toDtos(entities);
    }
}
