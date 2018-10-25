/**
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 Integers in each row are sorted in ascending from left to right.
 Integers in each column are sorted in ascending from top to bottom.
 For example,
 Consider the following matrix:
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]


 Given target = 5, return true.
 Given target = 20, return false.

 */
public class FindNumInMatrix {

    int[][] m = new int[][]{
        {1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}
    };


    public boolean findNum(int[][] m, int t) {
        if(m.length == 0 || m[0].length == 0) return false;
        int x = m.length, y = m[0].length;
        int i = x - 1, j = 0;
        while(i >= 0 && j < y) {
            if(t < m[i][j]) {
                i--;
            } else if(t > m[i][j]) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }
}