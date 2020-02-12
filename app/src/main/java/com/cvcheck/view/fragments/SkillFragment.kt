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
import com.cvcheck.databinding.FragmentSkillBinding
import com.cvcheck.view.adapter.SkillsAdapter
import com.cvcheck.viewmodel.SkillViewModel

/**
 * Fragment to show skills of employee.
 */
class SkillFragment : Fragment() {
    private lateinit var mViewModel: SkillViewModel
    private lateinit var mDataBind: FragmentSkillBinding
    private var mAdapter: SkillsAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)[SkillViewModel::class.java]
        observerVm()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mDataBind = inflate(inflater, R.layout.fragment_skill, container, false)
        setHasOptionsMenu(true)
        mDataBind.lifecycleOwner = viewLifecycleOwner
        mDataBind.vm = mViewModel
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)

        return mDataBind.root
    }

    //Observe any changes in live data
    private fun observerVm(){
        mViewModel.skillLiveData.observe(this, Observer {
            mAdapter = SkillsAdapter(it.skills)
            mDataBind.rvSkill.adapter = mAdapter
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.skills)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    companion object {
        val TAG = SkillFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = SkillFragment()
    }
}
