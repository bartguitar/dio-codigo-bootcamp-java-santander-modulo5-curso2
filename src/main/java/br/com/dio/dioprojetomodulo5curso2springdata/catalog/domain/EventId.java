package br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain;

import java.util.UUID;

public record EventId(UUID id) {
    public EventId() {
        this(UUID.randomUUID());
    }
}
