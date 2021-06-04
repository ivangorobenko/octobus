package com.octo.octobus.infrastructure.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRepository<T> {
    private final Map<String, T> data;

    public InMemoryRepository() {
        this.data = new HashMap<>();
    }

    public void save(String key, T value) {
        this.data.put(key, value);
    }

    public T get(String key) {
        return this.data.get(key);
    }
}
