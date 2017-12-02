object Day1 {
    fun reverseCaptcha(input: String) = reverseCaptcha(input.map { "$it".toLong() })

    data class Result(val sum: Long, val current: Long)

    fun reverseCaptcha(inputs: List<Long>): Long = inputs.fold(Result(0, inputs.last())) { accum, input -> when(input) {
        accum.current -> Result(accum.sum + input, input)
        else -> accum.copy(current = input)
    }
    }.sum
}