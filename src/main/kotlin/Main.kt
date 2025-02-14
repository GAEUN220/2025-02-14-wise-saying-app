package com.ll

data class WiseSaying(val id: Int, val quote: String, val author: String)

fun main() {
    var lastId = 0
    val wiseSayings = mutableListOf<WiseSaying>()

    println("== 명언 앱 ==")

    while (true) {
        print("명령) ")
        val input = readLine()

        when (input) {
            "종료" -> {
                break
            } "등록" -> {
                print("명언 : ")
                val quote = readLine()!!
                print("작가 : ")
                val author = readLine()!!

                lastId ++
                val wiseSaying = WiseSaying(lastId, quote, author)
                wiseSayings.add(wiseSaying)

                println("${lastId}번 명언이 등록되었습니다.")
            } "목록" -> {
                println("번호 / 작가 / 명언")
                println("----------------------")

                wiseSayings.reversed().forEach {
                    println("${it.id} / ${it.author} / ${it.quote}")
                }
            }
        }
    }
}