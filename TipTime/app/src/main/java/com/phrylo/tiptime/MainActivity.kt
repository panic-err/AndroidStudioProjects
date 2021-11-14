package com.phrylo.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.phrylo.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateTip.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        val stringInTextField = binding.costOfService.text.toString()

        val cost = stringInTextField.toDouble()

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val tipPercentage = when (selectedId) {
            R.id.good_service -> 0.10
            R.id.great_service -> 0.15
            else -> 0.20
        }
        var tip = cost * tipPercentage

        val roundUp = binding.rounding.isChecked

        if (roundUp) {
            kotlin.math.ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        binding.result.text = getString(R.string.tip_amount, formattedTip)

    }

}