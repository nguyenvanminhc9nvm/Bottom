package com.minhnv.bottom.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minhnv.bottom.R

class HomeFirstFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFirstFragment()
    }

    private lateinit var viewModel: HomeFirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeFirstViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
