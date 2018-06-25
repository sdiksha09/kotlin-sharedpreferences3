package com.example.shipra.sharedpreferences_kotlin2

import android.content.Context
import android.content.SharedPreferences
import android.icu.text.UnicodeSet.EMPTY
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.welcome_message.*

class MainActivity : AppCompatActivity() {

    private var EMPTY=""
    private  var ERROR_INPUT_EMPTY="Please fill All fields"
    private var SAVED="Saved!"
    private var myPreferences="myPref"

    private var NAME="name"
    private  var PHONE_NO="phone_number"
    private var EMAIL="email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val sharedPreferences=getSharedPreferences(myPreferences, Context.MODE_PRIVATE)

        //check if whether data is already presend in shared preferences. If so, display user details
           if (sharedPreferences.getString(NAME, EMPTY)!= EMPTY) {

               setContentView(R.layout.welcome_message)                //get all the data from sgaredpreferences
               val name = sharedPreferences.getString(NAME, EMPTY)
               val phoneNo = sharedPreferences.getString(PHONE_NO, EMPTY)
               val email = sharedPreferences.getString(EMAIL, EMPTY)


               //print data in welcome Activity


               welcome_text.text = "welcomeback\t\t" + name + "\n\nyour details are..!!"
               phone_number_display.text = "\n\nPhone No" + phoneNo
               email_display.text = "\n\nEmail Id" + email

           }

        else{
               setContentView(R.layout.activity_main)
               //if user details are not saved previusly then display the form

               //save the data in sharedpreference

               btn_submit.setOnClickListener{
                  // if the user left any field empty, show the message
                   if(edit_text_name.toString()==EMPTY ||edit_text_email.toString()==EMPTY ||edit_text_phone_number.toString()==EMPTY){
                       Toast.makeText(applicationContext, ERROR_INPUT_EMPTY, Toast.LENGTH_LONG).show()


                   }
                   else
                   {
                       // if all the fields are filled then fatch the data and save the data in sgared preference


                       val editor = sharedPreferences.edit()
                       editor.putString(NAME,edit_text_name.text.toString())
                       editor.putString(EMAIL,edit_text_email.text.toString())
                       editor.putString(PHONE_NO,edit_text_phone_number.text.toString())
                       editor.apply()

                       //clear the text box and show toast message

                       edit_text_name.setText(EMPTY)
                       edit_text_email.setText(EMPTY)
                       edit_text_phone_number.setText(EMPTY)
                       Toast.makeText(applicationContext, SAVED, Toast.LENGTH_LONG).show()



                   }



               }










        }



    }
}
