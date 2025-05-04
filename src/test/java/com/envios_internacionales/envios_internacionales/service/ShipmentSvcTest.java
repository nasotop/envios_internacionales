package com.envios_internacionales.envios_internacionales.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.envios_internacionales.envios_internacionales.service.Interface.IShipmentSvc;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShipmentSvcTest {
    @Autowired
    private IShipmentSvc _shipmentSvc;

    @Test
    public void getByIdTest() {
        Long id = (long) 1;

        assertDoesNotThrow(() -> {
            var dto = _shipmentSvc.getShipmentInfoById(id);
            assertNotNull(dto, "El DTO no debería ser null");
        }, "El método getShipmentInfoById lanzó una excepción");
    }

    @Test
    public void getAllTest() {
        assertDoesNotThrow(() -> {
            var result = _shipmentSvc.getAllShipments();
            assertEquals(result.isEmpty(), false);
        }, "El método getShipmentInfoById lanzó una excepción");
    }
}
