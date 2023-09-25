package com.example.work_management

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView




class MainActivity2 : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


     lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        drawerLayout = findViewById(R.id.drawer)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.navview)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open_nav,R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
       // navigationView.setNavigationItemSelectedListener(this)


        if (savedInstanceState==null)
        {
            supportFragmentManager.beginTransaction().replace(R.id.framelayout,HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.profile)
        }

        val header = navigationView.getHeaderView(0)
        header.findViewById<ImageView>(R.id.selected_image)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            R.id.profile -> supportFragmentManager.beginTransaction()
                .replace(R.id.framelayout,HomeFragment()).commit()

            R.id.logout -> Toast.makeText(this,"LogOut Success", Toast.LENGTH_LONG).show()
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START)

        }else
        {
            onBackPressedDispatcher.onBackPressed()
        }

    }

}