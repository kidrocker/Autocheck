package ke.kiura.autocheck.ui.landing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel
import ke.kiura.autocheck.data.models.brands.Brand
import ke.kiura.autocheck.data.models.car.Car
import ke.kiura.autocheck.data.models.car.Result
import ke.kiura.autocheck.data.repository.landing.LandingRepo
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingViewModel @Inject constructor(
    private val repo: LandingRepo
) : ViewModel() {
    private val _result: MutableLiveData<Resource<Result>> = MutableLiveData()
    val result get() = _result

    private val _brands: MutableLiveData<Resource<Brand>> = MutableLiveData()
    val brands get() = _brands

    fun getBrands(popular: Boolean) {
        viewModelScope.launch {
            repo.getCarBrands(popular).collect { response ->
                _brands.value = response
            }
        }
    }

    fun getCars(){
        viewModelScope.launch {
            repo.getCars().collect { resp->
                _result.value = resp
            }
        }
    }
}