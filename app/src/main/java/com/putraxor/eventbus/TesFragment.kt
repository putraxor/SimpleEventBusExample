package com.putraxor.eventbus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.main.fragment_tes.*

/**
 * Created by putraxor on 21/03/17.
 */

class TesFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tes, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSend.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        //register event bus pada saat state resume
        EventBus.getDefault().register(this)
    }

    override fun onPause() {
        super.onPause()
        //unregister event bus jika state masuk ke pause
        EventBus.getDefault().unregister(this)
    }

    /**
     * Method untuk menangani event data yang diterima dari activity
     */
    fun onEvent(eventDataActivity: EventDataActivity){
        textViewReceive.text = "Diterima event data dari activity [${eventDataActivity.data}]"
    }

    override fun onClick(v: View) {
        //Saat tombol kirim di klik, kirim teks ke activity
        val dataTeks = edittextData.text.toString()
        EventBus.getDefault().post(EventDataFragment(dataTeks))
    }
}
