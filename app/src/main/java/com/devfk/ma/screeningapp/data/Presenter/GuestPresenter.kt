package com.devfk.ma.screeningapp.data.Presenter

import android.content.Context
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.devfk.ma.screeningapp.data.Interface.IGuest
import com.devfk.ma.screeningapp.data.Model.DataGuest
import com.devfk.ma.screeningapp.data.Model.Guest

class GuestPresenter (context:Context){
    val GuestView = context as IGuest
    val BASE_URL =  "https://reqres.in/api/users"
    fun getDataGuest(){
        AndroidNetworking.get(BASE_URL)
            .setPriority(Priority.HIGH)
            .build()
            .getAsObject(Guest::class.java, object :
                ParsedRequestListener<Guest> {
                override fun onResponse(response: Guest) {
                    GuestView.onGuestList(response.data as ArrayList<DataGuest>)
                }
                override fun onError(error: ANError) { // handle error
                    GuestView.onDataError(error)
                }
            })
    }
}