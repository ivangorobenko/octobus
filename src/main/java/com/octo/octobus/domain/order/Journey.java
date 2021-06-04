package com.octo.octobus.domain.order;

public class Journey {
    private int trainId;
    private long timestamp;

    public Journey(int trainId, long timestamp) {
        this.trainId = trainId;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getTrainId() {
        return trainId;
    }
}
