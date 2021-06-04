package id.chirikualii.movie_catalog_android_jetpack_pro.utils

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

/**
 * Create by Chiriku Alii on 6/4/21
 * github.com/chirikualii
 */


fun Long.checkTimeMillis(context: Context):String{
    val defaultFormat = SimpleDateFormat("MM/dd/yyyy")
    var formatterDay = SimpleDateFormat("EEEE")
    val todayDate = SimpleDateFormat("HH:mm")
    val calYesterday = Calendar.getInstance()
    val fullFormat = SimpleDateFormat("MMMM dd, HH:mm")
    val  thisTime = this
    val currentTIme = System.currentTimeMillis()
    val interval = currentTIme- thisTime
    calYesterday.add(Calendar.DATE, -1)


    if(interval < 60000){


        return "Just Now"
    }else if(defaultFormat.format(Date((this)))== defaultFormat.format(System.currentTimeMillis())){
        val todayString = "Today"
        return "${todayString}, ${todayDate.format(Date(this))}"
    }else if(defaultFormat.format(Date(this))== defaultFormat.format(calYesterday.time)){
        val yestredayString = "Yesterday"
        return "${yestredayString}, ${todayDate.format(Date(this))}"
    }else {
        return fullFormat.format(Date((this)))
    }
}