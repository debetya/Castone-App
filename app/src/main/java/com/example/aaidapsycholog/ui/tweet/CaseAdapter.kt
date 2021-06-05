package com.example.aaidapsycholog.ui.tweet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.databinding.ItemsCaseListBinding

class CaseAdapter : RecyclerView.Adapter<CaseAdapter.CaseViewHolder>() {

    private val listCase = ArrayList<TwitterUserResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaseViewHolder {
        val binding = ItemsCaseListBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return CaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CaseViewHolder, position: Int) {
        holder.bind(listCase[position])
    }

    override fun getItemCount(): Int {
        return listCase.size
    }

    class CaseViewHolder (private val binding: ItemsCaseListBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(case: TwitterUserResponse){
            with(binding){
                tvUsername.text = case.screenName
            }
        }
    }

    fun setCase(case: ArrayList<TwitterUserResponse>){
        this.listCase.clear()
        this.listCase.addAll(case)
        notifyDataSetChanged()
    }
}