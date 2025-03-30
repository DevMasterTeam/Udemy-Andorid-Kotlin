package com.devmasterteam.mybooks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devmasterteam.mybooks.databinding.ItemBookBinding
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.ui.listener.BookListener
import com.devmasterteam.mybooks.ui.viewholder.BookViewHolder

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {

    // Lista de livros
    private var bookList: List<BookEntity> = listOf()
    private lateinit var bookListener: BookListener

    /**
     * Cria e retorna um novo ViewHolder para o item do RecyclerView.
     *
     * Este método é chamado quando o RecyclerView precisa criar um novo item para ser exibido.
     * O layout do item é inflado e um novo ViewHolder é retornado, associado ao listener de interação com o item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        // Infla o layout do item do RecyclerView
        val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(view, bookListener)
    }

    /**
     * Este método é chamado para determinar quantos itens existem no RecyclerView.
     * Ele retorna o tamanho da lista de livros que será exibida.
     */
    override fun getItemCount(): Int {
        return bookList.size
    }

    /**
     * Vincula os dados do livro ao ViewHolder correspondente.
     * */
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }

    /**
     * Atualização da lista de convidados
     */
    fun updateBooks(list: List<BookEntity>) {
        bookList = list
        notifyDataSetChanged()
    }

    /**
     * Eventos na listagem
     */
    fun attachListener(listener: BookListener) {
        bookListener = listener
    }
}