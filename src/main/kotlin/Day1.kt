object Day1 {
    fun part1Solution(input: String) = captchaPart1(input.map { "$it".toLong() })
    fun part2Solution(input: String) = captchaPart2(input.map { "$it".toLong() })

    data class Result(val sum: Long, val current: Long)

    fun captchaPart1(inputs: List<Long>): Long = inputs.fold(Result(0, inputs.last())) { accum, input -> when(input) {
        accum.current -> Result(accum.sum + input, input)
        else -> accum.copy(current = input)
        }
    }.sum

    fun captchaPart2(inputs: List<Long>): Long {
        val middle = inputs.size / 2
        return inputs.take(inputs.size / 2).foldIndexed(0L) { index, accum, current ->
            when(current) {
                inputs[middle + index] -> accum + current + inputs[middle + index]
                else ->accum
            }
        }
    }
}