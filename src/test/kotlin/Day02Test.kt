import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day02Test {

  @Test
  fun part1() {
    assertEquals(2720, Day02().part1())
  }

  @Test
  fun part1_sample() {
    assertEquals(8, Day02("input02_sample1.txt").part1())
  }

  @Test
  fun part2() {
    assertEquals(71535, Day02().part2())
  }

  @Test
  fun part2_sample() {
    assertEquals(2286, Day02("input02_sample2.txt").part2())
  }
}