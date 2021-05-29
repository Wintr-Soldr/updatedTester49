package com.example.tester49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tester49.fragments.AdminFragment
import com.example.tester49.fragments.DeptFragment
import com.example.tester49.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    
    private val homeFragment= HomeFragment()
    private val deptFragment=DeptFragment()
    private val adminFragment= AdminFragment()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)
        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_home->replaceFragment(homeFragment)
                R.id.ic_admin->replaceFragment(adminFragment)
                R.id.ic_dept->replaceFragment(deptFragment)
            }
            true


        }


    }
    
    private fun replaceFragment(fragment: Fragment)
    {
        if(fragment!=null)
        {
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}