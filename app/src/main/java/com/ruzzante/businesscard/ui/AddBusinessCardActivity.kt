package com.ruzzante.businesscard.ui

import android.graphics.Color.parseColor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.doOnLayout
import androidx.core.widget.doBeforeTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruzzante.businesscard.App
import com.ruzzante.businesscard.R
import com.ruzzante.businesscard.data.BusinessCard
import com.ruzzante.businesscard.data.BusinessCardDao
import com.ruzzante.businesscard.data.BusinessCardRepository
import com.ruzzante.businesscard.model.BackgroundColor
import kotlinx.android.synthetic.main.activity_add_business_card.*
import kotlinx.android.synthetic.main.activity_main.*

class AddBusinessCardActivity : AppCompatActivity() {

    private val mainViewModel:MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_business_card)
        configureRecyclerViewColors()
        insertListeners()
    }

    private fun insertListeners(){
        btn_close_add_card.setOnClickListener {
            finish()
        }
        btn_save_card.setOnClickListener{
            if (!tie_nome.text.toString().isNullOrBlank() && !tie_color.text.toString().isNullOrBlank()){
                mainViewModel.insert(BusinessCard(
                    nome= tie_nome.text.toString(),
                    nomeEmpresa= tie_nome_empresa.text.toString(),
                    email= tie_mail.text.toString(),
                    telefone= tie_telefone.text.toString(),
                    corFundo= tie_color.text.toString()
                ))
                finish()
            }else{
                val toast = Toast.makeText(this, "Insira os Valores Corretamente", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.TOP,0, 40)
                toast.show()
            }
        }


        tie_color.setOnClickListener{
            group_color.visibility = View.VISIBLE
            btn_save_card.visibility = View.INVISIBLE
        }

    }
    private fun configureRecyclerViewColors(){
        group_color.visibility = View.INVISIBLE
        recycler_view_colors.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view_colors.adapter = BackgroundColorAdapter(BackgroundColor.getColors()){changeColor(it)}
    }
    private fun changeColor(colorHexa:String){
        tie_color.setText(colorHexa)
        btn_save_card.setBackgroundColor(parseColor(colorHexa))
        group_color.visibility = View.INVISIBLE
        btn_save_card.visibility = View.VISIBLE
    }

}