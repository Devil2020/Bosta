<p align="center">
<img src="[cover](https://user-images.githubusercontent.com/30175940/180797621-2279c5f3-74c5-458a-9613-49223e90a4cc.png)"/>
</p>

<h1 align="center">Bosta Task</h1>

<p align="center">
 <img alt="Medium" src="https://github.com/mohamedebrahim96/Namshi-Customer/workflows/Android%20CI/badge.svg"/></a>
     <a href="https://wakatime.com/badge/github/Devil2020/Bosta.svg"/><img alt="API" src="https://wakatime.com/badge/github/Devil2020/Bosta.svg"/></a>
     <a href="https://github.com/devil2020?tab=followers"><img alt="API" src="https://img.shields.io/github/stars/devil2020?style=social"/></a>

</p>



<p align="center">  
   upon running the application you will face a splash screen , then you will find data of the profile as well as a list of Albums, which you can click any of the Album to navigate to the Photos   , So we can View And Search with Name into the Photos Also .
</p>
</br>

## Download
Go to the [Releases](https://github.com/Devil2020/Halan/releases/download/v1.0.0/app-sharedTestingResources-debug.apk) to download the latest APK.


<img src=".images/halan.gif" align="right" width="32%"/>

## Tech stack & Open-source libraries
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- JetPack
    - Lifecycle - dispose of observing data when lifecycle state changes.
    - ViewModel - UI related data holder, lifecycle aware.
    - Room Persistence - construct a database using the abstract layer.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - [Bindables](https://github.com/skydoves/bindables) - Android DataBinding kit for notifying data changes to UI layers.
    - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [Sandwich](https://github.com/skydoves/Sandwich) - construct lightweight http API response and handling error responses.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide)
- [WhatIf](https://github.com/skydoves/whatif) - checking nullable object and empty collections more fluently.
- [Timber](https://github.com/JakeWharton/timber) - logging.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components like ripple animation, cardView.

## Let's explore Architecture Components

According to  [Android Documentation](https://developer.android.com/topic/libraries/architecture), Architecture Components are a set of Android libraries for structuring your app in a way that is robust, testable, and maintainable

## Architecture

[![](.images/Architecture-mvi.png)](.images/Architecture-mvi.png)

# []() Presentation Layer Architecture patter is MVi and Clean Architecute 

## []()UI Controllers

are activities or fragments. The only job of UI controllers is to know how to display data and pass on UI events, such as the user pressing a button. UI Controllers neither contain the UI data, nor directly manipulate data.

## []()Repository
This class is the single source of truth for all of our app's data and acts as a clean API for the UI to communicate with . Presenter simply request data usecase then it request it to repository. They do not need to worry about whether the repository should load from the database or network, or how or when to persist the data. The repository manages all of this. As part of this responsibility, the repository is a mediator between the different data sources.

## []()Remote Network Data Source

Manages data from a remote data source, such as the internet.


## []()Local Database Data Source

Manages data from a local data source, such as SharedPreference.

### []()License:
Copyright 2021 Mohammed Morse

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


