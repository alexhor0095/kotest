import io.kotest.core.annotation.AutoScan
import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

@AutoScan
class RepeatOnFailureExtension : TestCaseExtension {
    var repeatCounter = 2
    override suspend fun intercept(
        testCase: TestCase,
        execute: suspend (TestCase) -> TestResult
    ): TestResult {
        var testResult = execute(testCase)
        while (repeatCounter > 0) {
            if (testResult.isErrorOrFailure) {
                testResult = execute(testCase)
            }
            repeatCounter--
        }
        print(testResult)
        return testResult
    }
}



