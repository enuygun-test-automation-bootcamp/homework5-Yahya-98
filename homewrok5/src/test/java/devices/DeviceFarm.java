package devices;

public enum DeviceFarm {

    // path the emulator capability
    ANDROID_OREO("src\\test\\resources\\Capabilities");

    public String path;

    DeviceFarm(String path){
        this.path = path;
    }
}
