package com.madoka.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform