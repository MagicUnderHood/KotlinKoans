package builders

import java.util.HashMap

fun buildMutableMap(function: HashMap<Int, String>.() -> Unit): HashMap<Int, String> {
    val builder = hashMapOf<Int, String>()
    builder.function()
    return builder
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

fun buildString(build: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.build()
    return stringBuilder.toString()
}

val s = buildString {
    this.append("Numbers: ")
    for (i in 1..3) {
        // 'this' can be omitted
        append(i)
    }
}

fun main(args: Array<String>) {
    println(usage())
}