object Day3 {
    // TODO: How to fix this mess
    fun manhattanDistance(est: Long): Long {
        val last  = (1..Long.MAX_VALUE).takeWhile { Day3.bottomRightValue(it) <= est }.last()
        val box = Day3.bottomRightValue(last)
        var diff = est - box
        val n = 2 * last
        var (x, y) = (last - 1) to -(last - 1)
        if(diff > 0L){
            x++
            diff--
            for(i in 1..n - 1) {
                if(diff <= 0) break
                y++
                diff--
            }
            for(i in 1..n) {
                if(diff <= 0) break
                x--
                diff--
            }
            for(i in 1..n) {
                if(diff <= 0) break
                y--
                diff--
            }
            for(i in 1..n) {
                if(diff <= 0) break
                x++
                diff--
            }
        }

        return Math.abs(x) + Math.abs(y)
    }

    fun bottomRightValue(x: Long): Long {
        require(x > 0) { "Only non negative number allowed" }
        return when(x) {
            1L -> 1
            else -> bottomRightValue(x - 1) + 8 * (x - 1)
        }
    }

    fun populateMapsky(first: Int, output: MutableMap<Pair<Int, Int>, Long>) {
        val start = bottomRightValue(first.toLong())
        val end = bottomRightValue((first + 1).toLong())
        var diff = end - start - 1

        var x = first
        var y = -(first - 1)
        var n = (first) * 2
        output[x to y] = sumNeighboor(output, x, y)

        if(diff > 0L){
            for(i in 1..n - 1) {
                if(diff <= 0) break
                y++
                diff--
                output[x to y]
                output[x to y] = sumNeighboor(output, x, y)
            }
            for(i in 1..n) {
                if(diff <= 0) break
                x--
                diff--
                output[x to y] = sumNeighboor(output, x, y)
            }
            for(i in 1..n) {
                if(diff <= 0) break
                y--
                diff--
                output[x to y] = sumNeighboor(output, x, y)
            }
            for(i in 1..n) {
                if(diff <= 0) break
                x++
                diff--
                output[x to y] = sumNeighboor(output, x, y)
            }
        }
    }

    fun sumNeighboor(map: MutableMap<Pair<Int, Int>, Long>, x: Int, y: Int): Long {
        val retVal = map.getOrDefault((x + 1) to (y + 0), 0L) +
                map.getOrDefault((x + 1) to (y + 1), 0L) +
                map.getOrDefault((x + 0) to (y + 1), 0L) +
                map.getOrDefault((x + -1) to (y + 1), 0L) +
                map.getOrDefault((x + -1) to (y + 0), 0L) +
                map.getOrDefault((x + -1) to (y + -1), 0L) +
                map.getOrDefault((x + 0) to (y + -1), 0L) +
                map.getOrDefault((x + 1) to (y + -1), 0L)

        if(retVal >= 277678) println("Found at ($x, $y): $retVal")
        return retVal
    }
}