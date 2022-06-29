package ke.kiura.autocheck.data.repository.detail

import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.network.BaseApiResponse
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailRepoImpl(
    private val retrofitService: RetrofitService,

):BaseApiResponse(), DetailRepo {
    override fun getCar(id: String): Flow<Resource<Detail>> {
        return flow {
            emit(Resource.Loading)
            emit(handleApiCall { retrofitService.getCar(id) })
        }.flowOn(Dispatchers.IO)
    }
}