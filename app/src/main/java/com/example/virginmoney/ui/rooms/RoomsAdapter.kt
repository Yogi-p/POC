package com.example.virginmoney.ui.rooms

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoney.R
import com.example.virginmoney.models.Rooms
import com.example.virginmoney.models.User
import com.example.virginmoney.utils.common.inflate
import com.example.virginmoney.utils.common.loadFromUrl
import kotlinx.android.synthetic.main.row_room.view.*
import kotlinx.android.synthetic.main.row_user.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class RoomsAdapter @Inject constructor() : RecyclerView.Adapter<RoomsAdapter.ViewHolder>() {

    internal var collection: List<Rooms> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_room))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(room: Rooms) {
            itemView.room_no.text = "Room Number : " + room.id
            itemView.max_occupancy.text = "Max. Occupancy : " + room.maxOccupancy.toString()
            itemView.occupied.text = "Occupied: " + if(room.isOccupied) "Yes" else "NO"
        }
    }
}
