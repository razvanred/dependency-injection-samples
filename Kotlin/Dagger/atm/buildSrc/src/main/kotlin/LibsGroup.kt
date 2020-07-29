typealias Dependency = String

abstract class LibsGroup(
    internal val groupId: String,
    internal val version: String? = null
)

internal fun LibsGroup.dependency(artifactId: String): Dependency {
    val version = requireNotNull(version) { "Version missing" }
    return dependency(artifactId, version)
}

internal fun LibsGroup.dependency(artifactId: String, version: String): Dependency =
    dependency(groupId, artifactId, version)

internal fun dependency(groupId: String, artifactId: String, version: String): Dependency =
    "$groupId:$artifactId:$version"