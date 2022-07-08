package crudspringmvc.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crudspringmvc.model.Record;

@Repository
public class RecordDaoImpl implements RecordDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int createRecord(Record record) {
		int id = (Integer) sessionFactory.getCurrentSession().save(record);	
		return id;
	}

	@Override
	@Transactional
	public List<Record> findAllRecord() {
		List<Record> records = sessionFactory.getCurrentSession().createNativeQuery("Select * from record", Record.class).getResultList();;
		return records;
	}

	@Override
	@Transactional
	public Record findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Record record = session.get(Record.class, id);
		//Record record = sessionFactory.getCurrentSession().createNativeQuery("Select * from record r where r.id="+id, Record.class).getSingleResult();;
		return record;
	}

	@Override
	@Transactional
	public void updateRecord(Record record) {
		System.out.println("id requested to be changed: " + record.getId());
		Session session = sessionFactory.getCurrentSession();
		Record extractRecord = session.get(Record.class, record.getId());
		extractRecord.setName(record.getName());
		extractRecord.setEmail(record.getEmail());
		extractRecord.setDob(record.getDob());
		extractRecord.setPhone(record.getPhone());
		session.update(extractRecord);
	}
	
	@Override
	@Transactional
	public void deleteRecord(Record record) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(record);
	}
}
