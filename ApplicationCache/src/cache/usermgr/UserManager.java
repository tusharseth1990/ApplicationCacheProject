package cache.usermgr;

import cache.model.User;

public interface UserManager {
	void createUser(User user);
	User searchUser(int id);
	boolean deleteUser(int id);
	void modifyUser(int userId,String emailId);
}
