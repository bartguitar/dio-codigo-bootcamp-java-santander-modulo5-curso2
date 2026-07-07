package br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.persistence.repository;

import br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain.Event;
import br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain.EventId;
import br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain.EventRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class JpaEventRepository implements EventRepository {
    private final EventEntityRepository eventEntityRepository;

    public JpaEventRepository(EventEntityRepository eventEntityRepository) {
        this.eventEntityRepository = eventEntityRepository;
    }

    @Override
    public List<Event> findAll() {
        var iterable = eventEntityRepository.findAll();

        return StreamSupport.stream(iterable.spliterator(), false)
                .map(JpaEventRepository::mapper).toList();
    }

    private static Event mapper(br.com.dio.dioprojetomodulo5curso2springdata.catalog.infrastructure.persistence.entity.Event event) {
        return new Event(new EventId(event.getId()), event.getTitle(), event.getDate(), Optional.empty());
    }
}
