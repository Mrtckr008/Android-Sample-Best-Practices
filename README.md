## Comprehensive Android Development Guide: Clean architecture, MVVM, Jetpack Libraries (LiveData, StateFlow, Retrofit, Hilt, Coroutine, Compose and more)

Welcome to our project repository, where we dive deep into the intricacies of Android development with a focus on Jetpack Libraries. This project serves not a real-world application it serves as an extensive resource for learning and understanding the application of modern development practices, unit test & ui test & screenshot test, jetpack libraries and best practice structures in Android.

### Key Features and Learning Outcomes:

- LiveData & StateFlow Integration: Learn how to manage UI-related data in a lifecycle-aware fashion, ensuring your app's UI matches the data state.
- Advanced Retrofit Usage: Explore the power of Retrofit for making API calls, handling different HTTP methods **(GET, POST, PUT, PATCH, DELETE)**, and customizing requests with headers and path parameters. Our examples include fetching weather data, user management operations, and handling authorization in API requests.
- Data Combination and Transformation: Discover how to combine data from multiple StateFlows or LiveData objects, enhancing the responsiveness and flexibility of your app.
- Dependency Injection with Hilt: Delve into dependency injection using Hilt to decouple your code and improve testability. Learn the distinctions between **@Binds and @Provides** for efficient DI implementation.
- RecyclerView Optimization: Implement RecyclerView with **DiffUtil** for efficient data changes handling and create multiple **ViewHolders** to accommodate different types of list items.
- Unit & UI & Screenshot Testing: Enhance your app's reliability and maintainability by writing unit tests, covering a wide range of components including UI elements, data management, and network requests.
- Our project not only showcases these features in action but also provides a comprehensive guide to applying them in your own projects. Whether you're a beginner looking to grasp the basics or an experienced developer aiming to polish your skills, this repository offers valuable insights and practical examples to elevate your Android development game.

### Architecture & Design Principles

We adhere to clean architecture guidelines, structuring our application into multiple layers (Data, Domain, Presentation) to ensure decoupling and testability. The presentation layer is powered by MVVM (Model-View-ViewModel), utilizing Jetpack Compose for dynamic UIs and animations.

### Key Libraries

- Jetpack Compose & Material3: For building modern UIs with a focus on material design principles.
- Dagger-Hilt: Dependency injection framework for Android, simplifying the provision of dependencies across the application.
- Retrofit & Gson: Networking and JSON serialization/deserialization for API communication.
- Jetpack Navigation: For handling in-app navigation in a modular and scalable way.
- Coroutines & Flow: For asynchronous programming and reactive data streams.
- Jetpack Lifecycle, LiveData, ViewModel: Lifecycle-aware components for robust and maintainable MVVM architecture.
- ExoPlayer: Media playback.
- Mockito & JUnit: Testing libraries for unit and integration tests.
- TOML Version Catalog: Centralizes and manages library versions across the project, enhancing maintainability and consistency in dependency management.
- Paparazzi: For snapshot testing of Compose UI components, enabling visual verification and regression testing.


### Custom Compose Animation
Developed with Jetpack Compose, this is a custom animation created without the use of any external libraries. Designed using modern and flexible Compose APIs, it's perfect for adding a unique and fluid experience to your user interface.

https://github.com/Mrtckr008/Sample-Android-Clean-Architecture/assets/32914909/f9a66b06-46f4-4a7c-b4da-9d39a49aaea4


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

