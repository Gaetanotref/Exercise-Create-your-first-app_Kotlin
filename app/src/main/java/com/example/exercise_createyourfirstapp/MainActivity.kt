package com.example.exercise_createyourfirstapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.exercise_createyourfirstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var isButtonClicked = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSwitchFragment.setOnClickListener {
            if (isButtonClicked) {
                replaceFragment(First_Fragment(), binding.fragmentContainerView2)
                replaceFragment(Second_Fragment(),binding.fragmentContainerView)
                isButtonClicked = false
            } else {
                replaceFragment(Second_Fragment(), binding.fragmentContainerView2)
                replaceFragment(First_Fragment(),binding.fragmentContainerView)
                isButtonClicked = true
            }
        }

    }

    //FUNCTION TO CHANGE FRAGMENT
    private fun replaceFragment(fragment: Fragment,container: FragmentContainerView) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(container.id, fragment)
        fragmentTransaction.commit()
    }

}