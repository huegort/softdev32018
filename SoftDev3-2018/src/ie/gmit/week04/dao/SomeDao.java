package ie.gmit.week04.dao;

import java.util.Collection;
import java.util.HashMap;


import ie.gmit.week04.model.SomeObject;

public class SomeDao {
	
	private static HashMap<String, SomeObject> db = new HashMap<String, SomeObject>();
	
	public void create(SomeObject someObject) {
		db.put(someObject.getText(), someObject);
	
		
	}
	public Collection<SomeObject> getAll(){
		return db.values();
	}
	
	public SomeObject findById(String id) {
		return db.get(id);
	}
	public void update (SomeObject someObject){
		db.put(someObject.getText(), someObject);
	}
	public void delete (String id){
		db.remove(id);
	} 
	

}
