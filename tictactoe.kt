package tictactoe
fun main() {
    // write your code here
    var order = 1
    val str = "         "
    val ticTacList = mutableListOf(
        mutableListOf(str[0], str[1], str[2]), //[0][0], [0][1], [0][2]
        mutableListOf(str[3], str[4], str[5]), //[1][0], [1][1], [1][2]
        mutableListOf(str[6], str[7], str[8])  //[2][0], [2][1], [2][2]
    )
    var oQ = 0
    var xQ = 0
    for (i in 0..8) {
        if (str[i] == 'O') {
            oQ++
        }
    }
    for (i in 0..8) {
        if (str[i] == 'X') {
            xQ++
        }
    }
    var caseX = false
    var caseO = false
    for (i in 0 until 9) {
        print("-")
    }
    println()
    for (i in 0 until 3) {
        print("| ")
        for (j in 0 until 3) {
            print("${ticTacList[i][j]} ")
        }
        println("|")
    }
    for (i in 0 until 9) {
        print("-")
    }
    println()
    val noFin = !caseO && !caseX && 8 - oQ - xQ >= 1
    var counterX = 0
    while (counterX <= 4) {
        print("Enter the coordinates: ")
        val (a, b) = readln().split(" ")
        val bIsNum = true
        val aIsNum: Boolean = b.matches("-?\\d+(\\.\\d+)?".toRegex())
        if (!aIsNum || !bIsNum) {
            println("You should enter numbers!")
            continue
        }
        val c1 = a.toInt()
        val c2 = b.toInt()
        val rightRange = c1 in 1 .. 3 && c2 in 1 .. 3
        if (!rightRange) {
            println("Coordinates should be from 1 to 3!")
            continue
        }
        val noChars = ticTacList[c1 - 1][c2 - 1] == 'X' || ticTacList[c1 - 1][c2 - 1] == 'O'
        if (noChars) {
            println("This cell is occupied! Choose another one!")
    }
        if (!noChars && rightRange && order % 2 != 0 && noFin) {
            ticTacList[c1 - 1][c2 - 1] = 'X'
            order++
            if (ticTacList[0][0] == 'O' && ticTacList[1][1] == 'O' && ticTacList[2][2] == 'O') {
                caseO = true
            }
            if (ticTacList[0][0] == 'X' && ticTacList[1][1] == 'X' && ticTacList[2][2] == 'X') {
                caseX = true
            }
            if (ticTacList[0][2] == 'O' && ticTacList[1][1] == 'O' && ticTacList[2][0] == 'O') {
                caseO = true
            }
            if (ticTacList[0][2] == 'X' && ticTacList[1][1] == 'X' && ticTacList[2][0] == 'X') {
                caseX = true
            }
            for (i in 0..2) {
                if (ticTacList[0][i] == 'O') {
                    if (ticTacList[1][i] == 'O' && ticTacList[2][i] == 'O') {
                        caseO = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[0][i] == 'X') {
                    if (ticTacList[1][i] == 'X' && ticTacList[2][i] == 'X') {
                        caseX = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[i][0] == 'O') {
                    if (ticTacList[i][1] == 'O' && ticTacList[i][2] == 'O') {
                        caseO = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[i][0] == 'X') {
                    if (ticTacList[i][1] == 'X' && ticTacList[i][2] == 'X') {
                        caseX = true
                        break
                    }
                }
            }

            for (i in 0 until 9) {
                print("-")
            }
            println()
            for (i in 0 until 3) {
                print("| ")
                for (j in 0 until 3) {
                    print("${ticTacList[i][j]} ")
                }
                println("|")
            }
            for (i in 0 until 9) {
                print("-")
            }
            println()
            if (caseO && !caseX) {
                println("O wins")
                break
            }
            if (!caseO && caseX) {
                println("X wins")
                break
            }
            counterX = 0
            for (p in 0 until 3){
                for (n in 0 until 3){
                    if (ticTacList[p][n] == 'X'){
                        counterX++
                    }
                }
            }
            continue
        }
        if (!noChars && rightRange && order % 2 == 0 && noFin) {
            ticTacList[c1 - 1][c2 - 1] = 'O'
            order++
            if (ticTacList[0][0] == 'O' && ticTacList[1][1] == 'O' && ticTacList[2][2] == 'O') {
                caseO = true
            }
            if (ticTacList[0][0] == 'X' && ticTacList[1][1] == 'X' && ticTacList[2][2] == 'X') {
                caseX = true
            }
            if (ticTacList[0][2] == 'O' && ticTacList[1][1] == 'O' && ticTacList[2][0] == 'O') {
                caseO = true
            }
            if (ticTacList[0][2] == 'X' && ticTacList[1][1] == 'X' && ticTacList[2][0] == 'X') {
                caseX = true
            }
            for (i in 0..2) {
                if (ticTacList[0][i] == 'O') {
                    if (ticTacList[1][i] == 'O' && ticTacList[2][i] == 'O') {
                        caseO = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[0][i] == 'X') {
                    if (ticTacList[1][i] == 'X' && ticTacList[2][i] == 'X') {
                        caseX = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[i][0] == 'O') {
                    if (ticTacList[i][1] == 'O' && ticTacList[i][2] == 'O') {
                        caseO = true
                        break
                    }
                }
            }
            for (i in 0..2) {
                if (ticTacList[i][0] == 'X') {
                    if (ticTacList[i][1] == 'X' && ticTacList[i][2] == 'X') {
                        caseX = true
                        break
                    }
                }
            }

            for (i in 0 until 9) {
                print("-")
            }
            println()
            for (i in 0 until 3) {
                print("| ")
                for (j in 0 until 3) {
                    print("${ticTacList[i][j]} ")
                }
                println("|")
            }
            for (i in 0 until 9) {
                print("-")
            }
            println()
            if (caseO && !caseX) {
                println("O wins")
                break
            }
        }
    }
    if (counterX == 5) {
        println("Draw")
    }
}


