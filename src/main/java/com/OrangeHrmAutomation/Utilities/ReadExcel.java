package com.OrangeHrmAutomation.Utilities;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    String path = "src/main/resources/Test Data/TestDataOFOrangeHrm.xlsx";
    public String readExcelFile(String getSheet, int getRow, int getCell) throws IOException {
        FileInputStream fis = new FileInputStream(path);
        String excel = WorkbookFactory.create(fis).getSheet(getSheet).getRow(getRow).getCell(getCell).getStringCellValue();
        fis.close();
        return excel;
    }
}
