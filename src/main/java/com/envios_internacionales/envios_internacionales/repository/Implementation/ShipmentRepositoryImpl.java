package com.envios_internacionales.envios_internacionales.repository.Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.envios_internacionales.envios_internacionales.enums.TrackingStatusType;
import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;
import com.envios_internacionales.envios_internacionales.model.Tracking;
import com.envios_internacionales.envios_internacionales.repository.Interface.IShipmentRepository;
@Repository
public class ShipmentRepositoryImpl implements IShipmentRepository {

    private final ArrayList<ShipmentContent> shipmentContents = new ArrayList<>();
    private final ArrayList<Shipment> shipments = new ArrayList<>();
    private final ArrayList<Tracking> trackings = new ArrayList<>();

    public ShipmentRepositoryImpl() {
        /* Lista de contenidos */
        shipmentContents.add(ShipmentContent.builder().weight(10.5).itemsAmount(3).shipmentId(1).build());
        shipmentContents.add(ShipmentContent.builder().weight(7.8).itemsAmount(5).shipmentId(1).build());
        shipmentContents.add(ShipmentContent.builder().weight(12.3).itemsAmount(2).shipmentId(2).build());
        shipmentContents.add(ShipmentContent.builder().weight(9.4).itemsAmount(6).shipmentId(2).build());
        shipmentContents.add(ShipmentContent.builder().weight(8.7).itemsAmount(4).shipmentId(3).build());
        shipmentContents.add(ShipmentContent.builder().weight(14.2).itemsAmount(7).shipmentId(3).build());
        shipmentContents.add(ShipmentContent.builder().weight(6.9).itemsAmount(8).shipmentId(4).build());
        shipmentContents.add(ShipmentContent.builder().weight(15.5).itemsAmount(3).shipmentId(4).build());
        shipmentContents.add(ShipmentContent.builder().weight(11.8).itemsAmount(5).shipmentId(5).build());
        shipmentContents.add(ShipmentContent.builder().weight(7.2).itemsAmount(9).shipmentId(5).build());
        shipmentContents.add(ShipmentContent.builder().weight(13.9).itemsAmount(2).shipmentId(6).build());
        shipmentContents.add(ShipmentContent.builder().weight(5.6).itemsAmount(10).shipmentId(6).build());
        shipmentContents.add(ShipmentContent.builder().weight(16.3).itemsAmount(1).shipmentId(7).build());
        shipmentContents.add(ShipmentContent.builder().weight(9.1).itemsAmount(6).shipmentId(7).build());
        shipmentContents.add(ShipmentContent.builder().weight(17.5).itemsAmount(2).shipmentId(8).build());
        shipmentContents.add(ShipmentContent.builder().weight(8.0).itemsAmount(8).shipmentId(8).build());

        /* Lista de envios */
        shipments.add(Shipment.builder().shipmentId(1).shippingAddress("Calle Falsa 123, Ciudad A").build());
        shipments.add(Shipment.builder().shipmentId(2).shippingAddress("Av. Central 456, Ciudad B").build());
        shipments.add(Shipment.builder().shipmentId(3).shippingAddress("Carrera 78, Barrio Norte, Ciudad C").build());
        shipments.add(Shipment.builder().shipmentId(4).shippingAddress("Paseo del Río 321, Ciudad D").build());
        shipments.add(Shipment.builder().shipmentId(5).shippingAddress("Callejón 5 de Mayo, Pueblo E").build());
        shipments.add(Shipment.builder().shipmentId(6).shippingAddress("Boulevard Principal 987, Ciudad F").build());
        shipments.add(Shipment.builder().shipmentId(7).shippingAddress("Av. del Sol 741, Ciudad G").build());
        shipments.add(Shipment.builder().shipmentId(8).shippingAddress("Camino Viejo 159, Ciudad H").build());

        /* Lista de seguimientos */
        trackings.add(Tracking.builder().status(TrackingStatusType.PREPARING).currentLocation("Almacén Central")
                .trackingCode("TRK001").shipmentId(1).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.INTRANSIT)
                .currentLocation("Centro de distribución - Ciudad A").trackingCode("TRK002").shipmentId(2).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.DELIVERED)
                .currentLocation("Entregado en Calle Falsa 123").trackingCode("TRK003").shipmentId(3).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.PREPARING).currentLocation("Almacén Regional")
                .trackingCode("TRK004").shipmentId(4).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.INTRANSIT)
                .currentLocation("En tránsito hacia Ciudad D").trackingCode("TRK005").shipmentId(5).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.DELIVERED)
                .currentLocation("Entregado en Av. Central 456").trackingCode("TRK006").shipmentId(6).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.PREPARING)
                .currentLocation("Centro de logística principal").trackingCode("TRK007").shipmentId(7).build());
        trackings.add(Tracking.builder().status(TrackingStatusType.INTRANSIT).currentLocation("En ruta a Ciudad H")
                .trackingCode("TRK008").shipmentId(8).build());
    }

    public Tracking getTrackinByCode(String trackingCode) throws Exception {

        Optional<Tracking> trackingInfo = trackings.stream().filter(f -> f.getTrackingCode().equals(trackingCode))
                .findAny();

        if (trackingInfo.isEmpty())
            throw new Exception("No se encuentra la información para el codigo: " + trackingCode);

        var actualTracking = linkShipmentToTracking(trackingInfo.get());

        return actualTracking;
    }

    public Tracking getTrackinByShipmentId(int shipmentId) throws Exception {

        Optional<Tracking> trackingInfo = trackings.stream().filter(f -> f.getShipmentId() == shipmentId)
                .findAny();

        if (trackingInfo.isEmpty())
            throw new Exception("No se encuentra la información para el envio: " + shipmentId);

        var actualTracking = linkShipmentToTracking(trackingInfo.get());

        return actualTracking;
    }

    public List<ShipmentContent> getShipmentContentById(int shipmentId) {

        return shipmentContents.stream().filter(f -> f.getShipmentId() == shipmentId)
                .toList();

    }

    public Shipment getShipmentById(int shipmentId) {

        var shipment = shipments.stream().filter(f -> f.getShipmentId() == shipmentId)
                .findFirst().get();

        var content = getShipmentContentById(shipment.getShipmentId());

        shipment.setContent(content);

        return shipment;
    }

    /**
     * Metodo para asociar informacion del seguimiento con el envio
     * 
     * @param tracking informacion del seguimiento
     * @return informacion de seguimiento asociada al envio
     */

    private Tracking linkShipmentToTracking(Tracking tracking) {

        var shipmentInfo = getShipmentById(tracking.getShipmentId());

        tracking.setShipmentInfo(shipmentInfo);

        return tracking;
    }
}
