package functionalComponents;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.util.*;

public class ExcelDataReader 
{ 
	HSSFWorkbook workbook;
	private static HashMap<String, HashMap<String, Object>> mapData;

	public String getColumnValue(HashMap<String, List<HashMap<String, String>>> sheetData,String key, String columnName)
	{
		String value="";
		HashMap<String, String> row = sheetData.get(key).get(0);
		value = row.get(columnName);
		return value;
	}

	public static HashMap<String, HashMap<String, Object>> loadData(){
		try { 
			if (mapData == null) 
			{
				synchronized (ExcelDataReader.class) 
				{
					if (mapData == null) 
					{
						try {
							mapData = new HashMap<String, HashMap<String, Object>>();
							mapData.put("Excel_File", convertToJson("excelFiles/Excel_File.xlsx"));

						} catch (Exception e) 
						{
							e.printStackTrace();
						}
					}
				}
			} 
			else 
			{
				return mapData;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return mapData;
	}

	public static HashMap<String, Object> convertToJson(String filename)
	{
		HashMap<String, Object> rootMap = null;
		FileInputStream file = null;

		try {

			file = new FileInputStream(ExcelDataReader.class.getClassLoader().getResource(filename).getPath());

			Workbook workbook = WorkbookFactory.create(file);
			int noOfSheet = workbook.getNumberOfSheets();
			rootMap = new HashMap<String, Object>();			
			HashMap<String, List<HashMap<String, String>>> providerUniqueMap = null;

			//sheet iteration
			for (int i = 0; i < noOfSheet; i++) 
			{

				Sheet sheet = workbook.getSheetAt(i);
				Row indexRow = sheet.getRow(0);
				providerUniqueMap = new HashMap<String, List<HashMap<String, String>>>();

				//row iteration
				for(int j=1;j<=sheet.getLastRowNum();j++)
				{

					Row row = sheet.getRow(j);

					if(row!=null)
					{

						Cell uniqueCell =  row.getCell(0,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
//						uniqueCell.setCellType(Cell.CELL_TYPE_STRING);
						String providerID = uniqueCell.getStringCellValue().trim();

						List<HashMap<String, String>> listProviderKeyValue = new ArrayList<HashMap<String, String>>();
						HashMap<String, String> providerKeyValue = new HashMap<String, String>();

						//cell iteration
						for (int k=1;k<row.getLastCellNum();k++)
						{

							//cell value 
							Cell cell = row.getCell(k,Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
//							cell.setCellType(Cell.CELL_TYPE_STRING);
							String cellValue = cell.getStringCellValue();

							//cell key
							Cell indexcell = indexRow.getCell(k, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK);
//							indexcell.setCellType(Cell.CELL_TYPE_STRING);
							String cellkey = indexcell.getStringCellValue();

							//Add key value pair
							providerKeyValue.put(cellkey.trim(), cellValue.trim());					

						}

						//To check if provider is already added to map.
						//True, add it to existing list
						if(providerUniqueMap.containsKey(providerID))
						{
							List<HashMap<String, String>> temp = providerUniqueMap.get(providerID);
							temp.add(providerKeyValue);
							providerUniqueMap.put(providerID, temp);
						}
						//False, create a new list and add it
						else
						{
							listProviderKeyValue = new ArrayList<HashMap<String, String>>();
							listProviderKeyValue.add(providerKeyValue);
							providerUniqueMap.put(providerID, listProviderKeyValue);
						}					
					}

					rootMap.put(sheet.getSheetName(), providerUniqueMap);
				}
			}			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}

		return rootMap;
	}

}