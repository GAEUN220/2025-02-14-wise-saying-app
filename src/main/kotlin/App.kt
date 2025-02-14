
package com.ll

class App {
    fun run() {
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()

        println("== 명언 앱 ==")

        while (true) {
            print("명령) ")
            val input = readlnOrNull()!!.trim()

            val rq = Rq(input)

            if (rq.action == "종료") {
                break
            } else if (rq.action == "등록") {
                print("명언 : ")
                val content = readlnOrNull()!!.trim()
                print("작가 : ")
                val author = readlnOrNull()!!.trim()

                val id = ++lastId

                wiseSayings.add(WiseSaying(id, content, author))

                println("${id}번 명언이 등록되었습니다.")
            } else if (rq.action == "목록") {
                if (wiseSayings.isEmpty()) {
                    println("등록된 명언이 없습니다.")
                    continue
                }

                println("번호 / 작가 / 명언")

                println("----------------------")

                wiseSayings.forEach {
                    println("${it.id} / ${it.author} / ${it.content}")
                }
            } else if (rq.action == "삭제") {
                val id = rq.getParamValueAsInt("id", 0)

                if (id == 0) {
                    println("id를 정확히 입력해주세요.")
                    continue
                }

                val wiseSaying = wiseSayings.firstOrNull { it.id == id }

                if (wiseSaying == null) {
                    println("해당 id의 명언은 존재하지 않습니다.")
                    continue
                }

                wiseSayings.remove(wiseSaying)

                println("${id}번 명언을 삭제하였습니다.")
            }
        }
    }
}