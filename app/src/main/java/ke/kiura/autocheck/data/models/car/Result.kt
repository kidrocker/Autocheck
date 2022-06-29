package ke.kiura.autocheck.data.models.car

import com.google.gson.annotations.SerializedName
import ke.kiura.autocheck.data.models.Pagination

data class Result(
    @SerializedName("result") var result: List<Car>,
    @SerializedName("pagination") var pagination: Pagination
)