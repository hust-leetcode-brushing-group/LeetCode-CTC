package JZOffer.jz_12;

/**
 * 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class Main {
}

/**
 * @author caoPhoenix
 * @date 2020/8/28
 * 执行用时：7 ms, 在所有 Java 提交中击败了44.64% 的用户
 * 内存消耗：42 MB, 在所有 Java 提交中击败了21.85% 的用户
 * 【DFS】
 */
class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m, n;
        if ((m = board.length) == 0 || (n = board[0].length) == 0)
            return false;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, visited, i, j, 1, word))
                        return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, boolean[][] visited, int x, int y, int len,
                String word) {
        if (len == word.length()) return true;
        int tx, ty;
        for (int i = 0; i < 4; i++) {
            tx = x + dx[i];
            ty = y + dy[i];
            if (tx >= 0 && tx < visited.length
                    && ty >= 0 && ty < visited[0].length
                    && !visited[tx][ty]
                    && board[tx][ty] == word.charAt(len)) {
                visited[tx][ty] = true;
                if (dfs(board, visited, tx, ty, len + 1, word))
                    return true;
                visited[tx][ty] = false;
            }
        }
        return false;
    }
}