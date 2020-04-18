package com.devfk.ma.screeningapp.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import com.devfk.ma.screeningapp.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initialization()
    }

    private fun initialization() {
        btn_next.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_next -> nextPage(edtName.text)
        }
    }

    private fun nextPage(text: Editable?) {
        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("nama",text.toString())
        startActivity(intent)
    }
}
