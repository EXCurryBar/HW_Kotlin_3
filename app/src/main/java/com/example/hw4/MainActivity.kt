package com.example.hw4

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.hw4.R

class MainActivity : AppCompatActivity() {
    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = LENGTH_SHORT
        val inflater = this.layoutInflater
        val layout = inflater.inflate(
            R.layout.custom_toast,
            findViewById<ViewGroup>(R.id.custom_toast_root)
        )
        toast.view = layout
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_list = AlertDialog.Builder(this@MainActivity)
        dialog_list.setTitle("使用LIST呈現")
        dialog_list.setItems(
            list
        ) { dialogInterface, i ->
            Toast.makeText(
                this@MainActivity,
                "你選的是" + list[i],
                LENGTH_SHORT
            ).show()
        }
        dialog_list.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<View>(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("請選擇功能")
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件")

            dialog.setNeutralButton(
                "取消"
            ) { dialogInterface, i ->
                Toast.makeText(
                    this@MainActivity,
                    "dialog關閉",
                    LENGTH_SHORT
                ).show()
            }
            dialog.setNegativeButton(
                "自訂義Toast"
            ) { dialogInterface, i -> showToast() }
            dialog.setPositiveButton(
                "顯示list"
            ) { dialogInterface, i -> showListDialog() }
            dialog.show()
        })
    }
}
