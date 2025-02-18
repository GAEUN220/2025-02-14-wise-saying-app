package domain.system.system.controller

import TestRunner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SystemControllerTest {
    @Test
    @DisplayName("종료")
    fun t1() {
        val result = TestRunner.run("")

        assertThat(result).contains("프로그램을 종료합니다.")
    }
}