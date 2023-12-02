import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day01Test {

  @Test
  fun part1() {
    assertEquals(55208, Day01().part1())
  }

  @Test
  fun part1_sample() {
    assertEquals(142, Day01("input01_sample1.txt").part1())
  }

  @Test
  fun part2() {
    assertEquals(54578, Day01().part2())
  }

  @Test
  fun part2_sample() {
    assertEquals(281, Day01("input01_sample2.txt").part2())
  }
}