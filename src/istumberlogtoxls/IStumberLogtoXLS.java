/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import static java.awt.PageAttributes.MediaType.D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
        try (Scanner scanner = new Scanner (System.in)) {
            ArrayList<WiFiPoint> points;
            String filepath, outputpath;
            System.out.println("Please enter the path to the log file: ");
            filepath = scanner.nextLine();
            points = rf.read(filepath);
            WriteToXLS xls = new WriteToXLS();
            scanner.reset();
            //doesn't work by now outputpath = scanner.nextLine();
            outputpath = "/Users/philipp/outputwifi.xls";
            xls.createSheet(outputpath);
            xls.writePointsToFile(points);
            xls.closeWorkBook();
            scanner.close();
        }
    }
    
}
