package com.example.cobaan

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity: Button = findViewById(R.id.button)
        btnMoveActivity.setOnClickListener(this)


        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)


        val btnDialPhone:Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnActivityFragment: Button = findViewById(R.id.fragment)
        btnActivityFragment.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                val moveIntent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Laila Izmi Women")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 5)
                startActivity(moveWithDataIntent)
            }

            R.id.btn_dial_number -> {
                val phoneNumber = "081210841382"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.fragment ->{
                val fragment = Intent(this@MainActivity, FragmentActivity::class.java)
                startActivity(fragment)
            }
        }
    }
}