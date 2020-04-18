package com.devfk.ma.screeningapp.ui.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.devfk.ma.screeningapp.R
import com.devfk.ma.screeningapp.data.Interface.IGuest
import com.devfk.ma.screeningapp.data.Model.DataGuest
import com.devfk.ma.screeningapp.data.Presenter.GuestPresenter
import com.devfk.ma.screeningapp.ui.Adapter.GuestAdapter
import kotlinx.android.synthetic.main.activity_guest.*
import kotlinx.android.synthetic.main.app_bar.*

class GuestActivity : AppCompatActivity(), AdapterView.OnItemClickListener ,IGuest{
    var resultName:String =""
    var resultAge:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest)
        initialization()
    }

    private fun initialization() {
        headerText.text = resources.getString(R.string.appBar_guest)
        GuestPresenter(this).getDataGuest()
        loadview.visibility = View.VISIBLE
        gridView.onItemClickListener = this
    }
    override fun onBackPressed() {
        if(resultName.isNotEmpty()){
            sendDataBack()
        }
        super.onBackPressed()
    }

    private fun sendDataBack() {
        val intent = Intent().apply {
            putExtra("guestName",resultName)
            putExtra("guestAge",resultAge.toString())
        }
        setResult(Activity.RESULT_OK,intent)
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var item: DataGuest = parent?.getItemAtPosition(position) as DataGuest
        resultName = item.firstName + item.lastName
        resultAge = item.id
        onBackPressed()
    }

    override fun onGuestList(listGuest: ArrayList<DataGuest>) {
        gridView.adapter = GuestAdapter(listGuest)
        loadview.visibility = View.GONE
    }

    override fun onDataError(throwable: Throwable) {
        Toast.makeText(this,"Error: $throwable",Toast.LENGTH_LONG).show()
    }
}
