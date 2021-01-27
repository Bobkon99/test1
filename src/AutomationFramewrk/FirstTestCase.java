package AutomationFramewrk;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.DateUtil;
import java.util.concurrent.TimeUnit;

public class FirstTestCase {

	public static void readExcel() throws IOException {
		// TODO Auto-generated method stub

		//Create an object of File class to open xlsx file
		File file = new File("C:\\Eclipseworkspace\\JavaLearn\\InputData\\InputData.xlsx");

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		//creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		//creating a Sheet object
		XSSFSheet sheet1=wb.getSheet("DataIn");
		//Create a row object to retrieve row at index 2
		XSSFRow row=sheet1.getRow(2);
		//Create a cell object to retrieve cell at index 2
		XSSFCell cell=row.getCell(2);
		//Get the email address in a variable
		String email= cell.getStringCellValue();
		//Printing the email address
		System.out.println("Email is :"+ email);

		int rowCount=sheet1.getPhysicalNumberOfRows();
		int cellcount=row.getPhysicalNumberOfCells();
		int lastrow=sheet1.getLastRowNum();
		int getLastCell = row.getLastCellNum();
		System.out.println("First row num is "+sheet1.getFirstRowNum());
		System.out.println("Last row num is "+lastrow);   
		System.out.println("Row count is "+rowCount); //get row count in a row
		System.out.println("First col num is "+row.getFirstCellNum());
		System.out.println("Last col num is "+getLastCell);
		System.out.println("Column count is "+cellcount);   //get cell count in a row
		try
		{
			//iterate over all the row to print the data present in each cell.
			for(int i=0;i<=lastrow;i++)
			{
				row=sheet1.getRow(i);

				//iterate over each cell to print its value
				System.out.println("Row "+ i+" data is :");

				for(int j=0;j<cellcount;j++)
				{
					cell=row.getCell(j);
					switch(cell.getCellType())
					{
					case STRING:System.out.print(cell.getStringCellValue() +",");break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)){
							System.out.print(cell.getDateCellValue()+",");break;
						}
						else {
							System.out.print(cell.getNumericCellValue() +",");break;
						}
					case BOOLEAN:System.out.print(cell.getBooleanCellValue() +",");break;
					case FORMULA:System.out.print(cell.getCellFormula() +",");break;
					default:
						break;
					}
					//System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue() +",");
					//System.out.print(cell.getStringCellValue() +",");
				}
				System.out.println();
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		wb.close();
		inputStream.close();

	}

	public static void WriteExcel() throws IOException {
		// TODO Auto-generated method stub

		//Create an object of File class to open xlsx file
		File file = new File("C:\\Eclipseworkspace\\JavaLearn\\InputData\\InputData.xlsx");

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		//creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);

		//creating a Sheet object
		XSSFSheet sheet1=wb.getSheet("DataIn");
		XSSFSheet sheet2=wb.createSheet("DataOut");
		XSSFSheet sheet3=wb.createSheet("DataOut2");
		//Create a row object to retrieve row at index 2
		XSSFRow row=sheet1.getRow(1);

		int rowCount=sheet1.getPhysicalNumberOfRows();
		int cellcount=row.getPhysicalNumberOfCells();
		int lastrow=sheet1.getLastRowNum();
		int getLastCell = row.getLastCellNum();
		//				System.out.println("First row num is "+sheet1.getFirstRowNum());
		//				System.out.println("Last row num is "+lastrow);   
		//				System.out.println("Row count is "+rowCount); //get row count in a row
		//				System.out.println("First col num is "+row.getFirstCellNum());
		//				System.out.println("Last col num is "+getLastCell);
		//				System.out.println("Column count is "+cellcount);   //get cell count in a row
		try
		{
			//iterate over all the row to print the data present in each cell.
			for(int i=0;i<=lastrow;i++)
			{
				row=sheet1.getRow(i);

				//iterate over each cell to print its value
				//System.out.println("Row"+ i+" data is :");

				for(int j=0;j<cellcount;j++)
				{
					XSSFCell cell=row.getCell(j);
					switch(cell.getCellType())
					{
					case STRING:cell.getStringCellValue();break;
					case NUMERIC:
						if(DateUtil.isCellDateFormatted(cell)){
							cell.getDateCellValue();break;
						}
						else {
							cell.getNumericCellValue();break;
						}
					case BOOLEAN:cell.getBooleanCellValue();break;
					case FORMULA:cell.getCellFormula();break;
					default:
						break;
					}

					FileOutputStream outputStream =new FileOutputStream(new File("C:\\Eclipseworkspace\\JavaLearn\\InputData\\InputData1.xlsx"));
					wb.write(outputStream);
					outputStream.close();
				}
				//System.out.println();
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		wb.close();
		inputStream.close();
		System.out.println("Data written successfully");

	}


	public static void main(String args[]) throws IOException {
		

		readExcel();
		//WriteExcel();
		
		System.out.println("Browser is Launched");
		//set the ChromeDriver path
		System.setProperty("webdriver.chrome.driver","C:\\Eclipseworkspace\\JavaLearn\\drivers\\chromedriver.exe");
		
		//Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();
		
		//Navigate to the URL
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Create an object of File class to open xlsx file
		File file =    new File("C:\\Eclipseworkspace\\JavaLearn\\InputData\\FormData.xlsx");

		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		//creating workbook instance that refers to .xlsx file
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);

		//creating a Sheet object
		XSSFSheet sheet=wb.getSheet("DataIn");

		//get all rows in the sheet
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("No of row in excel "+ rowCount);

		//Identify the WebElements for the student registration form
		WebElement firstName=driver.findElement(By.id("firstName"));
		WebElement lastName=driver.findElement(By.id("lastName"));
		WebElement email=driver.findElement(By.id("userEmail"));
		WebElement genderMale= driver.findElement(By.id("gender-radio-1"));
		WebElement mobile=driver.findElement(By.id("userNumber"));
		WebElement dob=driver.findElement(By.id("dateOfBirthInput"));
		WebElement address=driver.findElement(By.id("currentAddress"));
		WebElement submitBtn=driver.findElement(By.id("submit"));

		//iterate over all the rows in Excel and put data in the form.
		for(int i=1;i<=rowCount;i++) 
		{
			//Enter the values read from Excel in firstname,lastname,mobile,email,address
			firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			email.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			mobile.sendKeys(sheet.getRow(i).getCell(4).getStringCellValue());
			address.sendKeys(sheet.getRow(i).getCell(6).getStringCellValue());

			//Click on the gender radio button using javascript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", genderMale);

			//Click on submit button
			submitBtn.click();

			//Verify the confirmation message
			WebElement confirmationMessage = driver.findElement(By.xpath("//div[text()='Thanks for submitting the form']"));

			//create a new cell in the row at index 6
			XSSFCell cell = sheet.getRow(i).createCell(7);

			//check if confirmation message is displayed
			if (confirmationMessage.isDisplayed()) {
				// if the message is displayed , write PASS in the excel sheet
				cell.setCellValue("PASS");

			} else {
				//if the message is not displayed , write FAIL in the excel sheet
				cell.setCellValue("FAIL");
			}

			// Write the data back in the Excel file
			FileOutputStream outputStream = new FileOutputStream("C:\\Eclipseworkspace\\DemoQA\\FormData.xlsx");
			wb.write(outputStream);

			//close the confirmation popup
			WebElement closebtn = driver.findElement(By.id("closeLargeModal"));
			closebtn.click();

			//wait for page to come back to registration page after close button is clicked
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		}

		//Close the workbook
		wb.close();

		//Quit the driver
		driver.quit();

	}

	
}
