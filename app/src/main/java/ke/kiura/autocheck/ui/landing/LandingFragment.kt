package ke.kiura.autocheck.ui.landing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ke.kiura.autocheck.R
import ke.kiura.autocheck.data.models.car.Car
import ke.kiura.autocheck.databinding.FragmentLandingBinding
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.ui.common.BaseFragment
import ke.kiura.autocheck.ui.landing.brands.BrandListAdapter
import ke.kiura.autocheck.ui.landing.cars.CarListAdapter

@AndroidEntryPoint
class LandingFragment : BaseFragment(), CarListAdapter.ClickListener {
    private val viewModel: LandingViewModel by viewModels()
    private var _binding: FragmentLandingBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: BrandListAdapter
    private lateinit var carAdapter: CarListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = BrandListAdapter()
        carAdapter = CarListAdapter(this)
        _binding = FragmentLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.inflateMenu(R.menu.home_menu)
        binding.brandList.adapter = adapter
        binding.brandList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.carsList.adapter = carAdapter
        binding.carsList.layoutManager = LinearLayoutManager(context)
        viewModel.getBrands(true)
        viewModel.getCars()
    }

    private fun subscribeObservers() {
        viewModel.result.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {}
                //binding.progressBar.showProgress(true)
                is Resource.Failure -> {
                    // binding.progressBar.showProgress(false)
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    //  binding.progressBar.showProgress(false)

                    carAdapter.updateCars(response.data.result)

                }
            }
        }

        viewModel.brands.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading ->
                    binding.progressBar.showProgress(true)
                is Resource.Failure -> {
                    binding.progressBar.showProgress(false)
                    Toast.makeText(context, response.error, Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> {
                    binding.progressBar.showProgress(false)

                    adapter.updateBrands(response.data.makeList)
                }
            }
        }
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
        viewModel.result.removeObservers(this)
        viewModel.brands.removeObservers(this)
    }

    override fun clicked(car: Car) {
        val directions = LandingFragmentDirections.navigateDetail(car.id)
        findNavController().navigate(directions)
    }
}