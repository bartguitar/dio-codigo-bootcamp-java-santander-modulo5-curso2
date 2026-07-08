package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain;

import org.springframework.util.Assert;

public record SeatId(String id) {
    public SeatId {
        Assert.notNull(id, "id must not be null");
    }
}