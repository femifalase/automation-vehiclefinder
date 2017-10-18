package com.richard.cordbyte.utils;

import com.richard.cordbyte.models.Vehicle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class ReadFileData {


    public static List<Vehicle> getExcelData(String path) {

        List<Vehicle> vehicles = new ArrayList<>();
        File excelFile = new File(path);
        Workbook wb = null;

        try {
            wb = WorkbookFactory.create(excelFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.rowIterator();

        for (Row row : sheet) {
            if (row.getRowNum() != 0) {

                Vehicle vehicle = new Vehicle();
                vehicle.setRegMark(row.getCell(0).getStringCellValue());
                vehicle.setMake(row.getCell(1).getStringCellValue());
                vehicle.setColour(row.getCell(2).getStringCellValue());

                vehicles.add(vehicle);
            }

        }

        return vehicles;

    }

    public static Vehicle getExcelData(String path, int rowNumber) {

        Vehicle vehicle = new Vehicle();
        File excelFile = new File(path);
        Workbook wb = null;

        try {
            wb = WorkbookFactory.create(excelFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(rowNumber);

        vehicle.setRegMark(row.getCell(0).getStringCellValue());
        vehicle.setMake(row.getCell(1).getStringCellValue());
        vehicle.setColour(row.getCell(2).getStringCellValue());

        return vehicle;
    }


    public static Properties getProperties() {

        File file = new File("src/main/resources/config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        //load properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

}