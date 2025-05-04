package com.envios_internacionales.envios_internacionales.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.envios_internacionales.envios_internacionales.model.Shipment;
import com.envios_internacionales.envios_internacionales.model.ShipmentContent;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShipmentContentRepositoryTest {
    @Autowired
    private ShipmentContentRepository _shipmentContentRepository;

    @Test
    public void getContentByShipmentIdTest() {

        var result = _shipmentContentRepository.findById(1L);

        assertEquals(result.isEmpty(), false);

    }

    @Test
    public void findAllTest() {

        var result = _shipmentContentRepository.findAll();

        assertEquals(result.isEmpty(), false);

    }
}
