package com.devmasterteam.mybooks.ui

import android.app.AlertDialog
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devmasterteam.mybooks.R
import com.devmasterteam.mybooks.databinding.FragmentDetailsBinding
import com.devmasterteam.mybooks.viewmodel.DetailsViewModel

class DetailsFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: DetailsViewModel by viewModels()

    // ID de referência do livro em questão
    private var bookId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        // Busca ID recebido por Bundle e carega informações
        bookId = arguments?.getInt("bookId") ?: 0
        viewModel.getBook(bookId)

        // Atribui os eventos
        setListeners()

        // Cria os observadores
        setObservers()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Eventos de click
     * */
    override fun onClick(v: View) {
        if (v.id == R.id.button_delete) {
            handleBookRemoval()
        } else if (v.id == R.id.imageview_back) {
            requireActivity().supportFragmentManager.popBackStack()
        } else if (v.id == R.id.checkbox_favorite) {
            handleToggleFavorite()
        }
    }

    /**
     * Atribui os eventos
     * */
    private fun setListeners() {
        binding.buttonDelete.setOnClickListener(this)
        binding.imageviewBack.setOnClickListener(this)
        binding.checkboxFavorite.setOnClickListener(this)
    }

    /**
     * Cria os observadores
     */
    private fun setObservers() {
        viewModel.book.observe(viewLifecycleOwner) {
            binding.apply {
                textviewTitle.text = it.title
                textviewAuthorValue.text = it.author
                textviewGenreValue.text = it.genre
                checkboxFavorite.isChecked = it.favorite

                setGenreBackgroundColor(it.genre)
            }
        }

        viewModel.bookDeleted.observe(viewLifecycleOwner) {
            // Notifica usuário
            Toast.makeText(
                context,
                getString(R.string.msg_removed_successfully),
                Toast.LENGTH_SHORT
            ).show()

            // Volta para a Fragment anterior
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    /**
     * Exibe um diálogo de confirmação para a remoção de um livro.
     * Se o usuário confirmar, o livro será removido.
     */
    private fun handleBookRemoval() {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(getString(R.string.dialog_message_delete_item))
            .setPositiveButton(getString(R.string.dialog_positive_button_yes)) { dialog, id ->
                viewModel.delete(bookId)
            }
            .setNegativeButton(getString(R.string.dialog_negative_button_no)) { dialog, id ->
                dialog.dismiss()
            }
        builder.create().show()
    }

    /**
     * Alterna o status de favorito de um livro.
     * Se o livro for marcado como favorito, ele será desmarcado e vice-versa.
     */
    private fun handleToggleFavorite() {
        viewModel.favorite(bookId)
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
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_red)
            }

            "Fantasia" -> {
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_fantasy)
            }

            else -> {
                binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_teal)
            }
        }
    }

}