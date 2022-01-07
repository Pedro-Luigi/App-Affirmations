package com.meu.affirmations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meu.affirmations.adapter.ItemAdapter
import com.meu.affirmations.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializa os dados.
        val myDataset = Datasource().loadAffirmations()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        /**Use esta configuração para melhorar o desempenho se você souber que as mudanças
        no conteúdo, não altere o tamanho do layout do RecyclerView **/
        recyclerView.setHasFixedSize(true)
    }
}