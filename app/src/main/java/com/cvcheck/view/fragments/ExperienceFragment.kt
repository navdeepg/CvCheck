package com.cvcheck.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.cvcheck.R
import com.cvcheck.databinding.FragmentAboutBinding
import com.cvcheck.databinding.FragmentExperienceBinding
import com.cvcheck.db.entity.AboutMe
import com.cvcheck.viewmodel.AboutViewModel
import com.cvcheck.viewmodel.ExperienceViewModel
import kotlinx.android.synthetic.main.item_about_me.*
import kotlinx.android.synthetic.main.item_user_info.*

/**
 * Fragment to show experience of employee.
 */
class ExperienceFragment : Fragment() {
    private lateinit var mViewModel: ExperienceViewModel
    private lateinit var mDataBind: FragmentExperienceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)[ExperienceViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mDataBind = inflate(inflater, R.layout.fragment_experience, container, false)
        setHasOptionsMenu(true)
        mDataBind.lifecycleOwner = viewLifecycleOwner
        mDataBind.vm = mViewModel
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)

        return mDataBind.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.experience)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    companion object {
        val TAG = ExperienceFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = ExperienceFragment()
    }
}
