package com.pcs.apptoko

import com.pcs.apptoko.response.cart.cart

interface CallbackInterface {
    fun passResultCallback(total:String,cart:ArrayList<cart>)
}