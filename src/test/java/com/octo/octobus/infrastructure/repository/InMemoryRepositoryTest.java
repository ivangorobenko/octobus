package com.octo.octobus.infrastructure.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class InMemoryRepositoryTest {

    @Test
    @DisplayName("Doit enregistrer une entrée")
    void shouldSaveANewEntry() {
        InMemoryRepository<String> sut = new InMemoryRepository<>();

        sut.save("TOTO", "TATA");

        assertEquals("TATA", sut.get("TOTO"));
    }

    @Test
    @DisplayName("Doit enregistrer plusieurs entrées")
    void shouldSaveMultipleEntries() {
        InMemoryRepository<String> sut = new InMemoryRepository<>();

        Arrays.asList("1","2","3", "JEAN_PAUL").stream().forEach(key -> {
            sut.save(key, "TOTO" + key);
            assertEquals("TOTO" + key, sut.get(key));
        });
    }
}