package cache.impl;

import cache.model.User;
public final class CacheManager {

	private static Cache<Integer, User> cache;
	
	private CacheManager() {}
	
	 public static synchronized Cache<Integer, User> getCacheInstance() {
		
		            if(cache == null){
		             cache = new LRUCache<>(16);
		            }
		           
		    return cache;
	}
}
