package problem.medium.p33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new Solution().search(nums, target));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/2
 * 执行用时：1 ms, 在所有 Java 提交中击败了16.81% 的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了43.83% 的用户
 * 【二分】变种。先搜索出旋转数组最小值，再在两边二分。
 */
class Solution {
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        if (nums[min] > target) return -1;
        int l = min, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        if (nums[l] == target) return l;
        l = 0;
        r = min - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        if (nums[l] == target) return l;
        return -1;
    }

    // p153.
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}