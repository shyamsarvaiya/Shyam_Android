package com.example.uicontrols

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.uicontrols.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root

        _binding!!.t1.setOnClickListener {

            /*var i = Intent(requireActivity(),MainActivity2::class.java)
            startActivity(i)*/

            var a1 = BlankFragment2()
            var fm: FragmentManager = requireFragmentManager()
            var ft: FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.frmid,a1).commit()


        }



        return view
    }
    


}