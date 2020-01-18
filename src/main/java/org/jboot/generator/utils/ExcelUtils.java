package org.jboot.generator.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * 对poi进行再次封装
 * 
 * @author liwen
 */
public abstract class ExcelUtils {

    /**
     * 获取Excel文本信息
     * 
     * @param sheetName
     *            sheet名称
     * @param title
     *            excel文件内容标题
     * @param values
     *            excel文件内容
     * @param wb
     *            HSSFWorkbook 07版本对象
     * @return
     */
    public static Workbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, Workbook wb) {
        if (wb == null) {
            ExceptionUtils.application(500, "无法获取文本信息。");
        }
        Sheet sheet = wb.createSheet(sheetName);
        Row row = sheet.createRow(0);
        CellStyle style = wb.createCellStyle();
        Cell cell = null;
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        if (ArrayUtils.isNotEmpty(values)) {
            for (int i = 0; i < values.length; i++) {
                row = sheet.createRow(i + 1);
                for (int j = 0; j < values[i].length; j++) {
                    setCellValue(wb, i + 1, j, values[i][j]);
                }
            }
        }
        return wb;
    }

    /**
     * 获取单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellValue(Workbook workbook, int rowIndex, int colIndex) {
        return getCellInSheet(workbook, 0, rowIndex, colIndex);
    }

    /**
     * 获取单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param sheetAt
     *            sheet页面索引
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellValue(Workbook workbook, int sheetAt, int rowIndex, int colIndex) {
        return getCellInSheet(workbook, sheetAt, rowIndex, colIndex);
    }

    /**
     * 获取单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param sheetName
     *            sheet页名称
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellValue(Workbook workbook, String sheetName, int rowIndex, int colIndex) {
        return getCellInSheet(workbook, sheetName, rowIndex, colIndex);
    }

    /**
     * 获取单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellInSheet(Workbook workbook, int rowIndex, int colIndex) {
        return getCellInSheet(workbook, 0, rowIndex, colIndex);
    }

    /**
     * 获取单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param sheetAt
     *            sheet页面索引
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellInSheet(Workbook workbook, int sheetAt, int rowIndex, int colIndex) {
        if (rowIndex < 1 || colIndex < 1) {
            ExceptionUtils.application(500, "单元格参数获取错误。");
        }
        Sheet sheet = workbook.getSheetAt(sheetAt);
        Row row = sheet.getRow(rowIndex - 1);
        Cell cell = row.getCell(colIndex - 1);
        return cell;
    }

    /**
     * 获取单元格
     * 
     * @param workbook
     *            excel 对象
     * @param sheetName
     *            sheet页面名称
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell getCellInSheet(Workbook workbook, String sheetName, int rowIndex, int colIndex) {
        if (rowIndex < 1 || colIndex < 1) {
            ExceptionUtils.application(500, "单元格参数获取错误。");
        }
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowIndex - 1);
        Cell cell = row.getCell(colIndex - 1);
        return cell;
    }

    /**
     * 设置单元格值
     * 
     * @param workbook
     *            excel 对象
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static void setCellValue(Workbook workbook, int rowIndex, int colIndex, Object object) {
        setCellValue(workbook, 0, rowIndex, colIndex, object);
    }

    /**
     * 设置单元格
     * 
     * @param workbook
     *            excel 对象
     * @param sheetAt
     *            sheet页索引
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static void setCellValue(Workbook workbook, int sheetAt, int rowIndex, int colIndex, Object object) {
        Cell cellst = getCellInSheet(workbook, sheetAt, rowIndex, colIndex);
        setCellValue(cellst, object);
    }

    /**
     * 设置单元格
     * 
     * @param workbook
     *            excel 对象
     * @param sheetName
     *            sheet页面名称
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static void setCellValue(Workbook workbook, String sheetName, int rowIndex, int colIndex,
        Object object) {
        Cell cellst = getCellInSheet(workbook, sheetName, rowIndex, colIndex);
        setCellValue(cellst, object);
    }

    /**
     * 设置单元格
     * 
     * @param rowIndex
     *            行
     * @param colIndex
     *            列
     * @return 单元格对象 {@link Cell}
     */
    public static Cell setCellValue(Cell cell, Object value) {
        if (value instanceof String) {
            cell.setCellValue((String)value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date)value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean)value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double)value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar)value);
        } else if (value instanceof RichTextString) {
            cell.setCellValue((RichTextString)value);
        } else {
            cell.setCellValue(String.valueOf(value));
        }
        return cell;
    }

}
