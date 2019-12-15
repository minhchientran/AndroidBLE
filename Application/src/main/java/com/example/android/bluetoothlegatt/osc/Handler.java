package com.example.android.bluetoothlegatt.osc;

public class Handler <T extends BluetoothOSC> {
    private Information info;
    private T instance;
    public Handler(T var) {
        instance = var;
    }
    public void getVersion() {
        byte[] packet = Packet.Version.getPacket();
        instance.write(packet);
    }

    public void getVref(byte channel) {
        byte[] packet = Packet.Vref.getPacket(channel);
        instance.write(packet);
    }

    public void getResolution(byte channel) {
        byte[] packet = Packet.Resolution.getPacket(channel);
        instance.write(packet);
    }

    public void getStatus() {
        byte[] packet = Packet.Status.getPacket();
        instance.write(packet);
    }


    public void enableChannel(byte channel, byte control) {
        byte[] packet = Packet.Enable.getPacket(channel, control);
        instance.write(packet);
    }

    public void readSample(byte channel, short numberOf) {
        byte[] packet = Packet.ReadSample.getPacket(channel, numberOf);
        instance.write(packet);
    }

    public void readSampleCont(byte channel, byte started) {
        byte[] packet = Packet.ReadSample.getPacket(channel, started);
        instance.write(packet);
    }
}
