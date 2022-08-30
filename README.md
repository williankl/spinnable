https://user-images.githubusercontent.com/57682159/186269621-a521daa1-6d5e-40b2-96d1-f6e6b43b7a3c.mp4

# Spinnable

### About
Kotlin multiplatform ui library to spin components. We support `jvm` (desktop) and `Android`. Check out the wiki page for 
[Compose](https://github.com/williankl/spinnable/wiki/Compose),
[Desktop](https://github.com/williankl/spinnable/wiki/Compose) and 
[Android](https://github.com/williankl/spinnable/wiki/Android) usage!

> #### Roadmap
> * iOS support
> * Api design improvements
> * Improve performance, if needed
> * Add the option to snap on release to closest side
> * Add the option to set component rotation on demand

### Adding in your projects
Add these on `build.gradle.kts` file of the target module.
```
repositories {
  mavenCentral()
}

dependencies {
  implementation("io.github.williankl.spinnable:spinnable-core:$spinnableVersion")
}
```
