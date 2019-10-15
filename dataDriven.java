package POIAPITutorial.POIAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//PROCESS TO BE APPLIED 

//Identify test cases by scanning the entire first row .(col can be moved so scanning needs to be done)
//Scan the column completely,once column is identified(purchase row)
//after you grab the required row, pull all the data of that row and feed it into test
public class dataDriven {

	ArrayList<String> arraylist= new ArrayList<String>();

	public ArrayList<String> getData(String testcase) throws IOException {
		// 1. GET ACCESS TO THE SHEET

		//this fis obj will read the file and keep it in XSSFWorkbook 
		FileInputStream fis = new FileInputStream("C:\\Users\\nikitdas.CORP\\Desktop\\selenium\\POIAPI.xlsx");
		XSSFWorkbook wkbk = new XSSFWorkbook(fis); // workbk accesses the excel file

		// see how many sheets are there, get the count

		int countOfSheets=wkbk.getNumberOfSheets();
		//System.out.println(countOfSheets);

		//traverse thru all of them

		for(int i=0;i<countOfSheets;i++)
		{
			if(wkbk.getSheetName(i).equalsIgnoreCase("testdata")); // sheet identified
			{
				XSSFSheet sheetRows = wkbk.getSheetAt(i); // got the row where test data is present(this obj has all thr rows)

				//identify the test column by scanning entire 1st row
				Iterator<Row> rows = sheetRows.iterator();
				//traverses all the rows in sheet
				// (sheet is a collection of many rows)

				// control is in the first row from 0th row
				Row firstRow=rows.next();

				Iterator<Cell> cell = firstRow.cellIterator();
				//(row is a collection of cells)
				//read each cell of that row to know my desired column
				int count=0;
				int column = 0;

				while(cell.hasNext()) // next cell present?true:false
				{
					Cell value=cell.next(); // grab the value u got
					if(value.getStringCellValue().equalsIgnoreCase(testcase))// comparing the value equal to the col that I want
					{

						column=count;

					}
					count++;

				}
				System.out.println(column);

				//scan the col to search for that row 

				//	Iterator<Row> rows = sheetRows.iterator();
				while(rows.hasNext())
				{
					Row r=	rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Purchase"))
						// get the cell of that col
					{
						Iterator<Cell> cellValue=r.cellIterator();
						while(cellValue.hasNext())
						{
							Cell cellValueStored=cellValue.next();
							if(cellValueStored.getCellTypeEnum()==CellType.STRING)
							{
								//System.out.println(cellValue.next().getStringCellValue()); 
								arraylist.add(cellValueStored.getStringCellValue());
							}
							else
							{
								NumberToTextConverter.toText(cellValueStored.getNumericCellValue());
							}

						}
					}


				}



			}


		}
		return arraylist;

	}

}
