package ir.asta.training.contacts.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import ir.asta.training.contacts.entities.ContactEntity;

@Named("contactDao")
public class ContactDao {

	@Inject
	SessionFactory sessionFactory;
	
	public void save(ContactEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
	
	public ContactEntity load(Long id) {
		// TODO implement this method
		return null;
	}
	
	public List<ContactEntity> findAll() {
		// TODO implement this method
		return null;
	}
	
}
