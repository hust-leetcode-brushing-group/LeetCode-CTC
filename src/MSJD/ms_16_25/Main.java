package MSJD.ms_16_25;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.25. LRU缓存
 * https://leetcode-cn.com/problems/lru-cache-lcci/
 */
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/9
 * 执行用时：30 ms, 在所有 Java 提交中击败了97.91% 的用户
 * 内存消耗：48.1 MB, 在所有 Java 提交中击败了24.59% 的用户
 * 哈希表+双向链表
 */
class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = head;
        this.capacity = capacity;
        size = 0;
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) return -1;
        else {
            this.removeFromList(node);
            this.headInsert(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
            this.headInsert(node);
            map.put(key, node);
            size++;
            if (size > capacity) {
                map.remove(tail.key);
                this.removeLast();
                size--;
            }
        } else {
            node.value = value;
            this.removeFromList(node);
            this.headInsert(node);
        }
    }

    private void headInsert(Node node) {
        node.next = head.next;
        head.next = node;
        node.prev = head;
        if (node.next != null) {
            node.next.prev = node;
        } else {
            tail = node;
        }
    }

    private void removeFromList(Node node) {
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void removeLast() {
        removeFromList(tail);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */