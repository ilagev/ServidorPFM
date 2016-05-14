package data.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Smartphone {
    
    @Id
    @GeneratedValue
    private int id;
        
    private String modelName;
    private String brandName;
    private Date releaseDate;
    private double screenSize;
    private int resolutionX;
    private int resolutionY;
    private int ram;
    private int rom;
    private int battery;
    private double weight;
    private double height;
    private double width;
    private double thickness;
    private boolean gps;
    private boolean nfc;
    private boolean bluetooth;
    
    @ManyToOne
    private User creator;
    
    public Smartphone() {
        
    }
    
    public Smartphone(String modelName, String brandName, Date releaseDate, double screenSize, int resolutionX, int resolutionY, int ram,
            int rom, int battery, double weight, double height, double width, double thickness, boolean gps, boolean nfc,
            boolean bluetooth) {
        super();
        this.modelName = modelName;
        this.brandName = brandName;
        this.releaseDate = releaseDate;
        this.screenSize = screenSize;
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        this.ram = ram;
        this.rom = rom;
        this.battery = battery;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        this.gps = gps;
        this.nfc = nfc;
        this.bluetooth = bluetooth;
    }

    public String getModelName() {
        return modelName;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    
    public String getBrandName() {
        return brandName;
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public double getScreenSize() {
        return screenSize;
    }
    
    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
    
    public int getResolutionX() {
        return resolutionX;
    }
    
    public void setResolutionX(int resolutionX) {
        this.resolutionX = resolutionX;
    }
    
    public int getResolutionY() {
        return resolutionY;
    }
    
    public void setResolutionY(int resolutionY) {
        this.resolutionY = resolutionY;
    }
    
    public int getRam() {
        return ram;
    }
    
    public void setRam(int ram) {
        this.ram = ram;
    }
    
    public int getRom() {
        return rom;
    }
    
    public void setRom(int rom) {
        this.rom = rom;
    }
    
    public int getBattery() {
        return battery;
    }
    
    public void setBattery(int battery) {
        this.battery = battery;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        this.width = width;
    }
    
    public double getThickness() {
        return thickness;
    }
    
    public void setThickness(double thickness) {
        this.thickness = thickness;
    }
    
    public boolean isGps() {
        return gps;
    }
    
    public void setGps(boolean gps) {
        this.gps = gps;
    }
    
    public boolean isNfc() {
        return nfc;
    }
    
    public void setNfc(boolean nfc) {
        this.nfc = nfc;
    }
    
    public boolean isBluetooth() {
        return bluetooth;
    }
    
    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + battery;
        result = prime * result + (bluetooth ? 1231 : 1237);
        result = prime * result + ((brandName == null) ? 0 : brandName.hashCode());
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
        result = prime * result + (gps ? 1231 : 1237);
        long temp;
        temp = Double.doubleToLongBits(height);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + id;
        result = prime * result + ((modelName == null) ? 0 : modelName.hashCode());
        result = prime * result + (nfc ? 1231 : 1237);
        result = prime * result + ram;
        result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        result = prime * result + resolutionX;
        result = prime * result + resolutionY;
        result = prime * result + rom;
        temp = Double.doubleToLongBits(screenSize);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(thickness);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Smartphone other = (Smartphone) obj;
        if (battery != other.battery)
            return false;
        if (bluetooth != other.bluetooth)
            return false;
        if (brandName == null) {
            if (other.brandName != null)
                return false;
        } else if (!brandName.equals(other.brandName))
            return false;
        if (creator == null) {
            if (other.creator != null)
                return false;
        } else if (!creator.equals(other.creator))
            return false;
        if (gps != other.gps)
            return false;
        if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
            return false;
        if (id != other.id)
            return false;
        if (modelName == null) {
            if (other.modelName != null)
                return false;
        } else if (!modelName.equals(other.modelName))
            return false;
        if (nfc != other.nfc)
            return false;
        if (ram != other.ram)
            return false;
        if (releaseDate == null) {
            if (other.releaseDate != null)
                return false;
        } else if (!releaseDate.equals(other.releaseDate))
            return false;
        if (resolutionX != other.resolutionX)
            return false;
        if (resolutionY != other.resolutionY)
            return false;
        if (rom != other.rom)
            return false;
        if (Double.doubleToLongBits(screenSize) != Double.doubleToLongBits(other.screenSize))
            return false;
        if (Double.doubleToLongBits(thickness) != Double.doubleToLongBits(other.thickness))
            return false;
        if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
            return false;
        if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Smartphone [id=" + id + ", modelName=" + modelName + ", brandName=" + brandName + ", releaseDate=" + releaseDate
                + ", screenSize=" + screenSize + ", resolutionX=" + resolutionX + ", resolutionY=" + resolutionY + ", ram=" + ram + ", rom="
                + rom + ", battery=" + battery + ", weight=" + weight + ", height=" + height + ", width=" + width + ", thickness="
                + thickness + ", gps=" + gps + ", nfc=" + nfc + ", bluetooth=" + bluetooth + ", creator=" + creator + "]";
    }
    
    

}
