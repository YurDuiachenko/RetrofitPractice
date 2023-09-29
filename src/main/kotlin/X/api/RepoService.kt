package X.api

import com.fasterxml.jackson.databind.ObjectMapper
import X.errors.ErrorResponse
import X.models.Repo
import okhttp3.OkHttpClient
import okhttp3.ResponseBody

class RepoService {

    private val retrofit = RetrofitClient.getClient()
    private val reposApi = retrofit.create(RepoApi::class.java)

    fun successfulRepoResponse(): List<Repo> {
        val reposResponse = reposApi.getRepos().execute()
        println(reposResponse.isSuccessful)
        println(reposResponse.code())
        println(reposResponse.message())

        val body: List<Repo> = reposResponse.body()!!
        return body
    }


    fun errorUsersResponse() {
        val usersResponse = reposApi.getRepos()
            .execute()

        val errorBody: ResponseBody? = usersResponse.errorBody()

        val mapper = ObjectMapper()
        val mappedBody: ErrorResponse? = errorBody?.let { notNullErrorBody ->
            mapper.readValue(notNullErrorBody.toString(), ErrorResponse::class.java)
        }
    }

    fun headersUsersResponse() {
        val usersResponse = reposApi.getRepos()
            .execute()

        val headers = usersResponse.headers()
        val customHeaderValue = headers["custom-header"]
    }
}