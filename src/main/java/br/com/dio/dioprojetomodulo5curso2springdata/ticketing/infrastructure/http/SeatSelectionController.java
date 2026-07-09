package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.http;

import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.application.SelectSeatUseCase;
import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.CustomerId;
import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.EventId;
import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.http.request.SeatSelectionRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticketing/events/{eventId}/seats")
public class SeatSelectionController {
    private final SelectSeatUseCase selectSeatUseCase;

    public SeatSelectionController(SelectSeatUseCase selectSeatUseCase) {
        this.selectSeatUseCase = selectSeatUseCase;
    }

    @PostMapping("/select")
    @ResponseStatus(HttpStatus.CREATED)
    public void selectSeat(@PathVariable String eventId, @RequestBody SeatSelectionRequest request, @RequestHeader("X-CUSTOMER-ID") String customerId) {
        selectSeatUseCase.execute(new EventId(eventId), request.toInput(), new CustomerId(customerId));
    }
}