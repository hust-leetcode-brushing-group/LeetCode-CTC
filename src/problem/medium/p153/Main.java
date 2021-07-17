package problem.medium.p153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 6, 7};
        System.out.println(new Solution().findMin(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/2
 * 执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
 * 内存消耗：39.5 MB, 在所有 Java 提交中击败了43.96% 的用户
 * 【二分】常见变种
 */
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //System.out.println(nums[mid]);
            if (nums[mid] > nums[r]) l = mid + 1;
            else if (nums[mid] < nums[r]) r = mid;
        }
        return nums[l];
    }
}