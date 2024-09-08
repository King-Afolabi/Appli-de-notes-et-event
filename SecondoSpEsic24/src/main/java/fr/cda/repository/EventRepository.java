package fr.cda.repository;

import org.springframework.data.repository.CrudRepository;

import fr.cda.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	public Iterable<Event> findByUserId(Long id);
}
