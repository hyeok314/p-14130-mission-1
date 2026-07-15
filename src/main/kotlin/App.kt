package com

class App {
    fun run() {
        println("== 명언 앱 ==")
        var lastId = 0
        val wiseSayings = mutableListOf<WiseSaying>()

        while (true) {
            print("명령) ")
            val input = readlnOrNull()!!.trim()

            if (input == "종료") break

            else if(input == "등록") {
                print("명언: ")
                val content = readlnOrNull()!!.trim()
                print("작가: ")
                val author = readlnOrNull()!!.trim()

                val id = ++lastId
                wiseSayings.add(WiseSaying(id, content, author))

                println("${id}번 명언이 등록되었습니다.")
            }

            else if(input.startsWith("삭제?id=")) {
                val id = input.split('=')[1].toInt()

                val target = wiseSayings.find {it.id == id}
                if (target == null) {
                    println("${id}번 명언은 존재하지 않습니다.")
                } else {
                    wiseSayings.removeIf { it.id == target.id}
                    println("${id}번 명언이 삭제되었습니다.")
                }
            }

            else if(input == "목록") {
                println("번호 / 작가 / 명언")
                println("-------------------------")
                wiseSayings.reversed().forEach {
                    println("${it.id} / ${it.content} / ${it.author}")
                }
            }
        }
    }
}