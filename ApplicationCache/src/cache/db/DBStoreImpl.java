package cache.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cache.model.User;

public class DBStoreImpl implements DBStore{

	static List<User> userList = new ArrayList<>();
	
	public List<User> getUserList() {
		return userList;
	}
	public DBStoreImpl(){
	}
	
	public User isUserExist(int id) {
		for(User u: userList) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
		
	}
	
	@Override
	public void addToDB(User user) {
		userList.add(user);
	}
	
	public void printData() {
		Iterator<User> it = userList.iterator();
		while(it.hasNext()) {
			User u = it.next();
			System.out.println("User id"+u.getId()+"User email id="+ u.getEmailId()+" User name="+
			u.getName()+" User Type="+ u.getUserType());
		}
	}

	@Override
	public void removeFromDB(User user) {
		userList.remove(user);
	}

}
