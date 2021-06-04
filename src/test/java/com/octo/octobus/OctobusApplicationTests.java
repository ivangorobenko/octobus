package com.octo.octobus;

import com.octo.octobus.infrastructure.repository.InMemoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OctobusApplicationTests {

    @Test
    @DisplayName("Doit renvoyer un id de billet quand il est créé")
    void shouldReturnAnIdForACreatedTicket() {
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler();
        long journeyTimestamp = System.currentTimeMillis();
        int trainId = 1234;

        CommandResponse response = sut.handle(new CreateTicketCommand(new Journey(trainId, journeyTimestamp)));

        assertNotNull(response.getId());
    }

    @Test
    @DisplayName("Doit créer un billet quand on reçoit la commande de création du billet")
    void shouldCreateATicket() {
        InMemoryRepository ticketRepository = new InMemoryRepository<Ticket>();
        CreateTicketCommandHandler sut = new CreateTicketCommandHandler();
        long journeyTimestamp = System.currentTimeMillis();
        int trainId = 1234;

        CommandResponse response = sut.handle(new CreateTicketCommand(new Journey(trainId, journeyTimestamp)));

        assertNotNull(response.getId());
    }

    private class CreateTicketCommandHandler {
        public CommandResponse handle(CreateTicketCommand createTicketCommand) {
            return new CommandResponse("0");
        }
    }

    public class CommandResponse {
        private final String id;

        public CommandResponse(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    public class CreateTicketCommand {
        private Journey journey;

        public CreateTicketCommand(Journey journey) {
            this.journey = journey;
        }

        public Journey getJourney() {
            return journey;
        }
    }

    private class Journey {
        private int trainId;
        private long journeyTimestamp;

        public Journey(int trainId, long journeyTimestamp) {
            this.trainId = trainId;
            this.journeyTimestamp = journeyTimestamp;
        }

        public long getJourneyTimestamp() {
            return journeyTimestamp;
        }

        public int getTrainId() {
            return trainId;
        }
    }

    public class Ticket {
        private final String id;

        public Ticket(){
            this.id = "0";
        }

        public String getId() {
            return id;
        }
    }

}
