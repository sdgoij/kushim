package com.github.sdgoij.kushim

import uniffi.kushim.Counter
import uniffi.kushim.echoBytes
import uniffi.kushim.hello

actual fun greet(name: String): String {
    val counter = Counter()
    counter.increment()
    counter.increment()
    val third = counter.increment()
    val echoed = echoBytes(byteArrayOf(1, 2, 3))
    return "${hello(name)} counter=$third bytes=${echoed.size}"
}
