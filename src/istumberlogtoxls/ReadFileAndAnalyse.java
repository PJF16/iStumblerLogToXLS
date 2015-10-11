/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Philipp
 */
public class ReadFileAndAnalyse {

    private ArrayList<WiFiPoint> pointArray;
    private WiFiPoint point;

    public ReadFileAndAnalyse() {
        this.pointArray = new <WiFiPoint> ArrayList();
    }

    public ArrayList<WiFiPoint> read(String filepath) {
        try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String help = null;
            /* read log line by line */
            if (this.point == null) {
                this.point = new WiFiPoint();
            }
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("WiFiScan") && !strLine.contains("yyyy--MM--dd") && !strLine.contains("width")) {
                    this.point.setDate(strLine.substring(0, 10));
                    this.point.setTime(strLine.substring(11, 19));
                    this.point.setType(strLine.substring(20, strLine.indexOf(",", 20)));
                    help = strLine.substring(strLine.indexOf(",", 21) + 1);
                    this.point.setName(help.substring(0, help.indexOf(",")));
                    help = help.substring(help.indexOf(",") + 1);

                    this.point.setBssid(help.substring(0, help.indexOf(",")));
                    help = help.substring(help.indexOf(",") + 1);

                    this.point.setEncryption(help.substring(0, help.indexOf(",")));
                    help = help.substring(help.indexOf(",") + 1);
                    
                    if (!this.duplicateCheck(point))
                        pointArray.add(new WiFiPoint(point));
                } else if (strLine.contains("LocationUpdate") && !strLine.contains("Restricted")) {
                    this.point.setLocation(strLine.substring(35, 54));
                }
              //testing only
                //System.out.println(point.getName());

            }

            //  System.out.println(help);
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        /*testing
         try {
            
         WriteToXLS xls = new WriteToXLS ();
         xls.createSheet();
            
         xls.writePointsToFile(pointArray);
         xls.closeWorkBook();
         } catch (IOException ex) {
         Logger.getLogger(ReadFileAndAnalyse.class.getName()).log(Level.SEVERE, null, ex);
         } catch (BiffException ex) {
         Logger.getLogger(ReadFileAndAnalyse.class.getName()).log(Level.SEVERE, null, ex);
         } catch (WriteException ex) {
         Logger.getLogger(ReadFileAndAnalyse.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
         //**************/
        return this.pointArray;
    }
    
    public boolean duplicateCheck (WiFiPoint p) {
        for (WiFiPoint check : this.pointArray) {
            if (check.getBssid().equals(p.getBssid())) {
                return true;
            }
        }
        
        return false;
        
    }

}
