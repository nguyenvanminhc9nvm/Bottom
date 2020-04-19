package com.minhnv.bottom.ui.nav

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minhnv.bottom.BlockDrawer
import com.minhnv.bottom.MainActivity

import com.minhnv.bottom.R
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {
    lateinit var block: BlockDrawer
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            block = activity as MainActivity
        }catch (e: Exception){
            throw  ClassCastException(activity.toString() + " must implement MyInterface");
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        block.lockDrawer()
    }

    override fun onDestroy() {
        super.onDestroy()
        block.unlockDrawer()
    }
}
