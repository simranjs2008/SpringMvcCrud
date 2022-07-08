package crudspringmvc.dao;

import java.util.List;

import crudspringmvc.model.Record;

public interface RecordDao {
	public int createRecord(Record record);
	public List<Record> findAllRecord();
	public Record findById(int id);
	public void updateRecord(Record record);
}
