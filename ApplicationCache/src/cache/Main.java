package cache;

import cache.db.DBStoreImpl;
import cache.impl.Cache;
import cache.impl.CacheManager;
import cache.model.User;
import cache.usermgr.RefreshUserCache;
import cache.usermgr.UserManagerImpl;
//Tester class 
public class Main {
	
	public static void main(String args[]) {

		UserManagerImpl test = new UserManagerImpl();
		DBStoreImpl d = new DBStoreImpl();
		try {
			User user1 = new User(1,"tushar","tusharseth1990@gmail.com","Permanent");
			User user2 = new User(2,"tanmay","tanmayseth1990@gmail.com","Contract");
			User user3 = new User(3,"pradosh","pradosh@gmail.com","Permanent");
			User user4 = new User(4,"shubham","shubham@gmail.com","Permanent");
			User user5 = new User(5,"test","test@gmail.com","Permanent");
			d.getUserList().add(user1);
			d.getUserList().add(user2);
			d.getUserList().add(user3);
			d.getUserList().add(user4);
			d.getUserList().add(user5);
			d.printData();
			RefreshUserCache r = new RefreshUserCache();
			r.refreshCacheFirstTime();
		//testing search scenarios
		User u = test.searchUser(2);
		System.out.println("Printing from Cache");
		System.out.println("userid= "+u.getId()+" user name="+u.getName()+ " user email id="+u.getEmailId());
		User u1 = test.searchUser(6);
		if(u1!=null) {
			System.out.println("userid= "+u1.getId()+" user name="+u1.getName()+ " user email id="+u1.getEmailId());	
		}
		}catch(Exception e) {
			System.out.println(e);
		}
		//testing delete scenarios
		try {
			//test.deleteUser(5);
			//test.deleteUser(7);
			Cache<Integer,User> c = CacheManager.getCacheInstance();
			c.printCache();
			//test.deleteUser(4);
			//c.printCache();
			User user=new User(1,"Test1","Test1@gmail.com","Permanent");
			test.createUser(user);
			User user8=new User(8,"Test4","Test123456@gmail.com","Permanent");
			test.createUser(user8);
			c.printCache();
			test.modifyUser(3, "Test4changed@gmail.com");
			c.printCache();
			d.printData();
			test.modifyUser(10, "Test4changed@gmail.com");
			c.printCache();
			d.printData();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}
