package com.cvcheck.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cvcheck.R
import com.cvcheck.databinding.FragmentAboutBinding
import com.cvcheck.viewmodel.AboutViewModel

/**
 * Fragment ot show brief information about employee.
 */
class AboutFragment : Fragment() {
    private lateinit var mViewModel: AboutViewModel
    private lateinit var mDataBind: FragmentAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)[AboutViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mDataBind = inflate(inflater, R.layout.fragment_about, container, false)
        setHasOptionsMenu(true)
        mDataBind.lifecycleOwner = viewLifecycleOwner
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)

        return mDataBind.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.aboutMe)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val TAG = AboutFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = AboutFragment()
    }
}
