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
    var listenerDelete: (View) -> Unit = {}
    var listenerEnableDelete: (View) -> Unit = {}

    inner class ViewHolder(private val binding: ItemBusinessCardBinding)
     : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BusinessCard){
            binding.tvId.text = " ${item.id.toString()}"
            binding.tvNome.text = " ${item.nome}"
            binding.tvEmail.text = " ${item.email}"
            binding.tvTelefone.text = " ${item.telefone}"
            binding.tvNomeEmpresa.text = " ${item.nomeEmpresa}"
            binding.tvNome.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_contact, 0, 0, 0);
            binding.tvTelefone.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_phone, 0, 0, 0);
            binding.tvEmail.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_mail, 0, 0, 0);
            binding.tvNomeEmpresa.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_company, 0, 0, 0);
            binding.cardBusinessCard.setCardBackgroundColor(parseColor(item.corFundo))
            binding.cardBusinessCard.setOnClickListener {listenerShare(it)}
            binding.imgDelete.setOnClickListener {listenerDelete(binding.cardBusinessCard)}
            binding.cardBusinessCard.setOnLongClickListener {listenerEnableDelete(it); true}
        }

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