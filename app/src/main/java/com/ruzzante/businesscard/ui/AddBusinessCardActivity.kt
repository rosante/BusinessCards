package com.ruzzante.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ruzzante.businesscard.App
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.data.BusinessCard
import com.ruzzante.businesscard.data.BusinessCardDao
import com.ruzzante.businesscard.data.BusinessCardRepository
import kotlinx.android.synthetic.main.activity_add_business_card.*

class AddBusinessCardActivity : AppCompatActivity() {

    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_business_card)
        insertListeners()
    }

    private fun insertListeners(){
        btn_close_add_card.setOnClickListener {
            finish()
        }
        btn_save_card.setOnClickListener{
            mainViewModel.insert(BusinessCard(
                nome= tie_nome.text.toString(),
                nomeEmpresa= tie_nome_empresa.text.toString(),
                email= tie_mail.text.toString(),
                telefone= tie_telefone.text.toString(),
                corFundo= tie_color.text.toString()
            ))
            finish()
        }
    }
}