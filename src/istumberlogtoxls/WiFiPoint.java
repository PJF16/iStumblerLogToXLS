/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package istumberlogtoxls;



/**
 *
 * @author Philipp
 */
public class WiFiPoint {
    
    String date;
    String time;
    String type;
    String name;
    String bssid;
    String encryption;
    String location;

    public WiFiPoint(String date, String time, String type, String name, String bssid, String encryption) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.name = name;
        this.bssid = bssid;
        this.encryption = encryption;
        this.location = location;
    }

    WiFiPoint() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBssid() {
        return bssid;
    }

    public void setBssid(String bssid) {
        this.bssid = bssid;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
    
    
    
    
}
