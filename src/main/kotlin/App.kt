
package com.ll

class App {
    fun run() {
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()

        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val input = readlnOrNull()!!.trim()

            when {
                input == "종료" -> {
                    break
                } input == "등록" -> {
                    print("명언 : ")
                    val content = readlnOrNull()!!.trim()
                    print("작가 : ")
                    val author = readlnOrNull()!!.trim()

                    val id = ++lastId
                    wiseSayings.add(WiseSaying(id, content, author))

                    println("${id}번 명언이 등록되었습니다.")
                } input == "목록" -> {
                    if (wiseSayings.isEmpty()) {
                        println("등록된 명언이 없습니다.")
                    } else {
                        println("번호 / 작가 / 명언")
                        println("----------------------")

                        wiseSayings.reversed().forEach {
                            println("${it.id} / ${it.author} / ${it.content}")
                        }
                    }
                } input.startsWith("삭제?id=") -> {
                    val idStr = input.substringAfter("삭제?id=")
                    val id = idStr.toIntOrNull()

                    if (id == null ) {
                        println("잘못된 id 형식입니다.")
                        continue
                    }

                    val removed = wiseSayings.removeIf{ it.id == id }

                    if (removed) {
                        println("${id}번 명언이 삭제되었습니다.")
                    } else {
                        println("해당 명언은 존재하지 않습니다.")
                    }
                }
                else -> println("알 수 없는 명령어입니다.")
            }
        }
    }
}