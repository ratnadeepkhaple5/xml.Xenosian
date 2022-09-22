package screenshotsFailed;


import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenerClass extends BaseForFailedScreenshots implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result){
	System.out.println(result.getTestName());
	
	try {
		captureScreenShots(result.getTestName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
	
}
