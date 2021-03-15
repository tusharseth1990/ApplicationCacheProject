package cache.impl;

import cache.impl.LRUCache.Node;

public interface Cache<K,V> {
	
	 void remove(Node<K, V> node);
	 V get(K key);
	 void put(K key, V value);
	 void flush();
	 boolean contains(K key);
	 void printCache();
	 Node<K,V> getNode(K key);
	 void offerNode(Node<K, V> node);
	 void modify(K key, V value);
}
