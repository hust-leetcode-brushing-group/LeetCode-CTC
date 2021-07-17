package problem.medium.p93;


import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        String s = "1231231231234";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/9/15
 * 执行用时：11 ms, 在所有 Java 提交中击败了12.70% 的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了30.65% 的用户
 * 直接【暴力】判断所有情况
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) return res;
        for (int i = 1; i <= s.length() - 3 && i <= 3; i++) {
            for (int j = i + 1; j <= s.length() - 2; j++) {
                for (int k = j + 1; k <= s.length() - 1; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, s.length());

                    if (isSafe(a, b, c, d)) {
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return res;
    }

    public static boolean isSafe(String a, String b, String c, String d) {
        int ia = Integer.parseInt(a);
        int ib = Integer.parseInt(b);
        int ic = Integer.parseInt(c);
        int id = Integer.parseInt(d);
        if ((a.charAt(0) == '0' && a.length() != 1)
                || (b.charAt(0) == '0' && b.length() != 1)
                || (c.charAt(0) == '0' && c.length() != 1)
                || (d.charAt(0) == '0' && d.length() != 1)) return false;

        if (ia >= 0 && ia <= 255
                && ib >= 0 && ib <= 255
                && ic >= 0 && ic <= 255
                && id >= 0 && id <= 255) return true;
        return false;
    }
}