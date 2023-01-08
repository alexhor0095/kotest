import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class TestClass : FunSpec({
    //extension(RepeatOnFailureExtension())
    test("fail test") {
        1 + 2 shouldBe 23
    }
    test("success test"){
        1 + 1 shouldBe 2
    }
})