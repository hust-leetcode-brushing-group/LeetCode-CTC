package problem.hard.p1095;

/**
 * 1095. 山脉数组中查找目标值
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 */
public class Answer {
}


interface MountainArray {
    public int get(int index);

    public int length();
}

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

/**
 * @author caoPhoenix
 * @date 2020/9/9
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了5.59% 的用户
 * 【二分】p852.找出峰顶，再在两边搜索
 */
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek = peakIndexInMountainArray(mountainArr);
        if (mountainArr.get(peek) < target) return -1;
        if (mountainArr.get(peek) == target) return peek;
        int l = 0, r = peek - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) return mid;
            else if (mountainArr.get(mid) < target) r = mid - 1;
            else if (mountainArr.get(mid) > target) l = mid + 1;
        }
        if (mountainArr.get(l) == target) return l;

        l = peek + 1;
        r = mountainArr.length() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) == target) return mid;
            else if (mountainArr.get(mid) > target) r = mid - 1;
            else if (mountainArr.get(mid) < target) l = mid + 1;
        }
        if (mountainArr.get(l) == target) return l;
        return -1;
    }

    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}