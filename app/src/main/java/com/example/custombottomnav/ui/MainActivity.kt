package com.example.custombottomnav.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.custombottomnav.R
import com.example.custombottomnav.databinding.ActivityMainBinding
import com.example.custombottomnav.ui.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addFragment(HomeFragment.newInstance())
        binding.bottomNav.show(3)
        binding.bottomNav.add(MeowBottomNavigation.Model(0, R.drawable.ic_ankert))
        binding.bottomNav.add(MeowBottomNavigation.Model(1, R.drawable.ic_comment))
        binding.bottomNav.add(MeowBottomNavigation.Model(2, R.drawable.ic_add))
        binding.bottomNav.add(MeowBottomNavigation.Model(3, R.drawable.icperson))
        binding.bottomNav.add(MeowBottomNavigation.Model(4, R.drawable.icmessage))

        binding.bottomNav.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())
                }
                1 -> {
                    replaceFragment(MessageFragment.newInstance())
                }
                2 -> {
                    replaceFragment(AddFragment.newInstance())
                }
                3 -> {
                    replaceFragment(CommentFragment.newInstance())
                }
                4 -> {
                    replaceFragment(UserFragment.newInstance())
                }
                else -> {
                    replaceFragment(CommentFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment:Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer,fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }
}