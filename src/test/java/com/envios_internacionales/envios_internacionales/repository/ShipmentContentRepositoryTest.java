package com.envios_internacionales.envios_internacionales.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ShipmentContentRepositoryTest {
    @Autowired
    private ShipmentContentRepository _shipmentContentRepository;

    @Test
    public void getContentByIdTest() {

        var result = _shipmentContentRepository.findById(1L);

        assertEquals(result.isEmpty(), false);

    }

    @Test
    public void findAllTest() {

        var result = _shipmentContentRepository.findAll();

        assertEquals(result.isEmpty(), false);

    }
}
