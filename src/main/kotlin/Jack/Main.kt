package Jack

import Jack.api.RepoService

fun main(args: Array<String>) {
    val repoService = RepoService()
    var repos = repoService.successfulRepoResponse()
    print(repos)
}