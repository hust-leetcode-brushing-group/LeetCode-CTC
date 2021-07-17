package problem.hard.p154;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Main {
    public static void main(String[] args) {
        //int[] nums = new int[]{2, 2, 3, 4, 2, 2, 2, 2};
        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1};
        System.out.println(new Solution().findMin(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/9
 * 执行用时：3 ms, 在所有 Java 提交中击败了40.72% 的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了71.54% 的用户
 * 【二分】p153.进阶，有重复值
 * 把左侧的重复值从搜索区间去掉，这样返回的一定是旋转点
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        while (l < nums.length - 1 && nums[l] == nums[nums.length - 1]) l++;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //System.out.println(nums[mid]);
            if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        System.out.println(l);
        return nums[l];
    }
}


/**
 * @author caoPhoenix
 * @date 2020/9/2
 * 执行用时：4 ms, 在所有 Java 提交中击败了40.71% 的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了19.12% 的用户
 * 【二分】p153.进阶，有重复值
 * 返回的不一定是旋转点
 */
class Solution_1 {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //System.out.println(nums[mid]);
            if (nums[mid] > nums[r]) l = mid + 1;
            else if (nums[mid] < nums[r]) r = mid;
            else r -= 1;
        }
        System.out.println(l);
        return nums[l];
    }
}