/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import static java.awt.PageAttributes.MediaType.D;

/**
 *
 * @author Philipp
 */
public class IStumberLogtoXLS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReadFileAndAnalyse rf = new ReadFileAndAnalyse ();
        rf.read("D:\\downloads\\log.log");
    }
    
}
