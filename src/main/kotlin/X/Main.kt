package X

import X.api.RepoService
import X.models.Repo
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.serializer

fun main(args: Array<String>) {

    var format = Json {
        prettyPrint = true
    }

    var repos: List<Repo> = RepoService().successfulRepoResponse()

    for(el in repos){
        println( format.encodeToString(serializer(),  el))
    }
}