package JZOffer.jz_42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-1};
        System.out.println(new Solution().maxSubArray(nums));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/6
 * 执行用时：1 ms, 在所有 Java 提交中击败了99.36% 的用户
 * 内存消耗：46.4 MB, 在所有 Java 提交中击败了62.22% 的用户
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) sum = nums[i];
            else {
                sum += nums[i];
            }
            max = Integer.max(max, sum);
        }
        return max;
    }
}