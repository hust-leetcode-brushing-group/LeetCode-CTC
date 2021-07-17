package problem.easy.p852;

/**
 * 852. 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 0};
        System.out.println(new Solution().peakIndexInMountainArray(arr));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/9
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：40.3 MB, 在所有 Java 提交中击败了16.03% 的用户
 * 【二分】变种
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < arr[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}