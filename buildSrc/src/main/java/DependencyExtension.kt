import org.gradle.api.artifacts.dsl.DependencyHandler

//Dependency Handler method
private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

//Dependency Handler extension for other library
fun DependencyHandler.kotlin() {
    implementation(Dependencies.kotlin_stdlib)
    implementation(Dependencies.kotlin_reflect)
}

fun DependencyHandler.lifeCycle() {
    implementation(Dependencies.extensions)
    implementation(Dependencies.view_model)
    implementation(Dependencies.runtime)
    implementation(Dependencies.live_data)
}

fun DependencyHandler.androidx() {
    implementation(Dependencies.material_component)
    implementation(Dependencies.core_ktx)
    implementation(Dependencies.app_compat)
    implementation(Dependencies.multi_dex)
    implementation(Dependencies.constraint_layout)
}

fun DependencyHandler.workManager() {
    implementation(Dependencies.work_runtime)
}

fun DependencyHandler.shimmer() {
    implementation(Dependencies.shimmer)
}

fun DependencyHandler.dagger() {
    api(Dependencies.dagger_android)
    kapt(Dependencies.dagger_compiler)
    kapt(Dependencies.dagger_processor)
}

fun DependencyHandler.retrofit() {
    api(Dependencies.retrofit)
    api(Dependencies.retrofit_gson)
}

fun DependencyHandler.okHttp() {
    api(Dependencies.ok_http)
    api(Dependencies.ok_http_url_connection)
    api(Dependencies.logging_interceptor)
}

fun DependencyHandler.room() {
    api(Dependencies.room_runtime)
    kapt(Dependencies.room_compiler)
    api(Dependencies.room_ktx)
}

fun DependencyHandler.paging() {
    api(Dependencies.paging_runtime)
}

fun DependencyHandler.glide() {
    api(Dependencies.glide)
    kapt(Dependencies.glide_compiler)
    api(Dependencies.glide_integration)
}

fun DependencyHandler.gson() {
    api(Dependencies.gson)
}

fun DependencyHandler.timber() {
    api(Dependencies.timber)
}

//Dependency Handler extension for test library
fun DependencyHandler.androidxTest() {
    testImplementation(TestDependencies.arch_core_testing)
    androidTestImplementation(TestDependencies.test_runner)
    androidTestImplementation(TestDependencies.test_rules)
    androidTestImplementation(TestDependencies.test_ext_junit)
    androidTestImplementation(TestDependencies.test_espresso_core)
}

fun DependencyHandler.jUnit() {
    testImplementation(TestDependencies.junit)
    testImplementation(TestDependencies.kotlin_test)
}

fun DependencyHandler.mockito() {
    testImplementation(TestDependencies.mockito_core)
    testImplementation(TestDependencies.mockito_inline)
    androidTestImplementation(TestDependencies.mockito_android)
}