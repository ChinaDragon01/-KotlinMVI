### MVI架构模式
>遵循单向数据流 (UDF) 原则，在 UDF 中，状态仅朝一个方向流动。修改数据的事件朝相反方向流动。

>- M：Model 数据层，包含应用数据和业务逻辑

>- V：View 界面层，在屏幕上显示应用数据，包含与界面相关的状态和界面逻辑，根据界面状态对象更新UI，界面状态定义是不可变的。这样的主要好处是，不可变对象可保证即时提供应用的状态

>- I：Intent, 处理界面事件（用户在与应用互动时生成的事件）

### 本demo演示MVI架构的使用

> - ViewModel
   >[ViewModel overview](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=en)
   >[ViewModel](https://developer.android.com/reference/androidx/lifecycle/ViewModel)
>- [androidx.lifecycle](https://developer.android.google.cn/jetpack/androidx/releases/lifecycle?hl=zh-cn#kts)
>- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=en)
>- 网络框架
   >[retrofit2](https://github.com/square/retrofit/) + [协程](https://book.kotlincn.net/text/coroutines-overview.html)
   >[协程上下文与调度器 中文文档](https://book.kotlincn.net/text/coroutine-context-and-dispatchers.html)
   >[协程上下文与调度器 英文文档](https://kotlinlang.org/docs/coroutine-context-and-dispatchers.html#thread-local-data)
>- 日志框架
   >[okhttp3:logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
>- 数据库
   >[room](https://developer.android.com/jetpack/androidx/releases/room?hl=en#kts)
>- api
   >[玩Android 开放API](https://www.wanandroid.com/blog/show/2)
>- Gradle依赖统一版本管理
   >[Version Catalog](https://docs.gradle.org/7.0/release-notes.html)
   >[TOML官网](https://toml.io/en/)
>- KSP
   >[从 kapt 迁移到 KSP](https://developer.android.com/build/migrate-to-ksp?hl=zh-cn)
   >[KSP官网文档](https://kotlinlang.org/docs/ksp-quickstart.html)
>- [TextInputEditText](https://developer.android.google.cn/reference/com/google/android/material/textfield/TextInputEditText?hl=en)
>- [ViewBinding](https://developer.android.com/topic/libraries/view-binding?hl=zh-cn)
   >[Android Gradle 插件 3.6.0推出的新特性](https://developer.android.com/build/releases/past-releases/agp-3-6-0-release-notes?hl=zh-cn)
   >[Android Gradle 插件 4.0.0开始放在buildFeatures](https://developer.android.com/build/releases/past-releases/agp-4-0-0-release-notes?hl=zh-cn)


### 提醒

>- 创建ViewModel方式
   > 在BaseActivity和BaseFragment里统一通过反射（getDeclaredConstructor().newInstance()）创建ViewModel
>- 如果没有封装成统一的方式，独立创建ViewModel
   >在gradle里依赖androidx.activity:activity-ktx:xxx
   >在Activity里，可以通过 by viewModels()
   >在gradle里依赖androidx.fragment:fragment-ktx:xxx
   >在Fragment里，可以通过 by activityViewModels()
