object Libs {

    object Dagger: LibsGroup("com.google.dagger", Versions.DAGGER) {
        val dagger = dependency("dagger")
        val compiler = dependency("dagger-compiler")
    }

}