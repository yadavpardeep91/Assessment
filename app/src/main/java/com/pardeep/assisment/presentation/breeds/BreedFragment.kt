package com.pardeep.assisment.presentation.breeds

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import com.pardeep.assisment.databinding.FragmentFirstBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.pardeep.assisment.presentation.common.extension.showToast
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class BreedFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val viewModel : BreedFragmentViewModel by viewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dogObserver()
        viewModel.getDogImage()
    }
private fun dogObserver(){
    viewModel.mState.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
        .onEach { state -> handleState(state) }
        .launchIn(viewLifecycleOwner.lifecycleScope)
}

    private fun handleState(state: CreateMainFragmentState){
        when(state){
            is CreateMainFragmentState.IsLoading -> handleLoading(state.isLoading)
            is CreateMainFragmentState.SuccessCreate -> {
             // handle with the response data
            }
            is CreateMainFragmentState.ShowToast -> requireActivity().showToast(state.message)
            is CreateMainFragmentState.Init -> Unit
        }
    }

    private fun handleLoading(isLoading: Boolean) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}