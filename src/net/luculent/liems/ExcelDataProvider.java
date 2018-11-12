package net.luculent.liems;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
public class ExcelDataProvider implements Iterator<Object[]> {
	 
    HSSFSheet hssfSheet;
    POIFSFileSystem poifsFileSystem;
    int colFlag = 0;
    int rowFlag = 0;
    int usedRowFlag = 1;
    String[] colName = null;
    FileInputStream intputStream;
    /*
    * ���췽��
    * */
    public ExcelDataProvider(String className,String methodName) throws FileNotFoundException {
        //���ݷŵ�����������
        intputStream = new FileInputStream(this.getPath(className));
        poifsFileSystem = null;
        try {
            poifsFileSystem = new POIFSFileSystem(intputStream);
            //��  EXCEL������
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(poifsFileSystem);
            //��ȡ sheet
            hssfSheet = hssfWorkbook.getSheet(methodName);
            //��ȡһ�ж���
            HSSFRow hssfRow = hssfSheet.getRow(0);
            //��ȡ�ж�����
            colFlag = hssfRow.getPhysicalNumberOfCells();
            //��ȡ�ж�����
            int rows = hssfSheet.getLastRowNum();
            colName = new String[colFlag];
            //��ȡ���е�����
            for (int i = 0; i < colFlag; i++) {
                colName[i] = hssfSheet.getRow(0).getCell(i).toString();
            }
            //��ȡ�ж�����
            for (int r = 1; r <= rows; r++) {
                try {
                    String v = hssfSheet.getRow(r).getCell(0).toString();
                    if (v == null || v.equals("")) {
                        break;
                    }
                } catch (NullPointerException e) {
                    break;
                }
                this.rowFlag++;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
 
    /**
     * �ж��Ƿ�����Ԫ�ؿ��Ե���
     * @return
     */
    @Override
    public boolean hasNext() {
        //��������0 ���� ��һ�������� ���� ��ǰ������С�ڵ��� �����
        if (rowFlag > 0 && hssfSheet.getRow(rowFlag).getCell(0).toString() != "" && usedRowFlag <= rowFlag)
            return true;  //To change body of implemented methods use File | Settings | File Templates.
        else {
            try {
                intputStream.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return false;
        }
    }
 
    /**
     * ���ص�������һ��Ԫ��
     * @return
     */
    @Override
    public Object[] next() {
        Object[] object = new Object[1];
        Map<String, String> map = new LinkedHashMap<String, String>();
        //����������
        for (int c = 0; c < colFlag; c++) {
            String cellValue = "";
            try {
                //��ȡ��Ԫ���ֵ
                cellValue = hssfSheet.getRow(this.usedRowFlag).getCell(c).toString();
            } catch (Exception e) {
                map.put(colName[c], cellValue);
                continue;
            }
            // colName[c]  ��ȡ��ǰ�е���ͷ
            map.put(colName[c], cellValue);
        }
        this.usedRowFlag++;
        object[0] = map;
        return object;  //To change body of implemented methods use File | Settings | File Templates.
    }
 
    /**
     * ɾ��
     */
    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
 
    /**
     * ���TestData.xls�ľ���·��
     * @return
     */
    public String getPath(String className) {
       /* File file = new File("Data");
        String path = file.getAbsolutePath();
        path = path + "\\" + "TestData.xls";
        path="d:\\shengyuan.wang\\����\\test.xls";*/
    	String path=System.getProperty("user.dir")+"/rescoures/net.luculent.liems/"+className+".xls";
        
        return path;
    }
}

