![GitHub branch checks state](https://img.shields.io/github/checks-status/williankl/spinnable/master)
![Maven Central](https://img.shields.io/maven-central/v/io.github.williankl.spinnable/spinnable-core)
![GitHub Workflow Status](https://img.shields.io/github/workflow/status/williankl/spinnable/Project%20CI)
![GitHub](https://img.shields.io/github/license/williankl/spinnable)

https://user-images.githubusercontent.com/57682159/186269621-a521daa1-6d5e-40b2-96d1-f6e6b43b7a3c.mp4

# Spinnable

## About
Kotlin multiplatform ui library to spin components. We support `jvm` (desktop) and `Android`. Check out the wiki page for 
[Compose](https://github.com/williankl/spinnable#jetpack-compose),
[Desktop](https://github.com/williankl/spinnable#jetpack-compose) and 
[Android](https://github.com/williankl/spinnable#xml) usage!

> #### Roadmap
> * iOS support
> * Api design improvements
> * Improve performance, if needed
> * Add the option to snap on release to closest side
> * Add the option to set component rotation on demand

## Usage
### Jetpack Compose
***
```
SpinnableView(
    front: @Composable () -> Unit,
    back: @Composable () -> Unit,
    state: SpinnableState = SpinnableState.Manual.Both,
    modifier: Modifier = Modifier
)
```
#### Parameters

* `front`: Your composable content when the `Spinnable` is front facing

* `back`: Your composable content when the `Spinnable` is back facing

* `state`: Defines in what state is your `Spinnable`. The following types are available:
> `None`: No movement allowed
>
> `Manual`: It can be `Manual.Horizontal`, `Manual.Vertical` or `Manual.Both`. Each makes the component spinnable to the according axis.
>
> `Automatic`: Has the `horizontalSpeed` and `verticalSpeed`. It receives a `Float` value. `360F` makes the component spin 360 degrees per second.

***
### Xml
```
<williankl.spinnable.core.SpinnableView
    android:id="@+id/spinnable"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```

#### We have these fields to alter on the `xml` code:

* `app:state="state"`: This field can be:
> `none`: This one makes the spinnable static. Unable to move.
>
> `manual`: Comes with a combo of `app:isVerticalEnabled="boolean"` and `app:isHorizontalEnabled="boolean"`. The default value for both fields, if not passed, is `true`.
>
> `automatic`: Comes with a combo of `app:horizontalSpeed="float"` and `app:verticalSpeed="float"`. The default speed for both fields, if not passed, is `360F`

***
## Adding in your projects
Add these on `build.gradle.kts` file of the target module.
```
repositories {
  mavenCentral()
}

dependencies {
  implementation("io.github.williankl.spinnable:spinnable-core:$spinnableVersion")
}
```
