## Comprehensive Android Development Guide: Clean architecture, MVVM, UI & Unit & Screenshot Test, Libraries (LiveData, StateFlow, Retrofit, Hilt, Coroutine, Compose, DataStore, Test Libraries and more)

I created different mini-apps for each item in the bottom navigation. Each mini-app shows a different way to use popular libraries, structures and best practices in Android development. This project is great for learning because it covers many important variable approaches that Android developers use.

### Architecture & Design Principles

We adhere to clean architecture guidelines, structuring our application into multiple layers (Data, Domain, Presentation) to ensure decoupling and testability. The presentation layer is powered by MVVM (Model-View-ViewModel), utilizing Jetpack Compose for dynamic UIs and animations.

### Key Libraries

- Jetpack Compose & Material3 & Compose Navigation: For building modern UIs with a focus on material design principles.
- Dagger-Hilt: Dependency injection framework for Android, simplifying the provision of dependencies across the application.
- Retrofit & Gson: Networking and JSON serialization/deserialization for API communication.
- Jetpack Navigation: For handling in-app navigation in a modular and scalable way.
- Coroutines & Flow: For asynchronous programming and reactive data streams.
- Jetpack Lifecycle, LiveData, ViewModel: Lifecycle-aware components for robust and maintainable MVVM architecture.
- ExoPlayer: Media playback.
- Mockito & JUnit & Mockk & Espresso & Paparazzi: Testing libraries for Unit, UI, Integration & Screenshot tests.
- TOML Version Catalog: Centralizes and manages library versions across the project, enhancing maintainability and consistency in dependency management.
- DataStore with Serialization: For efficient and robust data storage and management, providing a reactive and secure way to handle preferences and structured data.
- Coil: For image loading and caching in Kotlin applications, offering seamless integration with Jetpack Compose.

### Custom Compose Animation
Developed with Jetpack Compose, this is a custom animation created without the use of any external libraries. Designed using modern and flexible Compose APIs, it's perfect for adding a unique and fluid experience to your user interface.

### Unique Usage for Page 1:
https://github.com/Mrtckr008/Sample-Android-Clean-Architecture/assets/32914909/f9a66b06-46f4-4a7c-b4da-9d39a49aaea4
- Clean Architecture: Demonstrated the use of Clean Architecture in the format of UI - Usecase(domain) - Data.
- Data Fetching: Provided examples of fetching data from an API and a local JSON file.
- Common usages
  
### Special Usage for Page 2:
https://github.com/Mrtckr008/Android-Sample-Best-Practices/assets/32914909/c7c213b4-a41b-45f0-a061-758ae5e51f2e
- Clean Architecture without Domain Module: Showed a different usage of Clean Architecture by directly connecting to the data module without a domain module.
- DataStore Usage: Demonstrated the use of DataStore for managing data.
- Common usages


### MIT License

Copyright (c) 2024 Murat Çakır

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

