package com.ll.domain.wiseSaying.wiseSaying.repository

import com.ll.domain.wiseSaying.wiseSaying.entity.WiseSaying
import com.ll.global.app.AppConfig
import com.ll.global.bean.SingletonScope
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test

class WiseSayingFileRepositoryTest {
    private val wiseSayingRepository = SingletonScope.wiseSayingFileRepository

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll(): Unit {
            AppConfig.setModeToTest()
        }
    }

    @BeforeEach
    fun setUp() {
        wiseSayingRepository.clear()
    }

    @Test
    fun `save`() {
        val wiseSaying = wiseSayingRepository
            .save(WiseSaying("나의 죽음을 적들에게 알리지 말라.", "충무공 이순신"))

        val filePath = wiseSayingRepository
            .tableDirPath
            .toFile()
            .listFiles()
            ?.find { it.name == "${wiseSaying.id}.json" }

        assertThat(filePath).isNotNull
    }
}