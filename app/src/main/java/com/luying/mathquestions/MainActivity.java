package com.luying.mathquestions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * 创建人：luying
 * 创建时间：2017/7/15
 * 类说明：
 * 1 2 3 7 8 9 5 6 4        1 2 3 7 8 9 5 6 4       1 2 3 7 8 9 5 6 4       1 2 3 8 9 7 5 6 4       1 2 3 8 9 7 5 6 4       1 2 3 8 9 7 5 6 4       1 2 9 8 3 7 5 6 4
 * 4 8 5 6 3 1 2 9 7        4 8 5 6 3 1 2 9 7       4 8 5 6 3 1 2 9 7       4 8 5 6 3 1 2 9 7       4 8 5 6 3 1 2 9 7       4 8 5 6 3 1 2 9 7       4 8 5 6 9 1 2 3 7
 * 7 6 9 4 5 2 1 8 3        7 6 9 4 5 2 1 8 3       7 6 9 4 5 2 1 8 3       7 6 9 4 5 2 1 8 3       7 6 9 4 5 2 1 8 3       7 6 9 4 5 2 1 8 3       7 6 3 4 5 2 1 8 9
 * 3 1 2 9 4 6 8 7 5        3 1 2 9 4 6 8 7 5       3 1 2 9 4 6 8 7 5       3 1 2 9 4 6 8 7 5       3 1 2 9 4 6 8 7 5       3 1 2 9 4 6 8 7 5       3 1 2 9 4 6 8 7 5
 * 6 5 7 3 1 8 9 4 2        6 5 7 3 1 8 9 4 2       6 5 7 3 2 8 9 4 1       6 5 7 3 1 8 9 4 2       6 5 7 3 1 8 9 4 2       6 5 7 3 2 8 9 4 1       6 5 7 3 1 8 9 4 2
 * 8 9 4 2 7 5 6 3 1        8 9 4 2 7 5 6 3 1       8 9 4 1 7 5 6 3 2       8 9 4 2 7 5 6 3 1       8 9 4 2 7 5 6 3 1       8 9 4 1 7 5 6 3 2       8 9 4 2 7 5 6 1 3
 * 2 7 8 1 6 3 4 5 9        2 7 8 5 6 3 4 1 9       2 7 8 5 6 3 4 1 9       2 7 8 1 6 3 4 5 9       2 7 8 5 6 3 4 1 9       2 7 8 5 6 3 4 1 9       2 7 8 5 6 3 4 9 1
 * 9 3 6 5 2 4 7 1 8        9 3 6 1 2 4 7 5 8       9 3 6 2 1 4 7 5 8       9 3 6 5 2 4 7 1 8       9 3 6 1 2 4 7 5 8       9 3 6 2 1 4 7 5 8       9 3 6 1 2 4 7 5 8
 * 5 4 1 8 9 7 3 2 6        5 4 1 8 9 7 3 2 6       5 4 1 8 9 7 3 2 6       5 4 1 7 8 9 3 2 6       5 4 1 7 8 9 3 2 6       5 4 1 7 8 9 3 2 6       5 4 1 7 8 9 3 2 6
 */
public class MainActivity extends AppCompatActivity {
    private int[][] quesition = {
            {0, 2, 0, 0, 0, 0, 5, 0, 4},
            {0, 0, 0, 6, 0, 0, 0, 0, 0},
            {0, 0, 0, 4, 5, 0, 1, 8, 0},
            {0, 0, 2, 0, 0, 0, 0, 7, 0},
            {0, 5, 0, 3, 0, 8, 0, 4, 0},
            {0, 9, 0, 0, 0, 0, 6, 0, 0},
            {0, 7, 8, 0, 6, 3, 0, 0, 0},
            {9, 3, 0, 0, 0, 4, 0, 0, 0},
            {5, 0, 1, 0, 0, 0, 0, 2, 0}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backTrace(0, 0);
    }

    /**
     * 数独算法
     * @param i 行号
     * @param j 列号
     */
    private void backTrace(int i, int j) {
        if (i == 8 && j == 9) {
            printArray();
            return;
        }else if (i != 8 && j == 9){
            //换行
            i++;
            j = 0;
        }

        if (quesition[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (check(i, j, k)) {
                    quesition[i][j] = k;
                    backTrace(i, j + 1);
                    quesition[i][j] = 0;
                }
            }
        } else {
            backTrace(i, j + 1);
        }
    }


    private boolean check(int line, int column, int number) {
        for (int i = 0; i < 9; i++) {
            if (quesition[line][i] == number || quesition[i][column] == number) {
                return false;
            }
        }
        int tempLine = line / 3;
        int tempColumn = column / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (quesition[tempLine * 3 + i][tempColumn * 3 + j] == number) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 打印矩阵
     */
    public void printArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(quesition[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
