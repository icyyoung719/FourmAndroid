package com.icyyoung.fourm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.icyyoung.fourm.R
import com.icyyoung.fourm.ui.activity.ShowPostDetail
import com.icyyoung.fourm.ui.activity.ShowUsers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 直接通过 findViewById 获取按钮并设置点击监听器
        val buttonShowPostDetail = findViewById<Button>(R.id.buttonShowPostDetail)
        buttonShowPostDetail.setOnClickListener {
            val intent = Intent(this, ShowPostDetail::class.java).apply {
                putExtra(ShowPostDetail.EXTRA_POST_ID, 1) // Replace with actual post ID
            }
            startActivity(intent)
        }
        // 显示用户列表按钮
        val buttonShowUsers = findViewById<Button>(R.id.buttonShowUsers)
        buttonShowUsers.setOnClickListener {
            val intent = Intent(this, ShowUsers::class.java)
            startActivity(intent)
        }
    }
}