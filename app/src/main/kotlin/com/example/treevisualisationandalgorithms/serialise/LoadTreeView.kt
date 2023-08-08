package com.example.treevisualisationandalgorithms.serialise

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.treevisualisationandalgorithms.R


class LoadTreeView internal constructor(var mTree: ArrayList<Tree>) :
    RecyclerView.Adapter<LoadTreeView.TreeView>() {
    private var mListener: onItemClickListener? = null

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class TreeView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val treeName: TextView = itemView.findViewById(R.id.treeName)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    mListener?.onItemClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TreeView {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.tree_object, parent, false)
        return TreeView(itemView)
    }

    override fun onBindViewHolder(holder: TreeView, position: Int) {
        val tree = mTree[position]
        holder.treeName.text = tree.treeName
    }

    override fun getItemCount(): Int = mTree.size


    fun getItem(position: Int): Tree = mTree[position]

    fun setOnItemClickListener(listener: onItemClickListener?) {
        mListener = listener
    }
}