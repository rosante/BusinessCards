package com.ruzzante.businesscard.ui

import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.data.BusinessCard
import com.ruzzante.businesscard.databinding.ItemBusinessCardBinding
import kotlinx.android.synthetic.main.item_business_card.view.*
import java.util.zip.Inflater


class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {
    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(private val binding: ItemBusinessCardBinding)
     : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard){
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvTelefone.text = item.telefone
            binding.tvNomeEmpresa.text = item.nomeEmpresa
            binding.cardBusinessCard.setCardBackgroundColor(parseColor(item.corFundo))
            binding.cardBusinessCard.setOnClickListener {listenerShare(it)}

        }
        val textViewNome: TextView = itemView.findViewById(R.id.tv_nome)
        val textViewNomeEmpresa: TextView = itemView.findViewById(R.id.tv_nome_empresa)
        val textViewEmail: TextView = itemView.findViewById(R.id.tv_email)
        val textViewTelefone: TextView = itemView.findViewById(R.id.tv_telefone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback: DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id

}