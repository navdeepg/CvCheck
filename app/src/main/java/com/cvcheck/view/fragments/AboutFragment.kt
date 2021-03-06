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
import com.cvcheck.db.entity.AboutMe
import com.cvcheck.viewmodel.AboutViewModel
import kotlinx.android.synthetic.main.item_about_me.*
import kotlinx.android.synthetic.main.item_user_info.*

/**
 * Fragment ot show brief information about employee.
 */
class AboutFragment : Fragment() {
    private lateinit var mViewModel: AboutViewModel
    private lateinit var mDataBind: FragmentAboutBinding
    private val circleCrop = CircleCrop()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProviders.of(this)[AboutViewModel::class.java]

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mDataBind = inflate(inflater, R.layout.fragment_about, container, false)
        setHasOptionsMenu(true)
        mDataBind.lifecycleOwner = viewLifecycleOwner
        mDataBind.vm = mViewModel
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)
        setProfileImage()
        return mDataBind.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        (activity as AppCompatActivity).setSupportActionBar(mDataBind.toolbar)
        (activity as AppCompatActivity).supportActionBar?.title = getString(R.string.aboutMe)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun setProfileImage() {
        val drawable = getResources().getDrawable(R.drawable.profile);
        Glide.with(mDataBind.userInfoLayout.ivImage).load(drawable).transform(circleCrop)
            .into(mDataBind.userInfoLayout.ivImage)
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
