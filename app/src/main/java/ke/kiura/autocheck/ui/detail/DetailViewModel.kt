package ke.kiura.autocheck.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.data.repository.detail.DetailRepo
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repo: DetailRepo
) : ViewModel() {
    private val _detail: MutableLiveData<Resource<Detail>> = MutableLiveData()
    val detail get() = _detail

    fun getCar(id: String) {
        viewModelScope.launch {
            repo.getCar(id).collect { response ->
                _detail.value = response
            }
        }
    }

}