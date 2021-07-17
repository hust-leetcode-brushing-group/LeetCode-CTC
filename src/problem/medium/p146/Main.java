package problem.medium.p146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 */
public class Main {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4

    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/9
 * 执行用时：21 ms, 在所有 Java 提交中击败了52.51% 的用户
 * 内存消耗：48 MB, 在所有 Java 提交中击败了51.72% 的用户
 *
 * 偷懒版本
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capaticy;

    public LRUCache(int capacity) {
        super(2 * capacity, 0.5f, true);
        this.capaticy = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capaticy;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */