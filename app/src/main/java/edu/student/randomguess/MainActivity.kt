package edu.student.randomguess

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var number = ((Math.random () * 100001) + 1) .toInt ()
        Toast.makeText (this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show ()
        val txtGuess = findViewById<EditText>(R.id.txtGuess)
        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnToast = findViewById<Button>(R.id.btnToast)
        btnGuess.setOnClickListener {
            hideKeyboard()
            if (txtGuess.text.toString() == "") {
                Toast.makeText(this, "Please enter a number.", Toast.LENGTH_LONG).show()
                txtGuess.setText("")
            }
            else if (number == txtGuess.text.toString (). toInt ()) {
                Toast.makeText(this, "Correct, great job remembering.", Toast.LENGTH_LONG).show()
                txtGuess.setText("")
            }
            else {
                Toast.makeText(this, "Incorrect, that's not the number shown.", Toast.LENGTH_LONG)
                    .show()
                txtGuess.setText("")
            }
        }
        btnToast.setOnClickListener{
            hideKeyboard()
            number = ((Math.random () * 100001) + 1) .toInt ()
            println(number)
            Toast.makeText (this, "Number to remember: ${number}", Toast.LENGTH_LONG) .show ()
        }


        hideKeyboard()
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false

        }
    }

    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }
}
