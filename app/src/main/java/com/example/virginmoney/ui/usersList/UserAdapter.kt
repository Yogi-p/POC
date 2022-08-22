package com.example.virginmoney.ui.usersList

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.models.User
import com.example.virginmoney.utils.common.inflate
import com.example.virginmoney.utils.common.loadFromUrl
import empty
import kotlinx.android.synthetic.main.row_user.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class UserAdapter @Inject constructor() : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    internal var collection: List<User> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (User) -> Unit = {_ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_user))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User, clickListener: (User) -> Unit) {
            itemView.avatar.loadFromUrl(user.avatar)
            itemView.name.text = user.firstName + String.empty() + user.lastName
            itemView.jobTitle.text = user.jobtitle
            itemView.email.text = user.email
            itemView.setOnClickListener {
                clickListener(user)
            }
        }
    }
}
