package com.example.myapplication

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    var requestQueue: RequestQueue? = null
    var url = "http://test.redappletech.info/apiuser/register"
    var editTextTextPersonName3: EditText? = null
    var editTextTextPersonName33: EditText? = null
    var editTextTextPersonName333: EditText? = null
    var button: TextView? = null
    var imageView3: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(applicationContext)
        editTextTextPersonName3 = findViewById<EditText>(R.id.editTextTextPersonName3)
        editTextTextPersonName33 = findViewById<EditText>(R.id.editTextTextPersonName33)
        editTextTextPersonName333 = findViewById<EditText>(R.id.editTextTextPersonName333)
        button = findViewById(R.id.button)
        imageView3 = findViewById(R.id.imageView3)



        button?.setOnClickListener(View.OnClickListener {

            var count = 0

            if (editTextTextPersonName333?.getText()
                    .toString() == null || editTextTextPersonName333?.getText().toString() == ""
            ) {
                 count = 1
                Toast.makeText(this@MainActivity, "password is null", Toast.LENGTH_SHORT).show()
            }

            if (editTextTextPersonName33?.getText()
                    .toString() == null || editTextTextPersonName33?.getText().toString() == ""
            ) {
                 count = 1
                Toast.makeText(this@MainActivity, "username is null", Toast.LENGTH_SHORT).show()
            }
            if (editTextTextPersonName3?.getText()
                    .toString() == null || editTextTextPersonName3?.getText().toString() == ""
            ) {
                count = 1
                Toast.makeText(this@MainActivity, "email is null", Toast.LENGTH_SHORT).show()
            }
            if (isValidEmail(

                    editTextTextPersonName3?.getText().toString()
                )
            ) {
            } else {
                 count = 1
                Toast.makeText(this@MainActivity, "email is invalid", Toast.LENGTH_SHORT).show()

            }

            if (count == 0) {
                //********************************************************************************


                //********************************************************************************
                val stringRequest: StringRequest = object : StringRequest(
                    Method.POST, url,
                    Response.Listener { response ->

                        Toast.makeText(
                            this@MainActivity,
                            response,
                            Toast.LENGTH_SHORT
                        ).show()

                        Toast.makeText(
                            this@MainActivity,
                            "Registration Successful",
                            Toast.LENGTH_LONG
                        ).show()

                      /*  try {
                            val jsonArray = JSONArray(response)
                            Toast.makeText(
                                this@MainActivity,
                                response,
                                Toast.LENGTH_LONG
                            ).show()

                            for (i in 0 until jsonArray.length()) {
                                val jsonObject = jsonArray[i] as JSONObject
                                Log.i("userId", jsonObject.getString("userId"))
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }*/
                    },
                    Response.ErrorListener { error ->
                        if (error is NetworkError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Cannot connect to Internet...Please check your connection!",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (error is ServerError) {
                            Toast.makeText(
                                this@MainActivity,
                                "The server could not be found. Please try again after some time!!",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (error is AuthFailureError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Cannot connect to Internet...Please check your connection !",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (error is ParseError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Parsing error! Please try again after some time !!",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (error is NoConnectionError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Cannot connect to Internet...Please check your connection !",
                                Toast.LENGTH_LONG
                            ).show()
                        } else if (error is TimeoutError) {
                            Toast.makeText(
                                this@MainActivity,
                                "Cannot connect to Internet...Please check your connection !",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }) {
                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val parameters: MutableMap<String, String> = HashMap()
                        parameters["email"] = editTextTextPersonName333?.getText().toString()
                        parameters["username"] = editTextTextPersonName33?.getText().toString()
                        parameters["password"] = editTextTextPersonName333?.getText().toString()
                        return parameters
                    }
                }

                val requestQueue = Volley.newRequestQueue(applicationContext)
                requestQueue.add(stringRequest)

                //******************************************************************************
            }
        })


        imageView3?.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "LOGIN PAGE WAS NOT IN TEST", Toast.LENGTH_LONG)
                .show()


        })
    }

    private fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}