package com.octo.octobus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OctobusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Doit créer un billet pour un voyage")
    void shouldCreateATicketForAJourney() {
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
}
