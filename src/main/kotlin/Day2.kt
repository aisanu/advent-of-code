object Day2 {
    fun part1Solution(input: String): Long = splitRows(input)
            .map { splitColumns(it) }
            .map { minMaxDiff(it) }
            .sum()

    fun part2Solution(input: String): Long = splitRows(input)
            .map { splitColumns(it) }
            .map { wholeDivider(it) }
            .sum()

    fun minMaxDiff(input: List<Long>): Long {
        val min = requireNotNull(input.min()) { "Cannot found min" }
        val max = requireNotNull(input.max()) { "Cannot found max" }
        return Math.abs(max - min)
    }

    fun wholeDivider(input: List<Long>): Long = input.mapIndexed { index, value ->
        val result = input.drop(index + 1).find { it % value == 0L || value % it == 0L }
        result?.let { Math.max(result, value) / Math.min(result, value) }
    }.filterNotNull().first()

    fun splitRows(input: String): List<String> = input.split("\n").filter { it.isNotBlank() }
    fun splitColumns(input: String): List<Long> = input.split(Regex("[ \t]")).map { it.toLong() }
}