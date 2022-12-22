package Main.java;
public class Phone {
    private int cameraPixel;
    private int storageInKilobytes;
    private int batteryCapacity;
    private float screenSize;
    private String chargerType;
    public void setCameraPixel(int cameraPixel) {
        this.cameraPixel = cameraPixel;
    }
    public void setStorage(int storage) {
        this.storageInKilobytes = storage;
    }
    public void setBattery(int battery) {
        this.batteryCapacity = battery;
    }
    public void setScreenSize(float screenSize) {
        this.screenSize = screenSize;
    }
    public void setChargerType(String chargerType) {
        this.chargerType = chargerType;
    }
    public int getCameraPixel() {
        return this.cameraPixel;
    }
    public int getStorage() {
        return this.storageInKilobytes;
    }
    public int getBattery() {
        return this.batteryCapacity;
    }
    public float getScreenSize() {
        return  this.screenSize;
    }
    public String getChargerType() {
        return this.chargerType;
    }
    public void isRamExtension() {
        System.out.println("Ram Cannot be Extend");
    }
}
