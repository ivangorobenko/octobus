package com.octo.octobus.domain.core.command;

public class CommandResponse {
    private final String id;

    public CommandResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
