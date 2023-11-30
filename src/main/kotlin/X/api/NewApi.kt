package X.api

import X.models.New
import retrofit2.Response
import retrofit2.http.*

interface NewApi {
    @GET("/new/search/all?q=США")
    suspend fun getRepos(): Response<List<New>>
}