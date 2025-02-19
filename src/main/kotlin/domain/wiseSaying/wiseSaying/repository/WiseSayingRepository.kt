
package com.ll.domain.wiseSaying.wiseSaying.repository

import com.ll.domain.wiseSaying.wiseSaying.entity.WiseSaying
import com.ll.standard.dto.Page

interface WiseSayingRepository {
    fun save(wiseSaying: WiseSaying): WiseSaying
    fun isEmpty(): Boolean
    fun findAll(): List<WiseSaying>
    fun findById(id: Int): WiseSaying?
    fun delete(wiseSaying: WiseSaying)
    fun clear()
    fun build()
    fun findByAuthorLike(authorLike: String): List<WiseSaying>
    fun findByAuthorContent(contentLike: String): List<WiseSaying>
    fun findAllPaged(itemsPerPage: Int, pageNo: Int): Page<WiseSaying>
    fun findByKeywordPaged(keywordType: String, keyword: String, itemsPerPage: Int, pageNo: Int): Page<WiseSaying>
}
