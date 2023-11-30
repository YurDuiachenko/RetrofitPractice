package X.api

import com.fasterxml.jackson.databind.ObjectMapper
import X.errors.ErrorResponse
import X.models.New
import okhttp3.ResponseBody

class NewService {

    private val retrofit = RetrofitClient.getClient()
    private val reposApi = retrofit.create(NewApi::class.java)

    suspend fun successfulRepoResponse(): List<New> {
        val reposResponse = reposApi.getRepos()
        println(reposResponse.isSuccessful)
        println(reposResponse.code())
        println(reposResponse.message())

        val body: List<New> = reposResponse.body()!!
        return body
    }


    suspend fun errorUsersResponse() {
        val usersResponse = reposApi.getRepos()

        val errorBody: ResponseBody? = usersResponse.errorBody()

        val mapper = ObjectMapper()
        val mappedBody: ErrorResponse? = errorBody?.let { notNullErrorBody ->
            mapper.readValue(notNullErrorBody.toString(), ErrorResponse::class.java)
        }
    }

    suspend fun headersUsersResponse() {
        val usersResponse = reposApi.getRepos()

        val headers = usersResponse.headers()
        val customHeaderValue = headers["custom-header"]
    }
}