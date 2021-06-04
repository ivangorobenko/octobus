package com.octo.octobus.domain.order.command;

import com.octo.octobus.domain.order.Journey;

public class CreateTicketCommand {
    private Journey journey;

    public CreateTicketCommand(Journey journey) {
        this.journey = journey;
    }

    public Journey getJourney() {
        return journey;
    }
}
