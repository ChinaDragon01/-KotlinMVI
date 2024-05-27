pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs"){
            from(files("${rootDir.path}/libs.versions.toml"))
        }

    }
}

rootProject.name = "KotlinMVI"
include(":app")
include(":baselib")
