package com.devmasterteam.mybooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.devmasterteam.mybooks.R
import com.devmasterteam.mybooks.databinding.ItemBookBinding
import com.devmasterteam.mybooks.entity.BookEntity
import com.devmasterteam.mybooks.ui.listener.BookListener

class BookViewHolder(private val item: ItemBookBinding, private val listener: BookListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
        item.textviewAuthor.text = book.author
        item.textviewGenre.text = book.genre

        // Tratamento para categoria específica
        setGenreBackgroundColor(book.genre)

        // Tratamento para imagem de favorito
        updateFavoriteIcon(book.favorite)

        // Evento de click para detalhes
        item.textviewTitle.setOnClickListener { listener.onClick(book.id) }
        item.textviewAuthor.setOnClickListener { listener.onClick(book.id) }

        // Evento de favoritar
        item.imageviewFavorite.setOnClickListener { listener.onFavorite(book.id) }
    }

    /**
     * Tratamento para imagem de favorito
     * */
    private fun updateFavoriteIcon(favorite: Boolean) {
        val favoriteIcon = if (favorite) R.drawable.ic_favorite else R.drawable.ic_favorite_empty
        item.imageviewFavorite.setImageResource(favoriteIcon)
    }

    /**
     * Define a cor de fundo do texto que representa o gênero do livro.
     * A cor é atribuída com base no tipo de gênero do livro.
     *
     * - Para o gênero "Terror", a cor de fundo será vermelha.
     * - Para o gênero "Fantasia", será usado um gradiente de fundo específico.
     * - Para outros gêneros, a cor de fundo será teal (verde escuro).
     */
    private fun setGenreBackgroundColor(genre: String) {
        when (genre) {
            "Terror" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_red)
            }

            "Fantasia" -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy)
            }

            else -> {
                item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_teal)
            }
        }
    }
}