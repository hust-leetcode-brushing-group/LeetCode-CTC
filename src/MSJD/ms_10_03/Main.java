package MSJD.ms_10_03;

/**
 * 面试题 10.03. 搜索旋转数组
 * https://leetcode-cn.com/problems/search-rotate-array-lcci/
 */
public class Main {
    public static void main(String[] args) {
        //int[] nums = new int[]{5, 5, 5, 1, 2, 3, 4, 5};
        //int target = 5;
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1};
        int target = 2;

        System.out.println(new Solution().search(nums, target));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/2
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：40.5 MB, 在所有 Java 提交中击败了86.62% 的用户
 * 【二分】p154. + 搜索边界的变种。p33.的进阶版
 */
class Solution {
    public int search(int[] arr, int target) {
        int l = 0;
        while (l < arr.length - 1 && arr[l] == arr[arr.length - 1]) l++;

        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[r]) l = mid + 1;
            else r = mid;
        }
        int min = l;

        System.out.println(min);
        if (arr[min] > target) return -1;
        l = 0;
        r = min - 1;
        // 二分搜索左边界
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else if (arr[mid] < target) l = mid + 1;
        }
        if (arr[l] == target) return l;
        l = min;
        r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) r = mid;
            else if (arr[mid] < target) l = mid + 1;
        }
        if (arr[l] == target) return l;
        return -1;
    }
}

