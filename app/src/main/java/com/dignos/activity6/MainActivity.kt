package com.dignos.activity6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.dignos.activity6.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.okAndCancel.setOnClickListener { okAndCancelDialog() }
        binding.datePickerDialog.setOnClickListener { datePickerDialog() }
        binding.timePickerDialog.setOnClickListener { timePickerDialog() }
    }

    private fun okAndCancelDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert!!!")
        builder.setMessage("Retard alert!!!")
        builder.setPositiveButton("OK") { dialogInterface, _ ->
            // Handle the "Yes" response here
            Toast.makeText(this, "You said Yes", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("CANCEL") { dialogInterface, _ ->
            // Handle the "No" response here
            Toast.makeText(this, "You said No", Toast.LENGTH_SHORT).show()
            dialogInterface.dismiss()
        }
        builder.show()
    }

    private fun datePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(this, selectedDate, Toast.LENGTH_SHORT).show()
            }, year, month, day)

        datePickerDialog.show()
    }
    private fun timePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                Toast.makeText(this, selectedTime, Toast.LENGTH_SHORT).show()
            }, hour, minute, true)

        timePickerDialog.show()
    }
}