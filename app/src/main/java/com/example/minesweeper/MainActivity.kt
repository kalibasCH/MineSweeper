package com.example.minesweeper

import kotlin.random.Random
import kotlin.random.nextInt

fun main() {

    val height = 9
    val width = 9
    val fieldOfTheGame = FieldOfTheGame(height, width).fieldOfTheGame
    val fieldUser = FieldOfTheGame(height, width).fieldOfTheGame
    val mines = Bot().talk().toInt()
    PutMinesAndHelp(
        fieldOfTheGame,
        mines,
        height,
        width
    ).putMinesAndHelp()
    TheGame(fieldOfTheGame, fieldUser, height, width, mines).move()
}

private class Bot(val gameIsStarts: Boolean = false) {

    fun talk(): String {
        return when (gameIsStarts) {
            false -> {
                println("How many mines do you want on the field?")
                readLine()!!
            }
            true -> {
                println("Set/unset mines marks or claim a cell as free:")
                readLine()!!
            }
        }
    }
}

private class FieldOfTheGame(height: Int, width: Int) {
    val fieldOfTheGame = MutableList(height) {
        MutableList(width) { '.' }
    }
}

private class PutMinesAndHelp(
    val fieldOfTheGame: MutableList<MutableList<Char>>,
    val mines: Int,
    val height: Int,
    val width: Int
) {

    fun putMinesAndHelp(): MutableList<MutableList<Char>> {
        for (i in 1..mines) {
            var firstIndexOfMine: Int
            var secondIndexOfMine: Int
            do {
                firstIndexOfMine = Random.nextInt(0..8)
                secondIndexOfMine = Random.nextInt(0..8)
            } while (fieldOfTheGame[firstIndexOfMine][secondIndexOfMine] != '.')
            fieldOfTheGame[firstIndexOfMine][secondIndexOfMine] = 'X'
        }

        var count = '0'
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (i == 0 && j == 0 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }
                } else if (i == width - 1 && j == height - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }
                } else if (i == 0 && j == width - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }
                } else if (i == height - 1 && j == 0 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }

                } else if (i != 0 && j == 0 && i != height - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }

                } else if (i == 0 && j != 0 && j != width - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }
                } else if (i != 0 && j == width - 1 && i != height - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }

                } else if (i == height - 1 && j != 0 && j != width - 1 && fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }

                } else if (fieldOfTheGame[i][j] != 'X') {
                    if (fieldOfTheGame[i][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i - 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j - 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (fieldOfTheGame[i + 1][j + 1] == 'X') {
                        count = (count.code + 1).toChar()
                    }
                    if (count != '0') {
                        fieldOfTheGame[i][j] = count
                    }
                }
                count = '0'
            }
        }
        return fieldOfTheGame
    }
}

private class View(_field: MutableList<MutableList<Char>>) {
    private val field = _field

    init {
        var countInt = 1
        println(
            " |123456789|\n" +
                    "-|---------|"
        )
        for (line in field) {
            print("$countInt|")
            countInt++
            print(line.joinToString(""))
            println("|")
        }
        println("-|---------|")
    }
}

