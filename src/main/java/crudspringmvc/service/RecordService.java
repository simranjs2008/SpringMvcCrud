package crudspringmvc.service;

import java.util.List;

import crudspringmvc.model.Record;

public interface RecordService {
	public int addRecord(Record record);
	public List<Record> findAllRecord();
	public Record findById(int id);
	public void updateRecord(Record record);
}

