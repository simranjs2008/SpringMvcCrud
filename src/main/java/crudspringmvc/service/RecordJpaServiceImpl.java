package crudspringmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crudspringmvc.dao.RecordRepo;
import crudspringmvc.model.Record;

@Service
@Transactional
public class RecordJpaServiceImpl implements RecordJpaService {

	@Autowired
	RecordRepo recordRepo;
	
	@Override
	public List<Record> getRecords() {
		return recordRepo.findAll();
	}

	@Override
	public void saveRecord(Record record) {
		recordRepo.save(record);	
	}

	@Override
	public Optional<Record> findById(int theId) {
		return recordRepo.findById(theId);
	}

	@Override
	public void deleteRecord(int theId) {
		recordRepo.deleteById(theId);
	}

	@Override
	public void updateRecord(Record record) {
		Optional<Record> recordVar = findById(record.getId());
		Record extractRecord = recordVar.get();
		extractRecord.setName(record.getName());
		extractRecord.setEmail(record.getEmail());
		extractRecord.setDob(record.getDob());
		extractRecord.setPhone(record.getPhone());
		recordRepo.save(extractRecord);	
		
	}

}
