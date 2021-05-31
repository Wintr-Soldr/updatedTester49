package com.example.tester49

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.tester49.fragments.AdminFragment
import com.example.tester49.fragments.DeptFragment
import com.example.tester49.fragments.HomeFragment
import com.example.tester49.fragments.NotificationFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar.*


class MainActivity : AppCompatActivity() {
    
    private val homeFragment= HomeFragment()
   //Dept Fragment is Project Fragment
    // admin fragment is team fragment
    private val adminFragment= AdminFragment()// team
    private val notificationFragment=NotificationFragment()
    private val followupsFragment=com.example.tester49.fragments.followupsFragment()


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)
        val toolbar:androidx.appcompat.widget.Toolbar=findViewById(R.id.hometoolbar)
        setSupportActionBar(toolbar)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home->replaceFragment(homeFragment)
                R.id.ic_admin->replaceFragment(adminFragment)
                R.id.ic_followups->replaceFragment(followupsFragment)
                R.id.ic_notifications->replaceFragment(notificationFragment)

                R.id.ic_dept->startActivity(Intent(this,Projects::class.java))

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