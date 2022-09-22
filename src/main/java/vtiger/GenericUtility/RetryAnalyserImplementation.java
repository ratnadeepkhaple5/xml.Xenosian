package vtiger.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * class provides implementation for IRetryAnalyser Interface of TestNg
 * @author SUNNY
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=3;
	public boolean retry(ITestResult result) {
		while (count<retryCount) {
			count++;
			return true;
		}
		
		return false;
	}
	
}
