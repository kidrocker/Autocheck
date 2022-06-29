package ke.kiura.autocheck.data.repository.landing

import ke.kiura.autocheck.data.models.brands.Brand
import ke.kiura.autocheck.data.models.car.Result
import ke.kiura.autocheck.network.BaseApiResponse
import ke.kiura.autocheck.network.Resource
import ke.kiura.autocheck.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LandingRepoImpl(
    private val retrofitService: RetrofitService
) : BaseApiResponse(), LandingRepo {
    override fun getCarBrands(popular: Boolean): Flow<Resource<Brand>> {
        return flow {
            emit(Resource.Loading) // show user we are loading
            emit(handleApiCall { retrofitService.getBrands(popular) })
        }.flowOn(Dispatchers.IO)
    }

    override fun getCars(): Flow<Resource<Result>> {
        return flow {
            emit(Resource.Loading)
            emit(handleApiCall { retrofitService.getCars() })
        }.flowOn(Dispatchers.IO)
    }
}