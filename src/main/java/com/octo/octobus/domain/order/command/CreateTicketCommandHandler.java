package com.octo.octobus.domain.order.command;

import com.octo.octobus.domain.core.command.CommandResponse;
import com.octo.octobus.domain.order.Ticket;
import com.octo.octobus.infrastructure.repository.InMemoryRepository;

public class CreateTicketCommandHandler {
    private InMemoryRepository<Ticket> ticketRepository;

    public CreateTicketCommandHandler(InMemoryRepository<Ticket> ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public CommandResponse handle(CreateTicketCommand createTicketCommand) {

        Ticket ticket = new Ticket(createTicketCommand.getJourney());

        String ticketId = ticket.getId();
        this.ticketRepository.save(ticketId, ticket);
        return new CommandResponse(ticketId);
    }
}
