package cache.impl;

import java.util.concurrent.ConcurrentHashMap;

import cache.model.User;

public final class LRUCache<K, V> implements Cache<K, V> {

	public static class Node<K, V> {
		private V value;
		private K key;
		private Node<K, V> next;
		private Node<K, V> prev;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}

	private final int maxCapacity;

	private ConcurrentHashMap<K, Node<K, V>> map;

	private Node<K, V> head;

	private Node<K, V> tail;

	public LRUCache(int maxCapacity) {
		this(16, maxCapacity);
	}

	public LRUCache(int initialCapacity, int maxCapacity) {
		this.maxCapacity = maxCapacity;
		if (initialCapacity > maxCapacity)
			initialCapacity = maxCapacity;
		map = new ConcurrentHashMap<>(initialCapacity);
	}
	
	@Override
	public boolean contains(K key) {
	 if(map.containsKey(key)) {
		 return true;
	 }
	 else {
		 return false;
	 }
	}

	public void printCache() {
		Node<K, V> curr = head;
		while (curr != null) {
			Object o = curr.value;
			User user;
			if(o instanceof User) {
				user = (User) o;
				System.out.println(user.getId() + user.getEmailId());
			}
			
			curr = curr.next;
		}
		System.out.println();
	}
	
	
	public void remove(Node<K, V> node) {
		if (node == null)
			return;

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	public void offerNode(Node<K, V> node) {
		if (node == null)
			return;
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = node;
		}
	}

	public void put(K key, V value) {
		if (map.contains(key)) {
			Node<K, V> node = map.get(key);
			node.value = value;
			remove(node);
			offerNode(node);
		} else {
			if (map.size() == maxCapacity) {
				System.out.println("maxCapacity of cache reached");
				map.remove(head.key);
				remove(head);
			}

			Node<K, V> node = new Node<>(key, value);
			offerNode(node);
			map.put(key, node);
		}
	}


	@Override
	public void flush() {
		map.clear();		
	}
	
	
	public void modify(K key, V value) {
		if (map.contains(key)) {
			Node<K, V> node = map.get(key);
			node.value = value;
			remove(node);
			offerNode(node);
		}
	}
	
	
	public V get(K key) {
		Node<K, V> node = map.get(key);
		remove(node);
		offerNode(node);
		return node != null ? node.value : null;
	}

	
	public Node<K,V> getNode(K key) {
		Node<K, V> node = map.get(key);
		remove(node);
		offerNode(node);
		return node;
	}


}