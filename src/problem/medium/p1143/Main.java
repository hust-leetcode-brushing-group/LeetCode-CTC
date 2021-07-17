package problem.medium.p1143;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Main {
    public static void main(String[] args) {
        String text1 = "hofubmnylkra", text2 = "pqhgxgdofcvmr";
        System.out.println(new Solution().longestCommonSubsequence(text1,
                text2));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/27
 * 执行用时：17 ms, 在所有 Java 提交中击败了14.26% 的用户
 * 内存消耗：43.5 MB, 在所有 Java 提交中击败了42.24% 的用户
 * 【动态规划】
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[len1][len2];
    }
}
