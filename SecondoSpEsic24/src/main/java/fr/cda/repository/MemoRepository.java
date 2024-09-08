package fr.cda.repository;

import org.springframework.data.repository.CrudRepository;


import fr.cda.entity.Memo;

public interface MemoRepository extends CrudRepository<Memo, Long>{
	
	public Iterable<Memo> findByUserId(Long id);

}
