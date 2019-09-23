package machikawa.hidemasa.techacademy.aisatsuapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DateFormat
import java.time.DayOfWeek
import java.util.*

class MainActivity : AppCompatActivity() {

    var time:DateFormat = DateFormat.getTimeInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = ""
        button1.setOnClickListener {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog(){
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                Log.d("UI_PARTS", "$hourOfDay:$minute")
                doGreetings(hourOfDay,minute)
            },
            12,0,true
        )
        timePickerDialog.show()
    }

    private fun doGreetings(hourOfDay:Int, minute:Int){
        var time:Calendar = Calendar.getInstance()
        time.set(Calendar.HOUR_OF_DAY,hourOfDay)
        time.set(Calendar.MINUTE,minute)

        when (time.get(Calendar.HOUR_OF_DAY)){
            in 2..9 -> textView.text = "おはよう☀️"
            in 10..17 -> textView.text = "こんにちは"
            else -> textView.text = "こんばんは🌙"
        }
    }
}
