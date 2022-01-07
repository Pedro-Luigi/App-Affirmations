package com.meu.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meu.affirmations.R
import com.meu.affirmations.model.Affirmation
/**É necessário adicionar um parâmetro ao construtor do ItemAdapter para que você possa
 transmitir a lista de afirmações ao adaptador.**/
//Adaptador para o [RecyclerView] em [MainActivity]. Exibe o objeto de dados [Affirmation].
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    /**Uma instância ViewHolder contém referências às visualizações individuais em um layout de item
    de lista**/
    /**Isso facilita a atualização da visualização de itens da lista com novos dados. Os armazenadores
    de visualização também adicionam informações que o RecyclerView usa para mover as visualizações
    pela tela de maneira eficiente.**/
                                //PRA QUE SERVE?
    /***********************************************************************************************
    // Fornece uma referência às visualizações para cada item de dados
    // Itens de dados complexos podem precisar de mais de uma visualização por item, e
    // você fornece acesso a todas as visualizações para um item de dados em um portador de visualização.
    // Cada item de dados é apenas um objeto de Afirmação.
    ***********************************************************************************************/
    class ItemViewHolder(private val view:View):RecyclerView.ViewHolder(view){
        //O próximo comando ira exibir a visualização/text da list_item.
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }
                                //ANOTAÇÕES
    /**O método onCreateViewHolder() é chamado pelo gerenciador de layout para criar novos
     * armazenadores de visualização para o RecyclerView (quando não há armazenadores de
     * visualização existentes que possam ser reutilizados). Lembre-se de que um armazenador
     * de visualização representa uma única visualização de item da lista.**/
                                //PRA QUE SERVE?
    /*********************************************************************************
     * Crie novas visualizações (invocadas pelo gerenciador de layout)
     *********************************************************************************/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        /** o adapterLayout contém uma referência para a visualização do item da lista**/
        //Um parâmetro parent, que é a visualização em grupo a que a nova visualização de item
        // da lista será anexada como filha. O RecyclerView é a visualização mãe.
        val adapterLayout= LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }
                                //ANOTAÇÕES
    /** onBindViewHolder() é chamado pelo gerenciador de layout para substituir o
     * conteúdo de uma visualização de item de lista. **/
                                //PRA QUE SERVE?
    /*********************************************************************************
     * Substitua o conteúdo de uma visualização (invocado pelo gerenciador de layout)
     **********************************************************************************/
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item= dataset[position]
        holder.textView.text= context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
                                //PRA QUE SERVE?
    /************************************************************************************
     * Retorne o tamanho do seu conjunto de dados (invocado pelo gerenciador de layout)
     ************************************************************************************/
    override fun getItemCount(): Int {
        return dataset.size
    }
}