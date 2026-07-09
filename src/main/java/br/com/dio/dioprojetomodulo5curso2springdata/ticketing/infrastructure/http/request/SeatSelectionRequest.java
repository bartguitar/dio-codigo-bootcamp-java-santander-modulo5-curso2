package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.http.request;

import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.SeatId;

public record SeatSelectionRequest(String id) {
    public SeatId toInput() {
        return new SeatId(id);
    }
}