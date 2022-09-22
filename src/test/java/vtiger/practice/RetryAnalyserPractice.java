package vtiger.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = vtiger.GenericUtility.RetryAnalyserImplementation.class)
	public void retryPractice() {
		System.out.println("test 1");
		Assert.fail();
	}//o/p-> Tests run: 4, Failures: 1, Skips: 0, Retries: 3
}
