package ke.kiura.autocheck.data.repository.detail

import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.Flow

interface DetailRepo {

    fun getCar(id:String):Flow<Resource<Detail>>
}