package br.com.dio.dioprojetomodulo5curso2springdata.catalog.domain;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();
}
