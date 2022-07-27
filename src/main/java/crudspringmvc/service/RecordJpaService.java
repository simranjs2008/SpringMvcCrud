package crudspringmvc.service;

import java.util.List;
import java.util.Optional;

import crudspringmvc.model.Record;

public interface RecordJpaService {
	public List<Record> getRecords();

	public void saveRecord(Record theCustomer);

	public Optional<Record> findById(int theId);

	public void deleteRecord(int theId);
	
	public void updateRecord(Record record);
}