private class TheGame(
    private var fieldOfTheGame: MutableList<MutableList<Char>>,
    private val fieldUser: MutableList<MutableList<Char>>,
    private val height: Int,
    private val width: Int,
    private val mines: Int
) {

    private var countMines = 0
    private var countSteps = 0
    private val listOfNumbers = listOf<Char>('1', '2', '3', '4', '5', '6', '7', '8')

    var y = 0
    var x = 0

    init {
        View(fieldUser)
    }

    fun move() {
        val (_y, _x, _command) = Bot(true).talk().split(" ")
        y = _y.toInt()
        x = _x.toInt()
        when (_command) {
            "mine" -> ifMine(fieldOfTheGame)
            "free" -> {
                if (countSteps == 0 && fieldOfTheGame[x - 1][y - 1] == 'X') {
                    do {
                        val newField = FieldOfTheGame(height, width).fieldOfTheGame
                        PutMinesAndHelp(newField, mines, height, width).putMinesAndHelp()
                        fieldOfTheGame = newField
                    } while (fieldOfTheGame[x - 1][y - 1] == 'X')
                    ifFree(fieldOfTheGame)
                } else {
                    ifFree(fieldOfTheGame)
                }
            }
        }
    }

    private fun ifMine(fieldOfTheGame: MutableList<MutableList<Char>>) {

        if (fieldOfTheGame[x - 1][y - 1] == '.' && fieldUser[x - 1][y - 1] == '.') {
            fieldUser[x - 1][y - 1] = '*'
            countMines--
            checkWinning()

        } else if (fieldOfTheGame[x - 1][y - 1] == '.' && fieldUser[x - 1][y - 1] == '*') {
            fieldUser[x - 1][y - 1] = '.'
            countMines++
            checkWinning()

        } else if (fieldOfTheGame[x - 1][y - 1] == 'X' && fieldUser[x - 1][y - 1] == '.') {
            fieldUser[x - 1][y - 1] = '*'
            countMines++
            checkWinning()

        } else if (fieldOfTheGame[x - 1][y - 1] == 'X' && fieldUser[x - 1][y - 1] == '*') {
            fieldUser[x - 1][y - 1] = '.'
            countMines--
            checkWinning()
        } else if (fieldOfTheGame[x - 1][y - 1] == '/' && fieldUser[x - 1][y - 1] == '/') {
            fieldUser[x - 1][y - 1] = '*'
            countMines--
            checkWinning()
        } else if (fieldOfTheGame[x - 1][y - 1] == '/' && fieldUser[x - 1][y - 1] == '*') {
            fieldUser[x - 1][y - 1] = '.'
            countMines++
            checkWinning()
        } else if (fieldOfTheGame[x - 1][y - 1] in listOfNumbers && fieldUser[x - 1][y - 1] == '.') {
            fieldUser[x - 1][y - 1] = '*'
            countMines--
            checkWinning()
        } else if (fieldOfTheGame[x - 1][y - 1] in listOfNumbers && fieldUser[x - 1][y - 1] == '*') {
            fieldUser[x - 1][y - 1] = '.'
            countMines++
            checkWinning()
        }
    }

    private fun ifFree(fieldOfTheGame: MutableList<MutableList<Char>>) {
        if (fieldOfTheGame[x - 1][y - 1] == 'X') {
            loss()
        } else if (fieldOfTheGame[x - 1][y - 1] == '.') {
            countSteps++
            fill(x, y)
            checkWinning()
        } else {
            fieldUser[x - 1][y - 1] = fieldOfTheGame[x - 1][y - 1]
            countSteps++
            checkWinning()
        }
    }

    private fun fill(xStart: Int, yStart: Int) {

        val coordinates2D = mutableListOf(Pair(xStart - 1, yStart - 1)) // 10 11 01

        while (coordinates2D.isNotEmpty()) {

            val (i, j) = coordinates2D.last() // 01
            fieldUser[i][j] = '/'
            fieldOfTheGame[i][j] = '/'


            if (i == 0 && j == 0) { // условие - верхний левый угол

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]
                }

                if (fieldOfTheGame[i + 1][j + 1] == '.') { // вправо-вниз
                    coordinates2D.add(0, Pair(i + 1, j + 1))

                } else {
                    fieldUser[i + 1][j + 1] = fieldOfTheGame[i + 1][j + 1]
                }

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))

                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]
                }

                coordinates2D.removeLast()


            } else if (i == width - 1 && j == height - 1) { // условие - нижний правый угол

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]
                }

                if (fieldOfTheGame[i - 1][j - 1] == '.') { // влево-вверх
                    coordinates2D.add(0, Pair(i - 1, j - 1))

                } else {
                    fieldUser[i - 1][j - 1] = fieldOfTheGame[i - 1][j - 1]

                }

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))

                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]

                }
                coordinates2D.removeLast()


            } else if (i == 0 && j == width - 1) { // условие - верхний правый угол

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]

                }

                if (fieldOfTheGame[i + 1][j - 1] == '.') { // влево-вниз
                    coordinates2D.add(0, Pair(i + 1, j - 1))

                } else {
                    fieldUser[i + 1][j - 1] = fieldOfTheGame[i + 1][j - 1]
                }

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))


                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]

                }
                coordinates2D.removeLast()


            } else if (i == height - 1 && j == 0) { // условие - нижний левый угол

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))


                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]

                }

                if (fieldOfTheGame[i - 1][j + 1] == '.') { // вверх-вправо
                    coordinates2D.add(0, Pair(i - 1, j + 1))

                } else {
                    fieldUser[i - 1][j + 1] = fieldOfTheGame[i - 1][j + 1]

                }

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]

                }
                coordinates2D.removeLast()


            } else if (i != 0 && j == 0 && i != height - 1) { // условие - левая сторона (не угол)

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))

                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]

                }

                if (fieldOfTheGame[i - 1][j + 1] == '.') { // вверх-вправо
                    coordinates2D.add(0, Pair(i - 1, j + 1))

                } else {
                    fieldUser[i - 1][j + 1] = fieldOfTheGame[i - 1][j + 1]

                }

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]

                }

                if (fieldOfTheGame[i + 1][j + 1] == '.') { // вправо-вниз
                    coordinates2D.add(0, Pair(i + 1, j + 1))

                } else {
                    fieldUser[i + 1][j + 1] = fieldOfTheGame[i + 1][j + 1]

                }

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))

                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]

                }
                coordinates2D.removeLast()


            } else if (i == 0 && j != 0 && j != width - 1) { // условие - верхняя сторона (не угол)

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]

                }

                if (fieldOfTheGame[i + 1][j + 1] == '.') { // вправо-вниз
                    coordinates2D.add(0, Pair(i + 1, j + 1))

                } else {
                    fieldUser[i + 1][j + 1] = fieldOfTheGame[i + 1][j + 1]

                }

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))

                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]

                }

                if (fieldOfTheGame[i + 1][j - 1] == '.') { // влево-вниз
                    coordinates2D.add(0, Pair(i + 1, j - 1))

                } else {
                    fieldUser[i + 1][j - 1] = fieldOfTheGame[i + 1][j - 1]
                }

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]
                }

                coordinates2D.removeLast()


            } else if (i != 0 && j == width - 1 && i != height - 1) { // условие - правая сторона (не угол)

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))

                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]
                }

                if (fieldOfTheGame[i + 1][j - 1] == '.') { // влево-вниз
                    coordinates2D.add(0, Pair(i + 1, j - 1))

                } else {
                    fieldUser[i + 1][j - 1] = fieldOfTheGame[i + 1][j - 1]
                }

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]
                }

                if (fieldOfTheGame[i - 1][j - 1] == '.') { // влево-вверх
                    coordinates2D.add(0, Pair(i - 1, j - 1))

                } else {
                    fieldUser[i - 1][j - 1] = fieldOfTheGame[i - 1][j - 1]
                }

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))

                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]
                }
                coordinates2D.removeLast()


            } else if (i == height - 1 && j != 0 && j != width - 1) { // условие - нижняя сторона (не угол)

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]
                }

                if (fieldOfTheGame[i - 1][j - 1] == '.') { // влево-вверх
                    coordinates2D.add(0, Pair(i - 1, j - 1))

                } else {
                    fieldUser[i - 1][j - 1] = fieldOfTheGame[i - 1][j - 1]
                }

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))

                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]
                }

                if (fieldOfTheGame[i - 1][j + 1] == '.') { // вверх-вправо
                    coordinates2D.add(0, Pair(i - 1, j + 1))

                } else {
                    fieldUser[i - 1][j + 1] = fieldOfTheGame[i - 1][j + 1]
                }

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]
                }
                coordinates2D.removeLast()


            } else {

                if (fieldOfTheGame[i - 1][j] == '.') { // вверх
                    coordinates2D.add(0, Pair(i - 1, j))

                } else {
                    fieldUser[i - 1][j] = fieldOfTheGame[i - 1][j]
                }

                if (fieldOfTheGame[i - 1][j + 1] == '.') { // вверх-вправо
                    coordinates2D.add(0, Pair(i - 1, j + 1))

                } else {
                    fieldUser[i - 1][j + 1] = fieldOfTheGame[i - 1][j + 1]
                }

                if (fieldOfTheGame[i][j + 1] == '.') { // вправо
                    coordinates2D.add(0, Pair(i, j + 1))

                } else {
                    fieldUser[i][j + 1] = fieldOfTheGame[i][j + 1]
                }

                if (fieldOfTheGame[i + 1][j + 1] == '.') { // вправо-вниз
                    coordinates2D.add(0, Pair(i + 1, j + 1))

                } else {
                    fieldUser[i + 1][j + 1] = fieldOfTheGame[i + 1][j + 1]
                }

                if (fieldOfTheGame[i + 1][j] == '.') { // вниз
                    coordinates2D.add(0, Pair(i + 1, j))

                } else {
                    fieldUser[i + 1][j] = fieldOfTheGame[i + 1][j]
                }

                if (fieldOfTheGame[i + 1][j - 1] == '.') { // влево-вниз
                    coordinates2D.add(0, Pair(i + 1, j - 1))

                } else {
                    fieldUser[i + 1][j - 1] = fieldOfTheGame[i + 1][j - 1]
                }

                if (fieldOfTheGame[i][j - 1] == '.') { // влево
                    coordinates2D.add(0, Pair(i, j - 1))

                } else {
                    fieldUser[i][j - 1] = fieldOfTheGame[i][j - 1]
                }

                if (fieldOfTheGame[i - 1][j - 1] == '.') { // влево-вверх
                    coordinates2D.add(0, Pair(i - 1, j - 1))

                } else {
                    fieldUser[i - 1][j - 1] = fieldOfTheGame[i - 1][j - 1]
                }
                coordinates2D.removeLast()
            }
        }
    }


    private fun checkWinning() {

        var counterDotsAndStars = 0
        for (i in 0 until height) {
            for (j in 0 until width) {
                if (fieldOfTheGame[i][j] != 'X' && fieldUser[i][j] != '.' && fieldUser[i][j] != '*') {
                    counterDotsAndStars++
                }
            }
        }

        if (countMines == mines || ((height * width) - counterDotsAndStars) == mines) {
            View(fieldUser)
            congratulations()
        } else {
            View(fieldUser)
            move()
        }
    }

    private fun loss() {
        println("You stepped on a mine and failed!")
    }

    private fun congratulations() {
        println("Congratulations! You found all the mines!")
    }
}