package ir.asta.training.contacts.dao;

import java.util.List;

import javax.inject.Named;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.UserEntity;

@Named("contactDao")
public class ContactDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ContactDao() throws NamingException {
	}



	public int signUp(UserEntity userEntity){
		try{
			entityManager.persist(userEntity);
			return 1;
		}catch (Exception e){
			return -1;
		}
	}

	public UserEntity signIn(String user, String pass) {
		Query query;
		try {
			query = entityManager.createQuery(String.format("Select u from UserEntity u where u.username = '%s' and u.pass = '%s'", user, pass));
			List<UserEntity> list = query.getResultList();
			if (list.size() == 0){
				return null;
			}
			return list.get(0);
		}
		catch (Exception e){
			return null;
		}
	}

	public void chooseSatisfaction(String sender, String receiver, String title, String condition, String satisfied) {
		Query query;
		try {
			query = entityManager.createQuery(String.format("update CaseEntity u set u.satisfied = '%s' where u.sender = '%s' and u.receiver = '%s' and u.title = '%s' and u.condition = '%s'", satisfied, sender, receiver, title, condition));
			query.executeUpdate();
		}
		catch (Exception e){
		}
	}

	public void refreshcase(String sender, String title, String lastreceiver, String nextreceiver, String paraf, String lastcondition, String nextcondition) {
		Query query;
		if (lastcondition.equals(nextcondition)){
			//this is paraf
			try {
				query = entityManager.createQuery(String.format("update CaseEntity u set u.receiver = '%s' , u.paraf ='%s' where u.sender = '%s' and u.receiver = '%s' and u.title = '%s' and u.condition = '%s'", nextreceiver, paraf, sender, lastreceiver, title, lastcondition));
				query.executeUpdate();
			}
			catch (Exception e){
			}
		}else{
			//this is condition
			try {
				query = entityManager.createQuery(String.format("update CaseEntity u set u.condition = '%s' where u.sender = '%s' and u.receiver = '%s' and u.title = '%s' and u.condition = '%s'", nextcondition, sender, lastreceiver, title, lastcondition));
				query.executeUpdate();
			}
			catch (Exception e){
			}

		}
	}

	public int changePass(String user, String pass){
		Query query;
		try {
			query = entityManager.createQuery(String.format("update UserEntity u set u.pass = '%s' where u.username = '%s'", pass, user));
			query.executeUpdate();
			return 1;
		}
		catch (Exception e){
			return -1;
		}
	}

	public void userToggle(String user){
		Query query;
		try {
			query = entityManager.createQuery(String.format("select u from UserEntity u where u.username = '%s'", user));
			List<UserEntity> list = query.getResultList();
			UserEntity userEntity = list.get(0);

			if (userEntity.getVerified() == "0" || userEntity.getVerified().trim().charAt(0) == '0'){
				query = entityManager.createQuery(String.format("update UserEntity u set u.verified = '1' where u.username = '%s'", user));
				query.executeUpdate();
			}else {
				query = entityManager.createQuery(String.format("update UserEntity u set u.verified = '0' where u.username = '%s'", user));
				query.executeUpdate();
			}
		}
		catch (Exception e){
		}
	}

	public List<UserEntity> validCaseReceiver(){
		Query query;
		try {
			query = entityManager.createQuery(String.format("Select u from UserEntity u where (u.role = '1' or u.role = '3') and u.verified = '1'"));
			List<UserEntity> list = query.getResultList();
			if (list.size() == 0){
				return null;
			}
			return list;
		}
		catch (Exception e){
			return null;
		}
	}

	public List<UserEntity> userManagement(){
		Query query;
		try {
			query = entityManager.createQuery(String.format("Select u from UserEntity u"));
			List<UserEntity> list = query.getResultList();
			if (list.size() == 0){
				return null;
			}
			return list;
		}
		catch (Exception e){
			return null;
		}
	}

	public List<CaseEntity> getAllCases(){
		Query query;
		try {
			query = entityManager.createQuery(String.format("Select c from CaseEntity c"));
			List<CaseEntity> list = query.getResultList();
			if (list.size() == 0){
				return null;
			}
			return list;
		}
		catch (Exception e){
			return null;
		}

	}

    public int saveCase(CaseEntity caseEntity){
        try{
            entityManager.persist(caseEntity);
            return 1;
        }
        catch (Exception e){
            return -1;
        }
    }
	
}
