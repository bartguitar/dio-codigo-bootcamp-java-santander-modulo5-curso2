package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain;

public class SeatAlreadyReservedException extends RuntimeException {
    public SeatAlreadyReservedException() {
        super("Seat is already reserved");
    }
}