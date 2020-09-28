package com.yogasolo.test.postures.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yogasolo.domain.postures.model.Posture
import com.yogasolo.test.R
import com.yogasolo.test.core.extensions.loadWithRoundedCorners
import kotlinx.android.synthetic.main.item_posture.view.*

class PosturesAdapter(
    private val onPostureClick: (Posture, View) -> Unit
) : RecyclerView.Adapter<PosturesAdapter.ViewHolder>() {

    private val items: MutableList<Posture> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_posture, parent, false)

        return ViewHolder(view, onPostureClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun addAll(newItems: List<Posture>) {
        val startingIndex = items.size
        items.addAll(newItems)

        notifyItemRangeInserted(startingIndex, newItems.size)
    }

    class ViewHolder(
        itemView: View,
        private val onPostureClick: (Posture, View) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(posture: Posture) {
            with(itemView) {
                text_view_posture_description.text = posture.description
                image_view_posture.loadWithRoundedCorners(posture.picture)

                setOnClickListener { onPostureClick(posture, image_view_posture) }
            }
        }
    }
}