## Comprehensive Android Development Guide: Clean architecture, MVVM, UI & Unit & Screenshot Test (Compose Preview Screenshot Test and Paparazzi), Libraries (Compose Navigation 3, LiveData, StateFlow, Retrofit, Hilt, Coroutine, Compose, DataStore, Test Libraries and more)

I created different mini-apps for each item in the bottom navigation. Each mini-app shows a different way to use popular libraries, structures and best practices in Android development. This project is great for learning because it covers many important variable approaches that Android developers use.

### Architecture & Design Principles

We adhere to clean architecture guidelines, structuring our application into multiple layers (Data, Domain, Presentation) to ensure decoupling and testability. The presentation layer is powered by MVVM (Model-View-ViewModel), utilizing Jetpack Compose for dynamic UIs and animations.

### Key Libraries

- Jetpack Compose & Material3 & Compose Navigation 3 & Compose Preview Screenshot Test: For building modern UIs with a focus on material design principles.
- Dagger-Hilt: Dependency injection framework for Android, simplifying the provision of dependencies across the application.
- Retrofit & Gson: Networking and JSON serialization/deserialization for API communication.
- Jetpack Navigation: For handling in-app navigation in a modular and scalable way.
- Coroutines & Flow: For asynchronous programming and reactive data streams.
- Jetpack Lifecycle, LiveData, ViewModel: Lifecycle-aware components for robust and maintainable MVVM architecture.
- ExoPlayer: Media playback.
- Mockito & JUnit & Mockk & Espresso & Paparazzi & Compose Preview Screenshot Test: Testing libraries for Unit, UI, Integration & Screenshot tests.
- TOML Version Catalog: Centralizes and manages library versions across the project, enhancing maintainability and consistency in dependency management.
- DataStore with Serialization: For efficient and robust data storage and management, providing a reactive and secure way to handle preferences and structured data.
- Coil: For image loading and caching in applications, offering seamless integration with Jetpack Compose.
- Kover: Kotlin code coverage tool used to generate detailed test coverage reports. It helps monitor the effectiveness of tests and improve code quality.

### Code Coverage Report

To generate a Kotlin code coverage report using [Kover](https://github.com/Kotlin/kotlinx-kover), run the following command:

```bash
./gradlew koverHtmlReport
```

### Screenshot
<img width="1491" height="557" alt="Screenshot 2025-07-14 at 23 59 03" src="https://github.com/user-attachments/assets/d6b8af33-3bf0-43e5-909b-3059606c6e97" width="100%" />


### Compose Screenshot Testing

Compose Preview Screenshot Tests are used to verify UI consistency and detect unexpected layout changes during development.

To update the baseline screenshots and verify them for a specific module (e.g., musicplayer), run the following commands:

```bash
./gradlew :feature:musicplayer:updateDebugScreenshotTest

## After development to verify
./gradlew :feature:musicplayer:verifyDebugScreenshotTest
```

The generated screenshots can be found under:
```bash
feature/musicplayer/build/outputs/screenshotTest-results/preview
```

### Custom Compose Animation
**dynamicboxanimator** library module is developed with Jetpack Compose, this is a custom animation created without the use of any external libraries. Designed using modern and flexible Compose APIs.

### Unique Usage for Page 1:
https://github.com/Mrtckr008/Android-Sample-Best-Practices/assets/32914909/66e9a3f4-0e20-4ddc-aa5d-cac8e03544ec
- Clean Architecture: Demonstrated the use of Clean Architecture in the format of UI - Usecase(domain) - Data.
- Data Fetching: Provided examples of fetching data from an API and a local JSON file.
- Common usages
  
### Special Usage for Page 2:
https://github.com/Mrtckr008/Android-Sample-Best-Practices/assets/32914909/8b40e56b-cc4c-4796-80b4-42b12876141f
- Clean Architecture without Domain Module: Showed a different usage of Clean Architecture by directly connecting to the data module without a domain module.
- DataStore Usage: Demonstrated the use of DataStore for managing data.
- Common usages


## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE.txt) file for details.

