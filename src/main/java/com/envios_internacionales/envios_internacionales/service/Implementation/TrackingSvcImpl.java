package com.envios_internacionales.envios_internacionales.service.Implementation;

import org.springframework.stereotype.Service;

import com.envios_internacionales.envios_internacionales.dto.TrackingDto;
import com.envios_internacionales.envios_internacionales.mapper.TrackingMapper;
import com.envios_internacionales.envios_internacionales.repository.Implementation.ShipmentRepositoryImpl;
import com.envios_internacionales.envios_internacionales.repository.Interface.IShipmentRepository;
import com.envios_internacionales.envios_internacionales.service.Interface.ITrackingSvc;

@Service
public class TrackingSvcImpl implements ITrackingSvc {
    
    private final IShipmentRepository _shipmentRepository;

    public TrackingSvcImpl(ShipmentRepositoryImpl shipmentRepositoryImpl){

        _shipmentRepository =  shipmentRepositoryImpl;

    }

    public TrackingDto getTrackinByCode(String trackingCode) throws Exception{
       return TrackingMapper.toDto( _shipmentRepository.getTrackinByCode(trackingCode));
    }

    public TrackingDto getTrackinById(int id) throws Exception{
        return TrackingMapper.toDto( _shipmentRepository.getTrackinByShipmentId(id));
     }

}
