package ke.kiura.autocheck.core

object DefaultConfig {
    const val READ_TIMEOUT = 30L
    const val WRITE_TIMEOUT = 30L
    const val CONNECTION_TIMEOUT = 10L
    const val CACHE_SIZE_BYTES = 10 * 1024 * 1024L // 10 MB
    const val PARAM_DETAIL = "detail"
}