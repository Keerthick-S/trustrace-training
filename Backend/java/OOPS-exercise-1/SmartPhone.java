package Main.java;

public class SmartPhone extends Phone{
    private boolean fingerPrintSensor;
    private String operatingSystem;
    public void setFingerPrintSensor(boolean fingerPrintSensor) {
        this.fingerPrintSensor = fingerPrintSensor;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public boolean isFingerPrintSensor() {
        return fingerPrintSensor;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }

}
