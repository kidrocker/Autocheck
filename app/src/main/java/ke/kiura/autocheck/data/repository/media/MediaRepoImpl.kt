package ke.kiura.autocheck.data.repository.media

import ke.kiura.autocheck.data.models.media.MediaList
import ke.kiura.autocheck.network.BaseApiResponse
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MediaRepoImpl(private val retrofitService: RetrofitService) : BaseApiResponse(), MediaRepo {
    override fun getMedia(id: String): Flow<Resource<MediaList>> {
        return flow {
            emit(Resource.Loading)
            emit(handleApiCall { retrofitService.getMedia(id)})
        }.flowOn(Dispatchers.IO)
    }
}