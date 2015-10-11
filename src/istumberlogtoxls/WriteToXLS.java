/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author philipp
 */
public class WriteToXLS {

    WritableWorkbook wb;
    WritableSheet sheet;

    public WriteToXLS() throws IOException, BiffException, WriteException {
        //oO Java reports unsafe operation ;-)
        //this.createFile();
    }

    public void createSheet(String outputpath) {
        try {
            this.createFile(outputpath);
        } catch (IOException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createFile(String outputpath) throws IOException, BiffException, WriteException {
        this.wb = Workbook.createWorkbook(new File(outputpath));
        this.sheet = wb.createSheet("WiFi Points", 0);

        Label date = new Label(0, 0, "Date");
        sheet.addCell(date);

        Label time = new Label(1, 0, "Time");
        sheet.addCell(time);

        Label type = new Label(2, 0, "Type");
        sheet.addCell(type);

        Label name = new Label(3, 0, "Name");
        sheet.addCell(name);

        Label bssid = new Label(4, 0, "BSSID");
        sheet.addCell(bssid);

        Label encryption = new Label(5, 0, "Encryption");
        sheet.addCell(encryption);

        Label location = new Label(6, 0, "Location");
        sheet.addCell(location);

        // wb.write();
    }

    public void writePointsToFile(ArrayList<WiFiPoint> pointArray) throws WriteException {
        try {
            int rowCount = 1;
            Label date, time, name, bssid, encryption, location;
            for (WiFiPoint p : pointArray) {
                sheet.addCell(new Label(0, rowCount, p.getDate()));
                sheet.addCell(new Label(1, rowCount, p.getTime()));
                sheet.addCell(new Label(2, rowCount, p.getType()));
                sheet.addCell(new Label(3, rowCount, p.getName()));
                sheet.addCell(new Label(4, rowCount, p.getBssid()));
                sheet.addCell(new Label(5, rowCount, p.getEncryption()));
                sheet.addCell(new Label(6, rowCount, p.getLocation()));
               //testing only
                //System.out.println(rowCount);

                rowCount++;
            }
            this.wb.write();
        } catch (IOException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeWorkBook() {
        try {
            this.wb.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(WriteToXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
