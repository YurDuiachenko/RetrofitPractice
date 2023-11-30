package X

import X.api.NewService
import X.models.New

import kotlinx.coroutines.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer


suspend fun main(){
    run();
}

suspend fun run() = runBlocking {
    val service = NewService()

    var format = Json { prettyPrint = true }

    coroutineScope {
        launch(Dispatchers.IO) {
            var repos: List<New> = service.successfulRepoResponse()

            for(el in repos){
                println(format.encodeToString(serializer(),  el))
            }
        }
    }
}

//fun main() {
//
//
//    var format = Json { prettyPrint = true }
//    var repoService = RepoService()
//    var repos: List<Repo> = repoService.successfulRepoResponse()
//
//    for(el in repos){
//        println( format.encodeToString(serializer(),  el))
//    }
//}]