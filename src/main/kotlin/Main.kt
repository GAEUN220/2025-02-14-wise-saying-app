package com.ll

fun main() {
    println("== 명언 앱 ==")

    while (true) {
        print("명령) ")
        val input = readLine()

        if (input == "종료") {
            println("종료")
            break
        } else if ( input == "등록" ) {
            print("명언 : ")
            val wiseSaying = readLine()
            print("작가 : ")
            val author = readLine()

            println("1번 명언이 등록되었습니다.")
        }
    }
}