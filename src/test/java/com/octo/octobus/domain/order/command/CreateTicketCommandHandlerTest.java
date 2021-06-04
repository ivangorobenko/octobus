package com.octo.octobus.domain.order.command;

import com.octo.octobus.domain.core.command.CommandResponse;
import com.octo.octobus.domain.order.Journey;
import com.octo.octobus.domain.order.Ticket;
import com.octo.octobus.infrastructure.repository.InMemoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreateTicketCommandHandlerTest {

    @Test
    @DisplayName("Doit renvoyer un id de billet quand il est créé")
    void shouldReturnAnIdForACreatedTicket() {
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler(new InMemoryRepository<>());
        long timestamp = System.currentTimeMillis();
        int trainId = 1234;

        CommandResponse response = sut.handle(new CreateTicketCommand(new Journey(trainId, timestamp)));

        assertNotNull(response.getId());
    }

    @Test
    @DisplayName("Doit créer un billet quand on reçoit la commande de création du billet")
    void shouldCreateATicket() {
        InMemoryRepository<Ticket> ticketRepository = new InMemoryRepository<>();
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler(ticketRepository);
        long timestamp = System.currentTimeMillis();
        int trainId = 1234;

        CommandResponse response = sut.handle(new CreateTicketCommand(new Journey(trainId, timestamp)));

        String responseId = response.getId();
        Ticket ticket = ticketRepository.get(responseId);
        assertNotNull(ticket);
        assertEquals(responseId, ticket.getId());
    }

    @Test
    @DisplayName("Doit créer un id unique de ticket")
    void shouldCreateAUniqueTicketId() {
        InMemoryRepository<Ticket> ticketRepository = new InMemoryRepository<>();
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler(ticketRepository);
        long timestamp = System.currentTimeMillis();
        int trainId = 1234;

        CommandResponse response = sut.handle(new CreateTicketCommand(new Journey(trainId, timestamp)));
        CommandResponse response2 = sut.handle(new CreateTicketCommand(new Journey(trainId, timestamp)));

        assertNotEquals(response.getId(), response2.getId());
    }

    @Test
    @DisplayName("Doit enregistrer le voyage dans le ticket")
    void shouldSaveJourneyInTicket() {
        InMemoryRepository<Ticket> ticketRepository = new InMemoryRepository<>();
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler(ticketRepository);
        long timestamp = System.currentTimeMillis();
        int trainId = 1234;

        Journey expectedJourney = new Journey(trainId, timestamp);
        CommandResponse response = sut.handle(new CreateTicketCommand(expectedJourney));

        Ticket ticket = ticketRepository.get(response.getId());
        Journey journey = ticket.getJourney();
        assertEquals(expectedJourney.getTrainId(), journey.getTrainId());
        assertEquals(expectedJourney.getTimestamp(), journey.getTimestamp());
    }

}
