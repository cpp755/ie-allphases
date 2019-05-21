package ir.asta.training.contacts.manager;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ir.asta.training.contacts.entities.CaseEntity;
import org.json.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import ir.asta.training.contacts.dao.ContactDao;
import ir.asta.training.contacts.entities.UserEntity;

@Named("contactManager")
public class ContactManager {

	@Inject
	ContactDao dao;

	@Transactional
	public int signUp(UserEntity userEntity){
		return dao.signUp(userEntity);
	}

	@Transactional
	public UserEntity signIn(String s) {
		JSONObject jsonObject = new JSONObject(s);
		if (jsonObject != null){
			return dao.signIn(jsonObject.getString("username"), jsonObject.getString("pass"));
		}
		return null;
	}

	@Transactional
	public void chooseSatisfaction(String s) {
		JSONObject jsonObject = new JSONObject(s);
		if (jsonObject != null){
			dao.chooseSatisfaction(jsonObject.getString("sender"), jsonObject.getString("receiver"), jsonObject.getString("title"), jsonObject.getString("condition"), jsonObject.getString("satisfied"));
		}
	}

	@Transactional
	public void refreshcase(String s) {
		JSONObject jsonObject = new JSONObject(s);
		if (jsonObject != null){
			dao.refreshcase(jsonObject.getString("sender"), jsonObject.getString("title") ,jsonObject.getString("lastreceiver"), jsonObject.getString("nextreceiver"), jsonObject.getString("paraf"), jsonObject.getString("lastcondition"), jsonObject.getString("nextcondition"));
		}
	}

	@Transactional
	public int changePass(String s){
		JSONObject jsonObject = new JSONObject(s);
		if (jsonObject != null){
			return dao.changePass(jsonObject.getString("username"), jsonObject.getString("pass"));
		}
		return -1;
	}

	
	@Transactional
	public void userToggle(String s){
		JSONObject jsonObject = new JSONObject(s);
		if (jsonObject != null){
			dao.userToggle(jsonObject.getString("user"));
		}
	}

	public List<UserEntity> validCaseReceiver(){
		return dao.validCaseReceiver();
	}

	public List<UserEntity> userManagement(){
		return dao.userManagement();
	}

	public List<CaseEntity> getAllCases(){
		return dao.getAllCases();
	}

    @Transactional
    public int saveCase(CaseEntity caseEntity){
        return dao.saveCase(caseEntity);
    }

}
