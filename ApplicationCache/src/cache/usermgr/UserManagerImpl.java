package cache.usermgr;

import cache.db.DBStoreImpl;
import cache.exception.CacheException;
import cache.impl.CacheManager;
import cache.impl.LRUCache.Node;
import cache.model.User;

public class UserManagerImpl implements UserManager {

	// if user details is not found then create a user in db first
	// then put in cache
	public void createUser(User user) {
		DBStoreImpl d = new DBStoreImpl();
		try {
			if (d.isUserExist(user.getId()) == null) {
				if (user.getName() != null && !(d.getUserList().contains(user))) {
					d.addToDB(user);
					System.out.println("Added User to DB");
					CacheManager.getCacheInstance().put(user.getId(), user);
				} else {
					throw new CacheException("user already exist");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// get from cache otherwise get from DB
	// then update to cache
	public User searchUser(int id) {
		try {
			DBStoreImpl d = new DBStoreImpl();
			User u = CacheManager.getCacheInstance().get(id);
			if (u != null) {
				return u;
			} else if (d.getUserList().contains(u)) {
				User u1 = d.getUserList().get(id);
				return u1;
			} else {
				throw new CacheException("User not found");
			}
		} catch (CacheException e) {
			System.out.println(e);
			return null;
		}
	}

	// delete from cache and db both return success else return false
	public synchronized boolean deleteUser(int userId) {
		DBStoreImpl d = new DBStoreImpl();
		boolean flag = false;
		try {
			User user = d.isUserExist(userId);
			if (user != null) {
				d.removeFromDB(user);
				System.out.println("user is deleted from db");
				flag = true;
				if (CacheManager.getCacheInstance().contains(userId)) {
					Node<Integer, User> n = CacheManager.getCacheInstance().getNode(userId);
					CacheManager.getCacheInstance().remove(n);
					System.out.println("user is deleted from cache");
				}
			}
			if (!flag) {
				throw new CacheException("User is not present anywhere to delete");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}

//if user does not exist then do nothing else modify value in db & remove existing 
//	value from cache if exist & insert  into cache
	public synchronized void modifyUser(int userId, String emailId) {
		DBStoreImpl d = new DBStoreImpl();
		User user = d.isUserExist(userId);
		try {
			if (user != null) {
				user.setEmailId(emailId);
				if (CacheManager.getCacheInstance().contains(userId)) {
					Node<Integer, User> n = CacheManager.getCacheInstance().getNode(userId);
					CacheManager.getCacheInstance().remove(n);
					System.out.println("user is deleted from cache");
				}
				CacheManager.getCacheInstance().put(userId, user);
				System.out.println("user is added in the cache in the front");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
