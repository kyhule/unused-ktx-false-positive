# Minimal Working Example of unused inline function false positive

This is an example implementation that reproduces the dependency-analysis plugin reporting a false
positive of an unused dependency for which an android library module is referencing a single inline
function provided by the `androidx.core:core-ktx:1.3.0` dependency. This is the out of running
`./gradlew clean buildHealth --rerun-tasks` on this project in it's current state:

```
➜  unused-ktx-false-positive git:(master) ✗ ./gradlew clean buildHealth --rerun-tasks                                                                                                                                                                                                                 git:(master|●1✚1

> Task :lib:compileDebugKotlin
w: /Users/klehma685/Development/unused-ktx-false-positive/lib/src/main/kotlin/com/example/lib/AndroidModule.kt: (10, 27): 'PreferenceManager' is deprecated. Deprecated in Java

> Task :lib:compileReleaseKotlin
w: /Users/klehma685/Development/unused-ktx-false-positive/lib/src/main/kotlin/com/example/lib/AndroidModule.kt: (10, 27): 'PreferenceManager' is deprecated. Deprecated in Java

> Task :lib:aggregateAdvice
Unused dependencies which should be removed:
- implementation("androidx.core:core-ktx:1.3.0")

Transitively used dependencies that should be declared directly as indicated:
- api("javax.inject:javax.inject:1")
- implementation("androidx.core:core:1.3.0")
- api("com.google.dagger:dagger:2.28.3")

See machine-readable report at /Users/klehma685/Development/unused-ktx-false-positive/lib/build/reports/dependency-analysis/advice-all-variants.json
See pretty report at           /Users/klehma685/Development/unused-ktx-false-positive/lib/build/reports/dependency-analysis/advice-all-variants-pretty.json

> Task :app:aggregateAdvice
Transitively used dependencies that should be declared directly as indicated:
- implementation("androidx.fragment:fragment:1.2.0")
- implementation("javax.inject:javax.inject:1")
- implementation("com.google.dagger:dagger:2.28.3")
- implementation("androidx.lifecycle:lifecycle-viewmodel:2.2.0")
- implementation("androidx.activity:activity:1.1.0")

See machine-readable report at /Users/klehma685/Development/unused-ktx-false-positive/app/build/reports/dependency-analysis/advice-all-variants.json
See pretty report at           /Users/klehma685/Development/unused-ktx-false-positive/app/build/reports/dependency-analysis/advice-all-variants-pretty.json

> Task :failOrWarn
There were build health issues. Please see the report
(machine-readable) /Users/klehma685/Development/unused-ktx-false-positive/build/reports/dependency-analysis/advice-holistic.json
(pretty-printed)   /Users/klehma685/Development/unused-ktx-false-positive/build/reports/dependency-analysis/advice-holistic-pretty.json

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.5/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 9s
146 actionable tasks: 146 executed
```
