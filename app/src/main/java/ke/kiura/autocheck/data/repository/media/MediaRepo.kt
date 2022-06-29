package ke.kiura.autocheck.data.repository.media

import ke.kiura.autocheck.data.models.media.MediaList
import ke.kiura.autocheck.network.Resource
import kotlinx.coroutines.flow.Flow

interface MediaRepo {

    fun getMedia(id:String):Flow<Resource<MediaList>>
}