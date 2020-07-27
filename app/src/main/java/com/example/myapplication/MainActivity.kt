package com.example.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Activity用来管理界面的生命周期和交互
         * 具体的界面需要自己配置 在res  ->layout-> .xml文件里
         * 通过setContentView来关联layout布局和代码
         * 所有的资源文件都会有一个id和它对应  要访问这些资源
         * R.layout.activity_main
         * R.drawable.1.jpg
         */

        //监听按钮被点击的事件
        //mLoginButton.setOnClickListener(this)
       /* mLoginButton.setOnClickListener (object :View.OnClickListener {
            override fun onClick(v: View?) {
            println("1.按钮被点击了")
        }
    })
        */
        /*
        mLoginButton.setOnClickListener{
            println("3.按钮被点击了")}
        mLoginButton.setOnClickListener({view:View?->
            println("4.按钮被点击了")
        })*/
       mLoginButton.setOnClickListener {
            //添加旋转动画，动画结束之后再跳转到下一个界面
            //旋转 平移 缩放 透明度
           //apply就是直接在对象内部使用代码块,可以访问这个对象本身的属性和方法
           ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f).apply {
               duration =100
               repeatCount=6
               start()
               addListener(object :MyAnimatorListener(){
                   override fun onAnimationEnd(animation: Animator?) {
                       startActivity(Intent(this@MainActivity,DeatailAvtivity::class.java))
                   }
               })

           }

           /**
          val animator= ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f)
            animator.duration=100
            animator.repeatCount=6
            animator.start()
            //监听动画的结束事件
            animator.addListener(object :Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    //界面跳转
                    startActivity(Intent(this@MainActivity,DeatailAvtivity::class.java))
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })

        }*/
       /** ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f).also {
            it.duration=100
            it.repeatCount=6
            it.start()
            it.addListener(object :Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    //界面跳转
                    startActivity(Intent(this@MainActivity,DeatailAvtivity::class.java))
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })*/
        }
    }




    override fun onClick(v: View?) {
        println("2.按钮被点击了")
    }
}


