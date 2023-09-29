package Jack.api

import Jack.models.Repo
import retrofit2.Call
import retrofit2.http.*

interface RepoApi {

    @GET("repos")
    fun getRepos(): Call<List<Repo>>
}