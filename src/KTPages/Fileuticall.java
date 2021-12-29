package KTPages;

import java.io.IOException;

public class Fileuticall {

	public static void main(String[] args) throws IOException {

		    //Create an object of fle class

		    ReadExcelFile objExcelFile = new ReadExcelFile();

		    //Prepare the path of excel file

		    String filePath = System.getProperty("user.dir");//+"\\src\\excelExportAndFileIO";
		    System.out.println(filePath);
		    //Call read file method of the class to read data

		    objExcelFile.readExcel(filePath,"excelfortest.xlsx","Sheet1");

		    }
		
	}

