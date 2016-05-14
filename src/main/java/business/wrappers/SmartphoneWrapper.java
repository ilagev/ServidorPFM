package business.wrappers;

import java.util.Date;

public class SmartphoneWrapper {
    
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
    
    public SmartphoneWrapper() {
        super();
    }
    
    

    public SmartphoneWrapper(int id, String modelName, String brandName, Date releaseDate, double screenSize, int resolutionX,
            int resolutionY, int ram, int rom, int battery, double weight, double height, double width, double thickness, boolean gps,
            boolean nfc, boolean bluetooth) {
        super();
        this.id = id;
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

    @Override
    public String toString() {
        return "SmartphoneWrapper [modelName=" + modelName + ", brandName=" + brandName + ", releaseDate=" + releaseDate + ", screenSize="
                + screenSize + ", resolutionX=" + resolutionX + ", resolutionY=" + resolutionY + ", ram=" + ram + ", rom=" + rom
                + ", battery=" + battery + ", weight=" + weight + ", height=" + height + ", width=" + width + ", thickness=" + thickness
                + ", gps=" + gps + ", nfc=" + nfc + ", bluetooth=" + bluetooth + "]";
    }
    
}
