package X.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit

private const val BASE_URL = "https://api.github.com/users/YurDuiachenko/"
private const val BASE_TOKEN = ""

object RetrofitClient {

    var json  = Json{
        isLenient = true
        ignoreUnknownKeys = true
    }

    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(RequestInterceptor)
        .addInterceptor(AuthorizationInterceptor)
        .build()

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
            .build()

}

object RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Outgoing request to ${request.url()}")
        return chain.proceed(request)
    }
}

object AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val requestWithHeader = chain.request()
            .newBuilder()
            .header(
                "Authorization", BASE_TOKEN
            ).build()
        return chain.proceed(requestWithHeader)
    }
}