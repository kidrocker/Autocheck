package ke.kiura.autocheck.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ke.kiura.autocheck.R
import ke.kiura.autocheck.databinding.FragmentDetailBinding
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.ui.common.BaseFragment
import ke.kiura.autocheck.ui.detail.tabs.PagerAdapter

@AndroidEntryPoint
class DetailFragment : BaseFragment() {

    private val viewModel: DetailViewModel by viewModels()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var adapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        viewModel.getCar(args.carId)
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
        viewModel.detail.removeObservers(this)
    }

    private fun subscribeObservers() {
        viewModel.detail.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading ->
                    binding.progressBar.showProgress(true)
                is Resource.Failure -> {
                    binding.progressBar.showProgress(false)
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    binding.progressBar.showProgress(false)
                    val detail = response.data
                    binding.detail = detail

                    // we need to initialize pager only when data loads
                    adapter = PagerAdapter(this, detail)
                    binding.pager.adapter = adapter
                    TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
                        tab.text = when (position) {
                            1 -> "Media"
                            else -> "Info"
                        }
                    }.attach()

                }
            }
        }
    }


}