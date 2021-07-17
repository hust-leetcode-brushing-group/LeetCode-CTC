package JZOffer.jz_41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
 */
public class Main {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/6
 * 执行用时：90 ms, 在所有 Java 提交中击败了23.57% 的用户
 * 内存消耗：51.2 MB, 在所有 Java 提交中击败了16.86% 的用户
 * 两个【堆】
 */
class MedianFinder {

    // 保存较小一半的大顶堆
    Queue<Integer> dataMin;

    // 保存较大一半的小顶堆
    Queue<Integer> dataMax;

    /** initialize your data structure here. */
    public MedianFinder() {
        dataMin = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        dataMax = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (dataMin.size() != dataMax.size()) {
            dataMin.add(num);
            dataMax.add(dataMin.remove());
        } else {
            dataMax.add(num);
            dataMin.add(dataMax.remove());
        }
    }

    public double findMedian() {
        if (dataMin.size() == dataMax.size()) {
            return (dataMin.peek() + dataMax.peek()) / 2.0;
        } else {
            return dataMin.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */