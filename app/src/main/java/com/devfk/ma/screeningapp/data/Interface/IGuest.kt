package com.devfk.ma.screeningapp.data.Interface

import com.devfk.ma.screeningapp.data.Model.DataGuest

interface IGuest {
    fun onGuestList(listGuest: ArrayList<DataGuest>)
    fun onDataError(throwable: Throwable)
}