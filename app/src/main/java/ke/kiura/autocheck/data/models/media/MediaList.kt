package ke.kiura.autocheck.data.models.media

import com.google.gson.annotations.SerializedName
import ke.kiura.autocheck.data.models.Pagination

data class MediaList(
    @SerializedName("carMediaList") var carMediaList: List<Media>,
    @SerializedName("pagination") var pagination: Pagination?
)
