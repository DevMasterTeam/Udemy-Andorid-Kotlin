package com.devmasterteam.mybooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devmasterteam.mybooks.R
import com.devmasterteam.mybooks.databinding.FragmentFavoriteBinding
import com.devmasterteam.mybooks.helper.BookConstants
import com.devmasterteam.mybooks.ui.adapter.BookAdapter
import com.devmasterteam.mybooks.ui.listener.BookListener
import com.devmasterteam.mybooks.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FavoriteViewModel by viewModels()
    private val adapter: BookAdapter = BookAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        // Atribui um layout que diz como a RecyclerView se comporta
        binding.recyclerFavoriteBooks.layoutManager = LinearLayoutManager(context)

        // Define um adapater - Faz a ligação da RecyclerView com a listagem de itens
        binding.recyclerFavoriteBooks.adapter = adapter

        // Atribui implementação de listener
        attachBookListener()

        // Cria os observadores
        setObservers()

        // Retorna elemento raiz
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Associa o listener de eventos de clique ao adapter de livros.
     * O listener captura os cliques no título do livro para navegar até a tela de detalhes e o
     * clique no ícone de favorito para alternar o status de favorito do livro.
     */
    private fun attachBookListener() {
        adapter.attachListener(object : BookListener {
            override fun onClick(id: Int) {

                // Passando a informação do livro para a Fragment
                val bundle = Bundle()
                bundle.putInt(BookConstants.KEY.BOOK_ID, id)

                // Inicializa fragment de detalhes
                findNavController().navigate(R.id.navigation_book_details, bundle)
            }

            override fun onFavorite(id: Int) {
                viewModel.favorite(id)
            }
        })
    }

    /**
     * Cria os observadores
     */
    private fun setObservers() {
        viewModel.bookList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                showNoBooksViews(true)
            } else {
                showNoBooksViews(false)
                adapter.updateBooks(it)
            }
        }
    }

    /**
     * Controla a visibilidade dos elementos da UI relacionados a livros favoritos.
     * Exibe ou oculta a mensagem e imagem de "sem livros" e a RecyclerView de livros favoritos,
     * com base no valor de "show".
     */
    private fun showNoBooksViews(show: Boolean) {
        binding.textviewNoBooks.visibility = if (show) View.VISIBLE else View.INVISIBLE
        binding.imageviewNoBooks.visibility = if (show) View.VISIBLE else View.INVISIBLE
        binding.recyclerFavoriteBooks.visibility = if (show) View.INVISIBLE else View.VISIBLE
    }
}