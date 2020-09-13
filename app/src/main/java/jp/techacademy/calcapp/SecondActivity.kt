package jp.techacademy.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val value3 = intent.getIntExtra("VALUE3", 0)

        Log.d("UI_PARTS",value1.toString())
        if(value3==1) {
            textView2.text = "${value1 + value2}"
        }else if(value3==2){
            textView2.text = "${value1 - value2}"
        }else if(value3==3){
            textView2.text = "${value1 * value2}"
        }else if(value3==4){
            textView2.text = "${value1 / value2}"
        }
    }
}
