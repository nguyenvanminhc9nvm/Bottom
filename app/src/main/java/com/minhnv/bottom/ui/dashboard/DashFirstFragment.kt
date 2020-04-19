package com.minhnv.bottom.ui.dashboard

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minhnv.bottom.R

class DashFirstFragment : Fragment() {

    companion object {
        fun newInstance() = DashFirstFragment()
    }

    private lateinit var viewModel: DashFirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dash_first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashFirstViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
