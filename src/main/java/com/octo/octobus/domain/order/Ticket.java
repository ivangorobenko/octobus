package com.octo.octobus.domain.order;

import java.util.UUID;

public class Ticket {
    private final String id;
    private Journey journey;

    public Ticket(Journey journey) {
        this.journey = journey;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Journey getJourney() {
        return journey;
    }
}
