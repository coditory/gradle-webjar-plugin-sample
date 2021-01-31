plugins {
    id("com.coditory.webjar") version "1.0.3"
}

webjar {
    distDir = "build/dist"
    cache {
        src = listOf("src", "style", "webpack", "webpack.config.js", "tsconfig.js")
        test = listOf("test")
    }
}