import org.junit.Assert
import org.junit.Test

class Day3Test {
    @Test fun testF() {
        Assert.assertEquals(1, Day3.bottomRightValue(0))
        Assert.assertEquals(9, Day3.bottomRightValue(1))
        Assert.assertEquals(25, Day3.bottomRightValue(2))
        Assert.assertEquals(49, Day3.bottomRightValue(3))
        Assert.assertEquals(49, Day3.bottomRightValue(4))
    }

    @Test fun estimate() {
        Assert.assertEquals("Test input (0,0)", 0, Day3.manhattanDistance(1))
        Assert.assertEquals("Test input (1,0)", 1, Day3.manhattanDistance(2))
        Assert.assertEquals("Test input (1,1)", 2, Day3.manhattanDistance(3))
        Assert.assertEquals("Test input (0,1)", 1, Day3.manhattanDistance(4))
        Assert.assertEquals("Test input (-1,1)", 2, Day3.manhattanDistance(5))
        Assert.assertEquals("Test input (-1,0)", 1, Day3.manhattanDistance(6))
        Assert.assertEquals("Test input (-1,-1)", 2, Day3.manhattanDistance(7))
        Assert.assertEquals("Test input (0,-1)", 1, Day3.manhattanDistance(8))
        Assert.assertEquals("Test input (1,-1)", 2, Day3.manhattanDistance(9))
        Assert.assertEquals("Real input", 475, Day3.manhattanDistance(277678))
    }

    @Test fun part2() {
        val x = mutableMapOf((0 to 0) to 1L)
        val n = 10

        for(i in 1..n) {
            Day3.populateMapsky(i, x)
            println("$i: ")
            for(ypos in i downTo -i) {
                for(xpos in -i..i) {
                    print(String.format("% 10d ", x[xpos to ypos]))
                }
                println()
            }
            println()
            println()
        }
    }
}