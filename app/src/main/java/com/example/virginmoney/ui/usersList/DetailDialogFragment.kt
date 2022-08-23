package com.example.virginmoney.ui.usersList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.virginmoney.R
import com.example.virginmoney.databinding.FragmentDetailsDialogBinding
import com.example.virginmoney.models.User
import com.example.virginmoney.utils.common.loadFromUrl
import dagger.hilt.android.AndroidEntryPoint
import empty
import kotlinx.android.synthetic.main.fragment_details_dialog.view.*

@AndroidEntryPoint
class DetailDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentDetailsDialogBinding
    companion object {
        const val TAG = "DetailDialogFragment"
        private const val KEY_TITLE = "KEY_TITLE"
        private const val KEY_AVATAR = "KEY_AVATAR"
        private const val KEY_JOBTITLE = "KEY_JOBTITLE"
        private const val KEY_EMAIL = "KEY_EMAIL"
        private const val KEY_FAV_COLOR = "KEY_FAV_COLOR"

        fun newInstance(user: User): DetailDialogFragment {
            val args = Bundle()
            args.putString(KEY_AVATAR, user.avatar)
            args.putString(KEY_TITLE, user.firstName + String.empty() + user.lastName)
            args.putString(KEY_JOBTITLE, user.jobtitle)
            args.putString(KEY_EMAIL, user.email)
            args.putString(KEY_FAV_COLOR, user.favouriteColor)
            val fragment = DetailDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.fragment_details_dialog, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupClickListeners(view)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    private fun setupView() {
        binding.avatar.loadFromUrl(arguments?.getString(KEY_AVATAR))
        binding.name.text = String.format(getString(R.string.placeholder_name),  arguments?.getString(KEY_TITLE))
        binding.jobTitle.text = String.format(getString(R.string.placeholder_name), arguments?.getString(KEY_JOBTITLE))
        binding.email.text = String.format(getString(R.string.placeholder_name) , arguments?.getString(KEY_EMAIL))
        binding.color.text = String.format(getString(R.string.placeholder_name) , arguments?.getString(KEY_FAV_COLOR))
    }

    private fun setupClickListeners(view: View) {
        view.ok.setOnClickListener {
            // TODO: Do some task here
            dismiss()
        }
    }

}
