package ke.kiura.autocheck.ui.detail.tabs.media

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ke.kiura.autocheck.R
import ke.kiura.autocheck.core.DefaultConfig
import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.databinding.FragmentCarMediaBinding
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.ui.common.BaseFragment
import ke.kiura.autocheck.ui.detail.tabs.PagerAdapter


@AndroidEntryPoint
class CarMediaFragment : BaseFragment() {
    private var detail: Detail? = null
    private var _binding:FragmentCarMediaBinding? = null
    private val binding get() = _binding!!
    private val viewModel:MediaViewModel by viewModels()
    private lateinit var adapter: MediaListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = MediaListAdapter()
        _binding = FragmentCarMediaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(DefaultConfig.PARAM_DETAIL) }?.apply {
            detail = getSerializable(DefaultConfig.PARAM_DETAIL) as Detail
        }

        binding.mediaList.adapter = adapter
        binding.mediaList.layoutManager = LinearLayoutManager(context)

        detail?.id?.let { viewModel.getMedia(it) }

    }
    override fun onResume() {
        super.onResume()
        subscribeObservers()
    }

    override fun onPause() {
        super.onPause()
        unsubscribeObservers()
    }

    private fun unsubscribeObservers() {
        viewModel.mediaList.removeObservers(this)
    }

    private fun subscribeObservers() {
        viewModel.mediaList.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading ->
                    binding.progressBar.showProgress(true)
                is Resource.Failure -> {
                    binding.progressBar.showProgress(false)
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    binding.progressBar.showProgress(false)
                    adapter.updateMedia(response.data)
                }
            }
        }
    }
}