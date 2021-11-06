package com.syed.regraspingandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

     var avengerTitle:String?="Default User"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("The onCreate() callback method is called")
        setContentView(R.layout.scroll_view)

        if(intent!=null){
            title=intent.getStringExtra("Name")
        }


    }

    override fun onStart() {
        super.onStart()
        println("The onStart() callback method is called")
    }
    override fun onResume(){
        super.onResume()
        println("The onResume() callback method has been called")
    }
    override fun onPause(){
        super.onPause();
        println("The onPause() callback method has been called")
    }
    override fun onStop(){
        super.onStop()
        println("the onStop() callback method has been called")
    }
    override fun onDestroy(){
        super.onDestroy();
        println("The onDestroy() callback method has been called")

    }
    override fun onRestart(){
        super.onRestart();
        println("The onRestart() callback method has been called")
    }
}