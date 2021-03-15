package cache.usermgr;

import java.util.Iterator;
import java.util.List;

import cache.db.DBStoreImpl;
import cache.impl.CacheManager;
import cache.model.User;

public class RefreshUserCache {

	public void refreshCacheFirstTime() {
		DBStoreImpl d = new DBStoreImpl();
		List<User> users = d.getUserList();
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User u = it.next();
			CacheManager.getCacheInstance().put(u.getId(), u);
		}
	}
}
