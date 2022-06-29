package ke.kiura.autocheck.data.repository.landing

import ke.kiura.autocheck.data.models.brands.Brand
import ke.kiura.autocheck.data.models.car.Result
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.Flow

interface LandingRepo {

    fun getCarBrands(popular:Boolean):Flow<Resource<Brand>>

    fun getCars():Flow<Resource<Result>>
}