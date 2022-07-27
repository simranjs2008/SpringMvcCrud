//package crudspringmvc.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import crudspringmvc.dao.RecordDao;
//import crudspringmvc.model.Record;
//
//@Service
//public class RecordServiceImpl implements RecordService{
//
//	@Autowired
//	private RecordDao recordDao;
//	
//	@Override
//	public int addRecord(Record record) {
//		int i = recordDao.createRecord(record);
//		return i;
//	}
//
//	@Override
//	public List<Record> findAllRecord() {
//		List<Record> records = recordDao.findAllRecord();
//		return records;
//	}
//
//	@Override
//	public Record findById(int id) {
//		Record record = recordDao.findById(id);
//		return record;
//	}
//
//	@Override
//	public void updateRecord(Record record) {
//		recordDao.updateRecord(record);
//	}
//
//	@Override
//	public void deleteRecord(int recordId) {
//		Record record = recordDao.findById(recordId);
//		recordDao.deleteRecord(record);
//	}
//
//}
