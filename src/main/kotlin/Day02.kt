import util.FileReader
import java.util.Collections.max

fun main() = Day02().run()

class Day02(inputFile: String = "input02.txt") : BasicDay(inputFile) {

  val input = FileReader.asStrings(inputFile)

  override fun part1(): Int {
    return input.map { parseLine(it) }.filter { isValidGame(it) }.sumOf { it.id }
  }

  override fun part2(): Int {
    return input.map { parseLine(it) }.map { minCubes(it) }.sumOf { it.blue * it.red * it.green }
  }

  // Game 4: 2 green, 3 blue, 9 red; 1 red, 1 green; 4 red, 4 blue; 1 blue, 19 red; 7 red

  private fun parseLine(input: String): Game {
    val id = input.substringBefore(":").split(" ").last().toInt()
    val hands = input.substringAfter(":").split(";").map { parseHand(it) }

    return Game(id, hands)
  }

  private fun parseHand(input: String): Hand {
    val colors = input.split(",").map { it.trim() }

    val colorMap = colors.associate {
      val number = it.split(" ").first().toInt()
      val color = it.split(" ").last()

      color to number
    }

    return Hand(
      red = colorMap["red"] ?: 0,
      blue = colorMap["blue"] ?: 0,
      green = colorMap["green"] ?: 0,
    )
  }

  private fun isValidGame(game: Game): Boolean {
    return game.hands.all { hand ->
      hand.red <= 12 &&
          hand.blue <= 14 &&
          hand.green <= 13
    }
  }

  private fun minCubes(game: Game): Hand {
    return Hand(
      red = max(game.hands.map { it.red }),
      green = max(game.hands.map { it.green }),
      blue = max(game.hands.map { it.blue }),
    )
  }

  data class Game(
    val id: Int,
    val hands: List<Hand>,
  )

  data class Hand(
    val red: Int,
    val blue: Int,
    val green: Int,
  )
}