package com.ruzzante.businesscard.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import com.ruzzante.businesscard.App
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.util.Image
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_business_card.*

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
    }

    // recuperando informações dos cartões
    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this, { businessCards -> adapter.submitList(businessCards)})
    }
}