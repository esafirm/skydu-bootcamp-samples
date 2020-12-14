package skydu.android.session.second.recycler

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import skydu.android.session.second.databinding.ItemKueBinding

typealias OnItemClickListener = (Int) -> Unit

class KueAdapter(private val listOfKue: List<String>) : RecyclerView.Adapter<KueViewHolder>() {

    var onItemClick: OnItemClickListener? = null
    var selectedPosition: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemKueBinding.inflate(inflater, parent, false)
        return KueViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KueViewHolder, position: Int) {
        val kue = listOfKue[position]
        holder.binding.textView.text = kue
        holder.binding.root.setOnClickListener {
            onItemClick?.invoke(position)
        }

        holder.binding.textView.setOnClickListener {
            selectedPosition = position
            notifyDataSetChanged()
        }

        if (selectedPosition == position) {
            holder.binding.textView.setTextColor(Color.RED)
        } else {
            holder.binding.textView.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int = listOfKue.size
}