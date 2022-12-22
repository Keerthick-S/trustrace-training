package Main.java;
import java.sql.SQLOutput;
import java.util.*;
public class Main {
    public static <objName> void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for Smartphone and 2 for KeypadPhone");
        int num1 = sc.nextInt();
        System.out.println("Enter the given Details");
        System.out.println("Enter the Camera Pixels");
        int camPixel = sc.nextInt();
        System.out.println("Enter the Storage In Kilobytes");
        int storageValue = sc.nextInt();
        System.out.println("Enter the batteryCapacity");
        int batteryCapacity = sc.nextInt();
        System.out.println("Enter the DisplaySize");
        float displaySize = sc.nextInt();
        System.out.println("Enter the Charge Type");
        String chargeType = sc.next();

        if(num1 == 1) {
            System.out.println("Enter True or False for FingerPrint");
            boolean fingerprintSensor = sc.nextBoolean();
            System.out.println("Enter the Operating System");
            String OS = sc.next();
            smartPhoneSetDetail(camPixel,storageValue,batteryCapacity,displaySize,chargeType,fingerprintSensor,OS);
        }
        else {
            System.out.println("Enter True or False for Speeed dial");
            boolean speedDial = sc.nextBoolean();
            keypadPhoneSetDetail(camPixel,storageValue,batteryCapacity,displaySize,chargeType,speedDial);
        }
    }
    public static void smartPhoneSetDetail(int camPixel,int storageValue,int batteryCapacity,float displaySize,String chargeType,boolean fingerPrint,String OS) {
        SmartPhone smartphone = new SmartPhone();
        smartphone.setCameraPixel(camPixel);
        smartphone.setStorage(storageValue);
        smartphone.setBattery(batteryCapacity);
        smartphone.setScreenSize(displaySize);
        smartphone.setChargerType(chargeType);
        smartphone.setFingerPrintSensor(fingerPrint);
    }
    public static void keypadPhoneSetDetail(int camPixel,int storageValue,int batteryCapacity,float displaySize,String chargeType,boolean speedDial ) {
        Phone keypadphone = new KeypadPhone();
        KeypadPhone keypadPhone = new KeypadPhone();
        keypadPhone.setCameraPixel(camPixel);
        keypadPhone.setStorage(storageValue);
        keypadPhone.setBattery(batteryCapacity);
        keypadPhone.setScreenSize(displaySize);
        keypadPhone.setChargerType(chargeType);
        keypadPhone.setSpeedDial(speedDial);
    }
}
