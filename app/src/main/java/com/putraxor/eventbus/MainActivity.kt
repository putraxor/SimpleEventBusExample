package com.putraxor.eventbus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by putraxor on 21/03/17.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        //register event bus pada activity ini saat state resume
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        //unregister event bus jika state masuk ke pause
        EventBus.getDefault().unregister(this)
    }

    /**
     * Method untuk menangani event data yang diterima dari fragment
     */
    fun onEvent(evtData: EventDataFragment){
        //tampilkan event data dari fragment
        tv_event.text = "EventData dari fragment [${evtData.data}]"
        //balas kirim respon ke fragment
        EventBus.getDefault().post(EventDataActivity("Data ${evtData.data} diterima activity"))
    }
}
