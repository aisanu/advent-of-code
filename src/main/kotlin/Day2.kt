object Day2 {
    fun calculateDay2Checksum(input: String): Long = splitRows(input)
            .map { splitColumns(it) }
            .map { minMaxDiff(it) }
            .sum()

    fun minMaxDiff(input: List<Long>): Long {
        val min = requireNotNull(input.min()) { "Cannot found min" }
        val max = requireNotNull(input.max()) { "Cannot found max" }
        return Math.abs(max - min)
    }

    fun splitRows(input: String): List<String> = input.split("\n").filter { it.isNotBlank() }
    fun splitColumns(input: String): List<Long> = input.split(Regex("[ \t]")).map { it.toLong() }
}