package com.luying.mathquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建人：luying
 * 创建时间：2017/7/16
 * 类说明：
 * a + b - 9 = 4
 * +   -   -
 * c - d * e =4
 * /   *   -
 * f + g - h=4
 * ||  ||  ||
 * 4   4   4
 *
 *
 * a < 5 (4 > c/f > 0  ---> a < 5)
 * b < 14
 * a + b = 13
 * c < 16 (d < 2  e < 6  d*e < 12  ---> c < 16)
 * d < 2  (b < 14  d * e < 10  e < 6  d < 1.6 ---> d < 2)
 * e < 6
 * f < 10 (h < 6  f + g < 10  ---> g < 10)
 * g < 10 (h < 6  f + g < 10  ---> g < 10)
 * h < 6
 * e + h = 5
 *
 *
 *
 * 结果: a = 2    b = 11  c = 4   d = 1   e = 0   f = 2   g = 7   h = 5
 */

public class ResultFourActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startCalculate();
    }

    private void startCalculate() {
        for (int a = 0; a < 5; a++){
            for (int b = 0; b < 13; b++){
                if (a + b == 13){
                    for (int c = 0; c < 16; c++){
                        for (int d = 0; d < 2; d++){
                            for (int e = 0; e < 6; e++){
                                for (int f = 0; f < 10; f++){
                                    for (int g = 0; g < 10; g++){
                                        for (int h = 0; h < 6; h++){
                                            if (e + h == 5){
                                                if ((c- d*e) == 4 && (f + g - h) == 4 && f != 0 && c%f == 0 && (a + c/f) == 4  && (b - d*g) == 4)
                                                System.out.println("a"+ a +"   b"+ b + "   c"+ c+ "   d"+ d+ "   e"+ e  +"   f"+ f+ "   g"+ g+"   h"+ h);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
