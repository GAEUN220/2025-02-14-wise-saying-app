
package com.ll.domain.wiseSaying.wiseSaying.repository

import com.ll.domain.wiseSaying.wiseSaying.entity.WiseSaying
import com.ll.global.app.AppConfig
import java.nio.file.Path

class WiseSayingFileRepository : WiseSayingRepository {
    val tableDirPath: Path
        get() {
            return AppConfig.dbDirPath.resolve("wiseSaying")
        }

    override fun save(wiseSaying: WiseSaying): WiseSaying {
        if (wiseSaying.isNew()) wiseSaying.id = loadLastIdAndIncrease()

        saveOnDisk(wiseSaying)

        return wiseSaying
    }

    override fun isEmpty(): Boolean {
        return true
    }

    override fun findAll(): List<WiseSaying> {
        return listOf()
    }

    override fun findById(id: Int): WiseSaying? {
        return tableDirPath
            .toFile()
            .listFiles()
            ?.find { it.name == "${id}.json" }
            ?.let { WiseSaying.fromJsonStr(it.readText()) }
    }

    override fun delete(wiseSaying: WiseSaying) {
    }

    override fun clear() {
        tableDirPath.toFile().deleteRecursively()
    }

    private fun saveOnDisk(wiseSaying: WiseSaying) {
        mkTableDirsIfNotExists()

        val wiseSayingFile = tableDirPath.resolve("${wiseSaying.id}.json")
        wiseSayingFile.toFile().writeText(wiseSaying.jsonStr)
    }

    private fun mkTableDirsIfNotExists() {
        tableDirPath.toFile().run {
            if (!exists()) {
                mkdirs()
            }
        }
    }

    internal fun saveLastId(lastId: Int) {
        mkTableDirsIfNotExists()

        tableDirPath.resolve("lastId.txt")
            .toFile()
            .writeText(lastId.toString())
    }

    internal fun loadLastId(): Int {
        return try {
            tableDirPath.resolve("lastId.txt")
                .toFile()
                .readText()
                .toInt()
        } catch (e: Exception) {
            0
        }
    }

    private fun loadLastIdAndIncrease(): Int {
        val lastId = loadLastId()
        saveLastId(lastId + 1)
        return lastId
    }
}
