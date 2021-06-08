package com.example.aaidapsycholog.ui.tweet

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aaidapsycholog.data.response.TwitterUserResponse
import com.example.aaidapsycholog.data.response.UserCaseResponseItem
import com.example.aaidapsycholog.databinding.ItemsCaseListBinding
import com.example.aaidapsycholog.ui.detail.DetailCaseActivity

class CaseAdapter : RecyclerView.Adapter<CaseAdapter.CaseViewHolder>() {

    private val listCase = ArrayList<UserCaseResponseItem>()

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
        fun bind(case: UserCaseResponseItem){
            with(binding){
                tvUsername.text = case.screenName
                itemView.setOnClickListener{

                    val moveIntent = Intent(itemView.context, DetailCaseActivity::class.java)
                    moveIntent.putExtra(DetailCaseActivity.EXTRA_CASE, case)
                    itemView.context.startActivity(moveIntent)
                }
            }
        }
    }

    fun setCase(case: ArrayList<UserCaseResponseItem>){
        this.listCase.clear()
        this.listCase.addAll(case)
        notifyDataSetChanged()
    }

}