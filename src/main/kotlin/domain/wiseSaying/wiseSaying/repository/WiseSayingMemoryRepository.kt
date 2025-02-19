
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

    override fun build() {}
    override fun findByAuthorLike(authorLike: String): List<WiseSaying> {
        val pureKeyword = authorLike.replace("%", "")
        if (pureKeyword.isBlank()) {
            return wiseSayings
        }
        return if (authorLike.startsWith("%") && authorLike.endsWith("%")) {
            wiseSayings.filter { it.author.contains(pureKeyword) }
        } else if (authorLike.startsWith("%")) {
            wiseSayings.filter { it.author.endsWith(pureKeyword) }
        } else if (authorLike.endsWith("%")) {
            wiseSayings.filter { it.author.startsWith(pureKeyword) }
        } else {
            wiseSayings.filter { it.author == pureKeyword }
        }
    }
    override fun findByAuthorContent(contentLike: String): List<WiseSaying> {
        val pureKeyword = contentLike.replace("%", "")
        if (pureKeyword.isBlank()) {
            return wiseSayings
        }
        return if (contentLike.startsWith("%") && contentLike.endsWith("%")) {
            wiseSayings.filter { it.content.contains(pureKeyword) }
        } else if (contentLike.startsWith("%")) {
            wiseSayings.filter { it.content.endsWith(pureKeyword) }
        } else if (contentLike.endsWith("%")) {
            wiseSayings.filter { it.content.startsWith(pureKeyword) }
        } else {
            wiseSayings.filter { it.content == pureKeyword }
        }
    }
}
