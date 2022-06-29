package ke.kiura.autocheck.ui.detail.tabs.media

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ke.kiura.autocheck.data.models.media.MediaList
import ke.kiura.autocheck.data.repository.media.MediaRepo
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MediaViewModel
@Inject constructor(
    private val repo: MediaRepo
) : ViewModel() {
    private val _mediaList: MutableLiveData<Resource<MediaList>> = MutableLiveData()
     val mediaList get() = _mediaList

    fun getMedia(id: String) {
        viewModelScope.launch {
            repo.getMedia(id).collect {
                _mediaList.value = it
            }
        }
    }
}