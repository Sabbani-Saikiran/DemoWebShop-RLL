package TestNGListeners;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	public class CucumberExtentReportListener implements ITestListener {
		
		
		public void onTestStart(ITestResult result) {
			
			System.out.println("Test Method start");
		
		}

		public void onTestSuccess(ITestResult result) {
			
			System.out.println("Test Method success");
		
		}

		public void onTestFailure(ITestResult result) {
			
			System.out.println("Test Method Failed");
		
		}

		public void onTestSkipped(ITestResult result) {
			
			System.out.println("Test Method skipped");
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			
			System.out.println("Test Method fail with timeout");

		}

		public void onStart(ITestContext context) {
			
			System.out.println("Testing has started");
		
		}

		public void onFinish(ITestContext context) {
			
			System.out.println("Testing has finished");
		
		}

	}