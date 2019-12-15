package com.example.android.bluetoothlegatt.osc;

final public class Information {
    public class Version {
        byte major;
        byte minor;
        byte patch;
    }

    private static Information info;

    private Version version;

    private Information() {
        version = new Version();
        version.major = 0;
        version.minor = 0;
        version.patch = 0;
    }

    public static Information getInstance() {
        if (info == null) {
            info = new Information();
        }
        return info;
    }

    public Version getVersion(){
        return version;
    }

    public void setVersion(Version ver) {
        version = ver;
    }
}
