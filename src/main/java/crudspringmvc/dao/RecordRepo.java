package crudspringmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crudspringmvc.model.Record;

@Repository
public interface RecordRepo extends JpaRepository<Record, Integer>{ 

}
