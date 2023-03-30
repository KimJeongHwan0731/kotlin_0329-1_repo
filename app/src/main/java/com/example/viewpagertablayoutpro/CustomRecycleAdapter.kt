package com.example.viewpagertablayoutpro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagertablayoutpro.databinding.ItemViewBinding

class CustomRecycleAdapter(val dataList: MutableList<DataList>): RecyclerView.Adapter<CustomRecycleAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(itemViewBinding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.itemViewBinding
        itemViewBinding.tvName.text = dataList.get(position).tvName.toString()
        itemViewBinding.tvAge.text = dataList.get(position).tvAge.toString()
        itemViewBinding.tvEmail.text = dataList.get(position).tvEmail.toString()
        itemViewBinding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        itemViewBinding.root.setOnClickListener {
            Toast.makeText(itemViewBinding.root.context, "${dataList.get(position).toString()}", Toast.LENGTH_SHORT).show()
        }
        itemViewBinding.root.setOnLongClickListener(object : View.OnLongClickListener{
            override fun onLongClick(v: View?): Boolean {
                val position = holder.adapterPosition
                val deleteData = dataList.removeAt(position)
                Toast.makeText(itemViewBinding.root.context, "${deleteData.tvName} 삭제완료", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
                return true
            }
        })
    }

    class CustomViewHolder(val itemViewBinding: ItemViewBinding): RecyclerView.ViewHolder(itemViewBinding.root)
}