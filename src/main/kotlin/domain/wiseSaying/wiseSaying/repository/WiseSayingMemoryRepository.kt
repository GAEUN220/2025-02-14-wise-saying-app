
package com.ll.domain.wiseSaying.wiseSaying.repository

import com.ll.domain.wiseSaying.wiseSaying.entity.WiseSaying

class WiseSayingMemoryRepository : WiseSayingRepository {
    private var lastId = 0
    private val wiseSayings = mutableListOf<WiseSaying>()

    override fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.isNew()) {
            wiseSaying.id = ++lastId
            wiseSayings.add(wiseSaying)
        }

        return wiseSaying
    }

    override fun isEmpty(): Boolean {
        return wiseSayings.isEmpty()
    }

    override fun findAll(): List<WiseSaying> {
        return wiseSayings
    }

    override fun findById(id: Int): WiseSaying? {
        return wiseSayings.firstOrNull { it.id == id }
    }

    override fun delete(wiseSaying: WiseSaying) {
        wiseSayings.remove(wiseSaying)
    }

    override fun clear() {
        lastId = 0
        wiseSayings.clear()
    }
}
