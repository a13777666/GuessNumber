package com.yencheng.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yencheng.guess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    val secret = (1..100).random()
    var max=100
    var min=1
    var count = 10


    fun guess(view: View){

        binding.tvResult.visibility = View.VISIBLE
        binding.tvChances.visibility = View.VISIBLE
        binding.tvChances.text = "You have $count chances"

        var number = binding.edNumber.text.toString().toInt()

        if (number > max || number < min){
            binding.tvResult.text = "Your suck!!\nPlease enter a number($min to $max):"
            return
        }

        if (number > secret) {
            max = number
        } else if (number < secret) {
            min = number
        } else {
            binding.tvResult.text = "You got it!! The number is $secret"
        }
        binding.tvResult.text = "Please enter a number($min to $max):"
        if (count <= 0) {
            binding.tvResult.text = "Time's up !! You suck!!"
            return
        }
        count--

    }
}