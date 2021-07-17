package problem.medium.p866;

/**
 * 866. 回文素数
 * https://leetcode-cn.com/problems/prime-palindrome/
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().primePalindrome(9989900));
    }
}

/**
 * @author caoPhoenix
 * @date 2020/8/27
 * 超时了
 */
class Solution {
    public int primePalindrome(int N) {
        int res = N;
        while (res < 2e8) {
            if (isPalindrome(res) && isPrime(res)) return res;
            res++;
        }
        return 0;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        int i = 2;
        while (i * i <= n) {
            if (n / i * i == n) return false;
            i++;
        }
        return true;
    }

    public boolean isPalindrome(int n) {
        int reverse = 0, src = n;
        while (src > 0) {
            reverse = reverse * 10 + src % 10;
            src /= 10;
        }
        return reverse == n;
    }
}