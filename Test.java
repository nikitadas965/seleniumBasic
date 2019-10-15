package POIAPITutorial.POIAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		ArrayList<String> array = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("C:\\Users\\nikitdas.CORP\\Desktop\\selenium\\POIAPI.xlsx");
		XSSFWorkbook wkbk = new XSSFWorkbook(fis);
		int countOfSheets = wkbk.getNumberOfSheets();
		for(int i=0;i<countOfSheets;i++)
		{
			if(wkbk.getSheetName(i).equalsIgnoreCase("test"))
			{
				XSSFSheet getSheet = wkbk.getSheetAt(i);//get that sheet
				Iterator<Row> itr_rows = getSheet.iterator(); // iterate over that sheet

				//to get row count
				//int rowcount= getsheet.getlastRowNum();

				// to get column count
				// int colcount = getsheet.getRow(1).getLastCellNum();


				Row firstrow=itr_rows.next();
				Iterator<Cell> cells = firstrow.cellIterator();
				int count =0; int col=0;
				while(cells.hasNext())
				{
					Cell value=cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
					{
						// desired col
						// im checking each row  for my desired row
						col=count; // get the index of my required column

					}
					count++;

				}
				int cellnum=0; int num=0;
				// iterating over rows of that particular column
				while(itr_rows.hasNext())
				{
					Row r=itr_rows.next();
					if(r.getCell(col).getStringCellValue().equalsIgnoreCase("Purchase"))
					{


						// pull all the cell contents
						Iterator<Cell> cell_itr=	r.cellIterator();
						while(cell_itr.hasNext())
						{
							cellnum=num;
							String res=cell_itr.next().getStringCellValue();
							//System.out.println(res);
							if(res!=null)
							{
								array.add(res);

							}
							else if(res==null)
							{
								r.createCell(cellnum).setCellValue("abc");
								continue;
							}
							num++;	

						}
						System.out.println(array);
					}
				}

			}
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream("C:\\Users\\nikitdas.CORP\\Desktop\\selenium\\POIAPI.xlsx");
		
		//Write into workbook
		wkbk.write(fos);


	}

}
