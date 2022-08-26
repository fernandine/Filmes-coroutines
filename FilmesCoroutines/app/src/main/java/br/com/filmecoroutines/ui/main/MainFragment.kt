package br.com.filmecoroutines.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import br.com.filmecoroutines.R

@Suppress("DEPRECATION")
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this,
            MainViewModel.mainViewModelFactory(MainRepository())
            ).get(MainViewModel::class.java)

        viewModel.filmesLiveData.observe(viewLifecycleOwner, Observer { filmes ->
            textViewFilmes.text = filmes[0].titulo
        })
            viewModel.getFilmesCoroutines()
    }

}