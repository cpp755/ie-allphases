package ir.asta.training.contacts.services.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import ir.asta.training.contacts.entities.CaseEntity;
import ir.asta.training.contacts.entities.UserEntity;
import ir.asta.training.contacts.manager.ContactManager;
import ir.asta.training.contacts.services.ContactService;
import org.json.JSONArray;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("contactService")
public class ContactServiceImpl implements ContactService {

	@Inject
	ContactManager manager;

    @Override
    public Response signUp(UserEntity userEntity) {
        int status = -11;
        try {
            status = manager.signUp(userEntity);
            if (status > 0){
                return Response.ok("حساب کاربری با موفقیت ثبت شد.").entity("حساب کاربری با موفقیت ثبت شد.").build();
            }
            return Response.ok("خطا در ثبت حساب کاربری").entity("خطا در ثبت حساب کاربری").build();
        }
        catch (Exception e){
            return Response.ok("خطا در ثبت حساب کاربری").entity("خطا در ثبت حساب کاربری").build();
        }
    }

    @Override
	public Response signIn(String s) throws JsonProcessingException {
		UserEntity userEntity = manager.signIn(s);
		if (userEntity != null){
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(userEntity);
			return Response.ok(json).entity(json).build();
		}
		return null;
	}

	@Override
	public Response chooseSatisfaction(String s) throws JsonProcessingException {
//		System.out.println(s);
		manager.chooseSatisfaction(s);
		return null;
	}

	@Override
	public Response refreshcase(String s) throws JsonProcessingException {
		manager.refreshcase(s);
		return null;
	}

	@Override
	public Response changePass(String s) throws JsonProcessingException {
		int response = manager.changePass(s);
		if (response > 0){
			return Response.ok("رمز عبور با موفقیت تغییر یافت.").entity("رمز عبور با موفقیت تغییر یافت.").build();
		}
		return Response.ok("خطا در تغییر رمز عبور.").entity("خطا در تغییر رمز عبور.").build();
	}

	@Override
	public void userToggle(String s) {
		manager.userToggle(s);
	}

    @Override
    public Response validCaseReceiver() {
        List<UserEntity> validreceiver =  manager.validCaseReceiver();
        if (validreceiver != null)
        {
            String json = new Gson().toJson(validreceiver);
            json = "{\"main\" : " + json + "}";
            JSONObject usersJsonObject = new JSONObject(json);
            JSONObject returnedObj = new JSONObject();
            returnedObj.put("main",new JSONArray());
            for (int i=0; i< ((JSONArray)usersJsonObject.get("main")).length(); i++){
                String user = ((JSONArray)usersJsonObject.get("main")).getJSONObject(i).getString("username");
                ((JSONArray)returnedObj.get("main")).put(user);
            }
            System.out.println(returnedObj.toString());
            return Response.ok(returnedObj.toString()).entity(returnedObj.toString()).build();
        }
        return null;
    }

	@Override
	public Response userManagement() {
		List<UserEntity> userEntities =manager.userManagement();
		if (userEntities != null)
		{
			String json = new Gson().toJson(userEntities);
			json = "{\"main\" : " + json + "}";
			JSONObject usersJsonObject = new JSONObject(json);
			for (int i=0; i< ((JSONArray)usersJsonObject.get("main")).length(); i++){
				((JSONArray)usersJsonObject.get("main")).getJSONObject(i).remove("pass");
			}
			return Response.ok(usersJsonObject.toString()).entity(usersJsonObject.toString()).build();
		}
		return null;
	}

	@Override
	public Response getAllCases() {
		List<CaseEntity> caseEntities = manager.getAllCases();
		if (caseEntities != null)
		{
			String json = new Gson().toJson(caseEntities);
			json = "{\"main\" : " + json + "}";
			JSONObject usersJsonObject = new JSONObject(json);
			return Response.ok(usersJsonObject.toString()).entity(usersJsonObject.toString()).build();
		}
		return null;
	}

    @Override
    public Response saveCase(CaseEntity caseEntity) {
        int status = -11;
        try {
            status = manager.saveCase(caseEntity);
            if (status > 0){
                return Response.ok("مورد با موفقیت ثبت شد.").entity("مورد با موفقیت ثبت شد.").build();
            }
            return Response.ok("خطا در ثبت مورد").entity("خطا در ثبت مورد").build();
        }
        catch (Exception e){
            return Response.ok("خطا در ثبت مورد").entity("خطا در ثبت مورد").build();
        }
    }
}
