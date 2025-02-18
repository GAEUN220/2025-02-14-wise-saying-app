package com.ll.domain.wiseSaying.wiseSaying.repository

import com.ll.domain.wiseSaying.wiseSaying.entity.WiseSaying

class WiseSayingRepository {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.isNew()) {
            wiseSaying.id = ++lastId
            wiseSayings.add(wiseSaying)
        }
        return wiseSaying
    }

    fun isEmpty(): Boolean {
        return wiseSayings.isEmpty()
    }

    fun findAll(): List<WiseSaying> {
        return wiseSayings
    }

    fun findById(id: Int): WiseSaying? {
        return wiseSayings.firstOrNull {it.id == id}
    }

    fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    fun clear() {
        lastId = 0
        wiseSayings.clear()
    }
}