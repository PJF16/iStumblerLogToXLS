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
        Scanner scanner = new Scanner (System.in);
        ArrayList<WiFiPoint> points;
        String filepath;
        System.out.println("Bitte geben Sie den kompletten Pfad zur Logdatei ein: ");
        filepath = scanner.nextLine();
        
        points = rf.read(filepath);
        WriteToXLS xls = new WriteToXLS();
        xls.createSheet();
        xls.writePointsToFile(points);
        xls.closeWorkBook();
    }
    
}
