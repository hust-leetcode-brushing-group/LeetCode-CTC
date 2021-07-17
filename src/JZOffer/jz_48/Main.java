package JZOffer.jz_48;

import java.util.HashSet;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 */
public class Main {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/6
 * 执行用时：10 ms, 在所有 Java 提交中击败了27.90% 的用户
 * 内存消耗：39.9 MB, 在所有 Java 提交中击败了56.51% 的用户
 * 【滑动窗口】
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0;
        int max = 0;
        HashSet<Character> win = new HashSet<>();
        while (r < s.length()) {
            if (!win.contains(s.charAt(r))) {
                win.add(s.charAt(r));
                r++;
            } else {
                while (s.charAt(l) != s.charAt(r)) {
                    win.remove(s.charAt(l++));
                }
                l++;
                r++;
            }
            max = Integer.max(max, r - l);
            //System.out.println(l + " " + r);
        }
        return max;
    }
}