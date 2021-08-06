package com.ruzzante.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ruzzante.businesscard.App
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.data.BusinessCard
import com.ruzzante.businesscard.util.Image
import kotlinx.android.synthetic.main.activity_add_business_card.*
import kotlinx.android.synthetic.main.activity_add_business_card.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_business_card.*
import kotlinx.android.synthetic.main.item_business_card.view.*
import kotlinx.android.synthetic.main.item_color.view.*
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {


    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_cards.adapter = adapter
        getAllBusinessCard()
        insertListener()

    }

    private fun insertListener(){
        btn_add_card.setOnClickListener{
            val intent = Intent(this@MainActivity, AddBusinessCardActivity::class.java )
            startActivity(intent)
        }


        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card )
        }
        adapter.listenerEnableDelete = { card ->
            if (card.img_delete.visibility == View.INVISIBLE)
                card.img_delete.visibility = View.VISIBLE
            else
                card.img_delete.visibility = View.INVISIBLE
        }
        adapter.listenerDelete = { card ->
            mainViewModel.delete(
                BusinessCard(
                    nome = card.tv_nome.text.toString(),
                    id = parseInt(card.tv_id.text.toString()),
                    email = card.tv_email.text.toString(),
                    telefone = card.tv_telefone.text.toString(),
                    nomeEmpresa = card.tv_nome_empresa.text.toString(),
                    corFundo = card.solidColor.toString()
            ))
            card.img_delete.visibility = View.INVISIBLE
        }
    }

    // recuperando informações dos cartões
    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this, { businessCards -> adapter.submitList(businessCards)})
    }

}