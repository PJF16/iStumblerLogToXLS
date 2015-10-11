/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import static java.awt.PageAttributes.MediaType.D;
import java.io.IOException;
import java.util.ArrayList;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

/**
 *
 * @author Philipp
 */
public class IStumberLogtoXLS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, BiffException, WriteException {
        ReadFileAndAnalyse rf = new ReadFileAndAnalyse ();
        ArrayList<WiFiPoint> points;
        points = rf.read("D:\\downloads\\log.log");
        WriteToXLS xls = new WriteToXLS();
        xls.createSheet();
        xls.writePointsToFile(points);
        xls.closeWorkBook();
    }
    
}
