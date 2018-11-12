package net.luculent.liems;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class ExcelDataProvider1 implements Iterator<Object[]>{
	    
	        private Workbook book = null;
	        private Sheet sheet = null;
	        private int rowNum = 0;
	        private int currentRowNo = 0;
	        private int columnNum = 0;
	        private String[] columnnName;
	        private String path = null;
	        private InputStream inputStream = null;
	        public ExcelDataProvider1(String fileName,String moduleName) {

	            try {
	                path = "TestData/" + fileName + ".xls";
	                inputStream = new FileInputStream(path);
	                book = Workbook.getWorkbook(inputStream);
	                sheet = book.getSheet(moduleName);
	                rowNum = sheet.getRows(); 
	                Cell[] cell = sheet.getRow(0);
	                columnNum = cell.length; 
	                columnnName = new String[cell.length];
	                for (int i = 0; i < cell.length; i++) {
	                    columnnName[i] = cell[i].getContents().toString();
	                }
	                this.currentRowNo++;
	            } catch (FileNotFoundException e) {
	                Assert.fail("文件路径错误" + "[" + path + "]");
	            } catch (Exception e) {
	                Assert.fail("数据文件错误" + path + "]");
	            }
	        }
	       public boolean hasNext() {
	            if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {

	                try {
	                    inputStream.close();
	                    book.close();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                return false;
	            } else {
	                if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
	                    return false;
	                return true;
	            }
	        }
	        public Object[] next() {
	            Cell[] c = sheet.getRow(this.currentRowNo);
	            Map<String, String> data = new HashMap<String, String>();
	            for (int i = 0; i < this.columnNum; i++) {
	                String temp = "";
	                try {
	                    temp = c[i].getContents().toString();
	                } catch (ArrayIndexOutOfBoundsException ex) {
	                    temp = "";
	                }
	                data.put(this.columnnName[i], temp);
	            }
	            Object object[] = new Object[1];
	            object[0] = data;
	            this.currentRowNo++;
	            return object;
	        }

	        public void remove() {
	            throw new UnsupportedOperationException("remove unsupported.");
	        }
	    }


