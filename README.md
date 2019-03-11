
### Architecture  ###
##### Quick summary ##### 
This project uses the clean architecture with MVP in presentation layer and Kotlin as programming language.
This project structure is based on the example bellow :
- Object diagram illustrated by  this [Schemas](https://raw.githubusercontent.com/bufferapp/android-clean-architecture-boilerplate/master/art/architecture.png)
- [Source on GitHub](https://github.com/bufferapp/android-clean-architecture-boilerplate)

So according the clean architecture with MVP Pattern, I divided the project into 4 modules :
- Data module : it is the data layer of the app typed as Android Library to allow us to use ROOM Api.
 This module provide the Data from cloud or local (database) to the domain layer through it's Repository interface
- Domain module : it is the domain or business logic layer of the app, it's 100 % independent from other modules,
 it's role is just to execute the business treatment of the app , that's why it is typed as Java Library project (0 Android instruction)

- Presenter module: it composes the first part of presentation Layer, and in this module, we declare the Views and presenters  required 
to the MVP pattern.
This module is coupled with Domain.

- App module : this is the android module which composes the second part of Presentation Layer. In this module we used Dagger2 to inject dependencies, and to communicate with the Presenter Layer

- Common module : It is a java lib, used to put all common resources (Only in KOTLIN) WITH A VERY WEAK COUPLING, that means when we removed, others modules continue working
### How do I get set up? ###

##### Summary of set up ##### 
- Create 4 flavors : dev, test, integration and prod
- Install Kotlin and define it as default programming language
- Install [kotlin-android-extensions](https://kotlinlang.org/docs/tutorials/android-plugin.html)
- Install and config [kotlin-kapt](https://kotlinlang.org/docs/reference/kapt.html) to use Dagger and the databinding
- Install  [Dagger 2](https://antonioleiva.com/dagger-android-kotlin/)

##### Configuration ##### 
Create an Android project with 4 modules, the main module is the Android app and others are : 
- Data module : Android library
- Domain module : Java library
- Presenter module : Java library

All dependencies version, and Android config are in main project build.gradle file, so to change 
dependency version, we must do it there
##### Dependencies ##### 
###### Shared (used by all modules) ######
- [RxJava](https://github.com/ReactiveX/RxJava/wiki/Getting-Started)
- [RxKotlin](https://github.com/ReactiveX/RxKotlin)
- [javax-Inject](https://docs.oracle.com/javaee/6/api/javax/inject/package-summary.html)
###### In Data module ######
includes Shared +
- [OkHttp3](http://square.github.io/okhttp/)
- [Gson](https://github.com/google/gson)
- [retrofit](http://square.github.io/retrofit/)
- [room](https://developer.android.com/topic/libraries/architecture/room.html)
###### In Domain module ######
includes Shared
###### In Presenter module ######
includes Shared
###### In Android App module ######
includes Shared +
- [Dagger](https://google.github.io/dagger/)
- [FastAdapter](https://github.com/mikepenz/FastAdapter) to handle easier the data fill in recycle view 
- Android Support
- Google play services
