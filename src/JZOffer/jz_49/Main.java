package JZOffer.jz_49;

/**
 * 剑指 Offer 49. 丑数
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class Main {
}

/**
 * @author caoPhoenix
 * @date 2020/9/15
 * 执行用时: 3 ms
 * 内存消耗: 37.9 MB
 * https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
 * 动归
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Integer.min(n2, Integer.min(n3, n5));
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}