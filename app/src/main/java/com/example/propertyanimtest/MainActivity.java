package com.example.propertyanimtest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View liulangdashi;
    private View gaibangbangzhu;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liulangdashi = findViewById(R.id.liulangdashi);
        gaibangbangzhu = findViewById(R.id.gaibangbangzhu);
        bt = (Button)findViewById(R.id.bt);
    }


    public void startFirstAnimation(View v){
        /**
         * 1）liulangdashi动画：1.翻转动画；2.透明度动画；3.缩放动画
         */
        //1.翻转
        ObjectAnimator firstRotationAnim = ObjectAnimator.ofFloat(liulangdashi, "rotationX", 0f,25f);
        firstRotationAnim.setDuration(300);
//		firstRotationAnim.start();
        //2.透明度
        ObjectAnimator firstAlphaAnim = ObjectAnimator.ofFloat(liulangdashi, "alpha", 1f,0.5f);
        firstAlphaAnim.setDuration(200);
        //3.缩放动画
        ObjectAnimator firstScaleXAnim = ObjectAnimator.ofFloat(liulangdashi, "scaleX", 1f,0.8f);
        firstScaleXAnim.setDuration(300);
        ObjectAnimator firstScaleYAnim = ObjectAnimator.ofFloat(liulangdashi, "scaleY", 1f,0.8f);
        firstScaleYAnim.setDuration(300);
        //改正向旋转设置监听，执行完毕后再执行反向旋转
//		firstRotationAnim.addUpdateListener(listener)
        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(liulangdashi, "rotationX",25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200);//延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(liulangdashi, "translationY",0f, -0.1f*liulangdashi.getHeight());
        firstTranslationAnim.setDuration(200);
        //第二个View执行平移动画--网上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(gaibangbangzhu, "translationY",gaibangbangzhu.getHeight(), 0f);
        secondeTranslationAnim.setDuration(200);
        secondeTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                gaibangbangzhu.setVisibility(View.VISIBLE);
                bt.setClickable(false);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(firstRotationAnim,firstAlphaAnim,firstScaleXAnim,firstScaleYAnim,firstResumeRotationAnim,firstTranslationAnim,secondeTranslationAnim);
        set.start();
    }

    public void startSecondAnimation(View v){
        /**
         * 1）liulangdashi动画：1.翻转动画；2.透明度动画；3.缩放动画
         */
        //1.翻转
        ObjectAnimator firstRotationAnim = ObjectAnimator.ofFloat(liulangdashi, "rotationX", 0f,25f);
        firstRotationAnim.setDuration(300);
//		firstRotationAnim.start();
        //2.透明度
        ObjectAnimator firstAlphaAnim = ObjectAnimator.ofFloat(liulangdashi, "alpha",0.5f, 1f);
        firstAlphaAnim.setDuration(200);
        //3.缩放动画
        ObjectAnimator firstScaleXAnim = ObjectAnimator.ofFloat(liulangdashi, "scaleX",0.8f, 1f);
        firstScaleXAnim.setDuration(300);
        ObjectAnimator firstScaleYAnim = ObjectAnimator.ofFloat(liulangdashi, "scaleY",0.8f, 1f);
        firstScaleYAnim.setDuration(300);
        //改正向旋转设置监听，执行完毕后再执行反向旋转
//		firstRotationAnim.addUpdateListener(listener)
        ObjectAnimator firstResumeRotationAnim = ObjectAnimator.ofFloat(liulangdashi, "rotationX",25f, 0f);
        firstResumeRotationAnim.setDuration(200);
        firstResumeRotationAnim.setStartDelay(200);//延迟执行
        //由于缩放造成了离顶部有一段距离，需要平移上去
        ObjectAnimator firstTranslationAnim = ObjectAnimator.ofFloat(liulangdashi, "translationY", -0.1f*liulangdashi.getHeight(),0f);
        firstTranslationAnim.setDuration(200);
        //第二个View执行平移动画--网上平移
        ObjectAnimator secondeTranslationAnim = ObjectAnimator.ofFloat(gaibangbangzhu, "translationY", 0f,gaibangbangzhu.getHeight());
        secondeTranslationAnim.setDuration(300);
        secondeTranslationAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                gaibangbangzhu.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                bt.setClickable(true);
            }

        });

        AnimatorSet set = new AnimatorSet();
        set.playTogether(firstRotationAnim,firstAlphaAnim,firstScaleXAnim,firstScaleYAnim,firstResumeRotationAnim,firstTranslationAnim,secondeTranslationAnim);
        set.start();
    }
}
