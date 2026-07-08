package br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.repository;


import br.com.dio.dioprojetomodulo5curso2springdata.ticketing.domain.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresEventRepository implements EventRepository {

    private final EventCrudRepository eventCrudRepository;


    public PostgresEventRepository(EventCrudRepository eventCrudRepository) {
        this.eventCrudRepository = eventCrudRepository;
    }



    @Override
    public void save(Event event) {
        var sectors = event.getSeats().entrySet().stream()
                .map(entry -> {
                    Sector domainSector = entry.getKey();
                    List<Seat> domainSeats = entry.getValue();

                    var seats = domainSeats.stream()
                            .map(s -> new br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.entity.Seat(
                                    s.getId(),
                                    s.getCorrelationId().id()
                            ))
                            .toList();

                    return new br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.entity.Sector(
                            domainSector.getId(),
                            domainSector.getCorrelationId().id(),
                            domainSector.getPrice(),
                            seats
                    );
                })
                .toList();

        var entity = new br.com.dio.dioprojetomodulo5curso2springdata.ticketing.infrastructure.persistence.entity.Event(
                event.getId(),
                event.getCorrelationId().id(),
                sectors);

        eventCrudRepository.save(entity);
    }
}