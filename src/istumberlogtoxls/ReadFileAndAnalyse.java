/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.util.ArrayList;

/**
 *
 * @author Philipp
 */
public class ReadFileAndAnalyse {

    private ArrayList <WiFiPoint> pointArray;
    private WiFiPoint point;
    
    public ReadFileAndAnalyse () {
        this.pointArray=new <WiFiPoint> ArrayList();
    }
    public void read(String filepath) {
        try {
            FileInputStream fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            String help=null;
            /* read log line by line */
            if (this.point == null) 
                this.point=new WiFiPoint();
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains("WiFiScan") && !strLine.contains("yyyy--MM--DD")){
                this.point.setDate(strLine.substring(0, 10));
                this.point.setTime(strLine.substring (11,19));
                this.point.setType(strLine.substring (20,strLine.indexOf(",", 20)));
                help = strLine.substring(strLine.indexOf(",",21)+1);
                this.point.setName(help.substring(0,help.indexOf(",")));
                help = help.substring(help.indexOf(",")+1);
                
                this.point.setBssid(help.substring(0,help.indexOf(",")));
                help = help.substring(help.indexOf(",")+1);
                
                this.point.setEncryption(help.substring(0,help.indexOf(",")));
                help = help.substring(help.indexOf(",")+1);
                }
                else if (strLine.contains("LocationUpdate")) {
                    this.point.setLocation(strLine.substring(35,54));
                }
            
            System.out.println(this.point.getDate());
            System.out.println(this.point.getTime());
            System.out.println(this.point.getType());
            System.out.println(this.point.getName());
            System.out.println(this.point.getBssid());
            System.out.println(this.point.getLocation());
            
                
            }
            System.out.println(this.point.getDate());
            System.out.println(this.point.getTime());
            System.out.println(this.point.getType());
            System.out.println(this.point.getName());
            System.out.println(this.point.getBssid());
            System.out.println(this.point.getLocation());
          //  System.out.println(help);
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
