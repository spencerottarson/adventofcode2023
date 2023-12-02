import util.FileReader

fun main() = Day01().run()

class Day01(inputFile: String = "input01.txt") : BasicDay(inputFile) {

  val input = FileReader.asStrings(inputFile)

  override fun part1(): Int {
    return input.sumOf { line ->
      val digits = line.filter { char -> char.isDigit() }
      val result = "${digits.first()}${digits.last()}"
      result.toInt()
    }
  }

  override fun part2(): Int {
    return input.sumOf { line ->
      var digits = ""
      line.forEachIndexed { index, char ->
        if (char.isDigit()) {
          digits += char
        } else {
          digits += findDigitMap(line.substring(index))
        }
      }
      val result = "${digits.first()}${digits.last()}"
      result.toInt()
    }
  }

  private val digitMap: Map<String, Char> = mapOf(
    "zero" to '0',
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9',
  )

  private fun findDigitMap(input: String): String {
    for (pair in digitMap) {
      if (input.startsWith(pair.key)) {
        return pair.value.toString()
      }
    }

    return ""
  }
}