package MarixArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yuehu on 8/2/19.
 * 73
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * [
 *    [1,0,1,1]
 *    [1,1,0,0]
 *    [0,1,1,1]
 *    [1,1,1,1]
 *  ]
 *
 *
 */
public class SetMatrixZeroes_73 {
    public void setZeros(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if(i == 0) row = true;
                    if(j == 0) col = true;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++ ){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < n; j++) {
            if(matrix[0][j] == 0){
                for(int i = 0; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        if(row) {
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        if(col) {
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
    public void setZeros2(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    int row = i;
                    int col = j;
                    for(int a = 0; a < m; a++){
                        matrix[a][col] = 0;
                    }

                    for(int b = 0; b < n; b++){
                        matrix[row][b] = 0;
                    }
                }

            }
        }


    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1},{1,1,1,1}, {1,1,1,1}, {1,1,1,1}};
        SetMatrixZeroes_73 s = new SetMatrixZeroes_73();
        s.setZeros2(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println(Arrays.toString(matrix[3]));

        }
    }
