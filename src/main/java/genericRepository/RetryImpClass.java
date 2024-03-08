package genericRepository;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer
{
	int count = 0;
	int retrycount = 3; // com.HMS.genericUtils.RetryImpClass
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retrycount)
		{
			count++;
			return true;
		}
		return false;
	}
	
}
