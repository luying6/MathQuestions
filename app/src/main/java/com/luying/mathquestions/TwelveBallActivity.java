package com.luying.mathquestions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建人：luying
 * 创建时间：2017/7/18
 * 类说明：
 * 12小球三次称重找出重量差异的那个小球
 */

public class TwelveBallActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
/**
 * 1 2 3 4 5 6 7 8 9 10 11 12
 * A{1 2 3 4}       B{5 6 7 8}       C{9 10 11 12}
 *
 *  第一次    A||B
 *           A == B  C 有差异球
 *              第二次 1 2  || 9 10    如果 1 2 == 9 10  说明 11 12 有差异球
 *                                          第三次   1 || 11 如果 1 == 11 说明 12 为差异球
 *                                                          如果 1 != 11 说明 11 为差异球
 *                                    如果 1 2 != 9 10  如果 9 10 比 1 2 重说明差异球比正常球重
 *                                          第三次   9 || 10  重的那个为差异球，(反之轻也是这么求解)
 *
 *
 *
 *           A != B  C没有差异球
 *                  A > B 时
 *                      第二次称重  1 5 6 7 || 8 10 11 12
 *                          如果 左 == 右， 差异球在 2 3 4 中 ，因为A重，B都是好球，所以差异球偏重
 *                              第三次称重  2 || 3
 *                                   如果  2 == 3 说明 4 为差异球
 *                                   如果  2 != 3 两个中 重的为差异球
 *
 *
 *                          如果 左 > 右，   2 3 4 是好球，那么 要么是 1 重， 要么是 8 轻。
 *                                第三次称重 1 || 2
 *                                    如果 1 == 2 说明8轻， 8为差异球
 *                                    如果 1 != 2 说明1重， 1为差异球
 *
 *
 *                          如果 左 < 右，说明 5 6 7 里面有轻球
 *                                  第三次称重 5 || 6
 *                                      如果 1 == 2 说明 7 轻， 7是差异球
 *                                      如果 1 != 2 谁轻 谁就是差异球
 *
 *
 *                  A < B 时 和 A > B 一样称量
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */