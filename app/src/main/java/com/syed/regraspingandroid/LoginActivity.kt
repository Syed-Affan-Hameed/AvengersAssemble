package com.syed.regraspingandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity()  {
    lateinit var imgavengerlogo: ImageView
    lateinit var etmobilenum: EditText
    lateinit var etpass: EditText
    lateinit var btnlogin: Button
    lateinit var txtforgot: TextView
    lateinit var txtreg: TextView
    val validmobilenum= arrayListOf<String>("1127878221","112121221","1121214544","3321214544","3329921454","3327714544")
    val validpass= arrayListOf<String>("tonystark","capstark","romanoff","iamangry","hawkeye","jane")
    var avengerName= arrayOf("Iron Man","Captain America","Black Widow","Gladiator Hulk","HawkEye Ronin","Thor Odinson")
    var LoginStatus=false
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title = "Log in to Avengers Dashboard"
        imgavengerlogo = findViewById(R.id.imgavengerlogo)
        etmobilenum = findViewById(R.id.etmobilenum)
        etpass = findViewById(R.id.etpass)
        btnlogin = findViewById(R.id.btnlogin)
        txtforgot = findViewById(R.id.txtforgot)
        txtreg = findViewById(R.id.txtreg)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        if(LoginStatus){
            val intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
        }
        else{
            setContentView(R.layout.activity_login)
        }
        btnlogin.setOnClickListener{

            var mob=etmobilenum.text.toString()
            var pass=etpass.text.toString()

            val intent= Intent(this@LoginActivity,MainActivity::class.java)
            if((mob in validmobilenum)) // Or use validpass.contains(pass) its the same thing!!!
            {
                for(i in 0 until validpass.size){
                    if(pass==validpass[i]){
                        savepreferences()
                        intent.putExtra("Name",avengerName[i])
                        startActivity(intent)
                        finish()
                        break
                    }
                }


            }
            else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }

        }

    }

 fun savepreferences(){
     sharedPreferences.edit().putBoolean("LoginStatus",true).apply()
 }


}