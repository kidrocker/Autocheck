package ke.kiura.autocheck.network

import ke.kiura.autocheck.data.models.brands.Brand
import ke.kiura.autocheck.data.models.car.Result
import ke.kiura.autocheck.data.models.detail.Detail
import ke.kiura.autocheck.data.models.media.MediaList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {

    @GET("make")
    suspend fun getBrands(@Query("popular") popular: Boolean):Response<Brand>

    @GET("car/search")
    suspend fun getCars():Response<Result>

    @GET("car/{id}")
    suspend fun getCar(@Path("id")id:String):Response<Detail>

    @GET("car_media")
    suspend fun getMedia(@Query("carId") id: String):Response<MediaList>
}