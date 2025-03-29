package com.envios_internacionales.envios_internacionales.service.Implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.mapper.ShipmentMapper;
import com.envios_internacionales.envios_internacionales.repository.Implementation.ShipmentRepositoryImpl;
import com.envios_internacionales.envios_internacionales.repository.Interface.IShipmentRepository;
import com.envios_internacionales.envios_internacionales.service.Interface.IShipmentSvc;

@Service
public class ShipmentSvcImpl implements  IShipmentSvc{
    
        
    private final IShipmentRepository _shipmentRepository;

    public ShipmentSvcImpl(ShipmentRepositoryImpl shipmentRepositoryImpl){

        _shipmentRepository =  shipmentRepositoryImpl;

    }

    public ShipmentInfoDto getShipmentInfoById(int id){
        return ShipmentMapper.toDto(_shipmentRepository.getShipmentById(id));
    }

    public List<ShipmentContentDto> getShipmentContentByShipmentId(int shipmentId){
        return ShipmentMapper.toShipmentContentDtos(_shipmentRepository.getShipmentContentById(shipmentId));
    }
}
