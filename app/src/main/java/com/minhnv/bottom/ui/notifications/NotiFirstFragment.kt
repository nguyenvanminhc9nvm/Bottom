package com.minhnv.bottom.ui.notifications

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minhnv.bottom.R

class NotiFirstFragment : Fragment() {

    companion object {
        fun newInstance() = NotiFirstFragment()
    }

    private lateinit var viewModel: NotiFirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.noti_first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotiFirstViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
