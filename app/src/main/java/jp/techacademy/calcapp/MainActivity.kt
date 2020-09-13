package jp.techacademy.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.support.v7.app.AlertDialog
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (editText1.length() == 0 || editText2.length() == 0) {
            Log.d("UI_PARTS", "未入力あり")
            showAlertDialog()
        } else{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", editText1.text.toString().toDoubleOrNull())
            intent.putExtra("VALUE2", editText2.text.toString().toDoubleOrNull())
            if (v.id == R.id.button1) {
                intent.putExtra("VALUE3", 1)
            } else if (v.id == R.id.button2) {
                intent.putExtra("VALUE3", 2)
            } else if (v.id == R.id.button3) {
                intent.putExtra("VALUE3", 3)
            } else if (v.id == R.id.button4) {
                intent.putExtra("VALUE3", 4)
            }
            startActivity(intent)

        }
    }


    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("数値を入力してください。")

        // 肯定ボタンに表示される文字列、押したときのリスナーを設定する
        alertDialogBuilder.setPositiveButton("了解" ){dialog, which ->
            Log.d("UI_PARTS", "肯定ボタン")
        }


        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}