package com.envios_internacionales.envios_internacionales.helper;

import java.util.List;

import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.envios_internacionales.envios_internacionales.controller.ShipmentController;
import com.envios_internacionales.envios_internacionales.controller.TrackingController;
import com.envios_internacionales.envios_internacionales.dto.ShipmentContentDto;
import com.envios_internacionales.envios_internacionales.dto.ShipmentInfoDto;
import com.envios_internacionales.envios_internacionales.dto.TrackingDto;

public class LinkHelper {

    public static List<Link> buildTrackingLinks(Long id, Long shipmentId, String trackingCode){
        return List.of(
            linkTo(methodOn(TrackingController.class).getTrackingInformationById(shipmentId)).withRel("Get"),
            linkTo(methodOn(TrackingController.class).updateTracking(new TrackingDto(), id)).withRel("Update"),
            linkTo(methodOn(TrackingController.class).deleteTracking( id)).withRel("Delete"),
            linkTo(methodOn(TrackingController.class).getTrackingInformation(trackingCode)).withRel("Get")
        );
    }

    public static List<Link> buildShipmentLinks(Long id){
        return List.of(
            linkTo(methodOn(ShipmentController.class).getShipmentContetByShipmentId(id)).withRel("Get"),
            linkTo(methodOn(ShipmentController.class).updateShipment(new ShipmentInfoDto(), id)).withRel("Update"),
            linkTo(methodOn(ShipmentController.class).deleteShipment(id)).withRel("Delete"),
            linkTo(methodOn(ShipmentController.class).getShipmentContetById(id)).withRel("Get")
        );
    }
    public static List<Link> buildShipmentContentLinks(Long id){
        return List.of(
            linkTo(methodOn(ShipmentController.class).getShipmentContetById(id)).withRel("Get"),
            linkTo(methodOn(ShipmentController.class).updateShipmentContents(new ShipmentContentDto(), id)).withRel("Update"),
            linkTo(methodOn(ShipmentController.class).deleteShipmentContent(id)).withRel("Delete")
        );
    }

}
