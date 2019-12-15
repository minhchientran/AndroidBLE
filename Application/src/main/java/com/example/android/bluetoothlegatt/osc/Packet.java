package com.example.android.bluetoothlegatt.osc;

final public class Packet {
    public static class Version {
        public static class ReturnedData {
            byte ofc;
            byte major;
            byte minor;
            byte patch;
        }

        public static byte[] getPacket() {
            byte[] pkt = new byte[1];
            pkt[0] = 0x00;
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.major = data[1];
            response.minor = data[2];
            response.patch = data[3];

            return response;
        }
    }

    public static class Vref {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channel;
            int vref;
        }

        public static byte[] getPacket(byte channel) {
            byte[] pkt = new byte[1];
            pkt[0] = 0x01;
            pkt[1] = channel;
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channel = data[2];
            response.vref = (data[3] | (data[4] >> 8) | (data[5] >> 16) | (data[6] >> 24));

            return response;
        }
    }

    public static class Resolution {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channel;
            byte resolution;
        }

        public static byte[] getPacket(byte channel) {
            byte[] pkt = new byte[1];
            pkt[0] = 0x02;
            pkt[1] = channel;
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channel = data[2];
            response.resolution = data[3];

            return response;
        }
    }

    public static class Status {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channelStatus;
        }

        static public byte[] getPacket() {
            byte[] pkt = new byte[1];
            pkt[0] = 0x03;
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channelStatus = data[2];

            return response;
        }
    }

    public static class Enable {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channel;
            byte channelStatus;
        }

        static public byte[] getPacket(byte channel, byte control) {
            byte[] pkt = new byte[1];
            pkt[0] = 0x04;
            pkt[1] = channel;
            pkt[2] = control;
            return pkt;
        }

        static public ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channel = data[2];
            response.channelStatus = data[3];

            return response;
        }
    }

    public static class ReadSample {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channel;
            byte channelStatus;
        }

        public static byte[] getPacket(byte channel, short numberOf) {
            byte[] pkt = new byte[1];
            pkt[0] = 0x05;
            pkt[1] = channel;
            pkt[2] = (byte) (numberOf & 0xff);
            pkt[3] = (byte) ((numberOf >> 8) & 0xff);
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channel = data[2];
            response.channelStatus = data[3];

            return response;
        }
    }

    public static class ReadSampleContinuous {
        public static class ReturnedData {
            byte ofc;
            byte status;
            byte channel;
            byte channelStatus;
        }

        public static byte[] getPacket(byte channel, byte started) {
            byte[] pkt = new byte[1];
            if (started == 1) {
                pkt[0] = 0x06;
            }
            else {
                pkt[0] = 0x07;
            }
            pkt[1] = channel;
            pkt[2] = started;
            return pkt;
        }

        public static ReturnedData getReturnedData(byte[] data) {
            ReturnedData response = new ReturnedData();

            response.ofc = data[0];
            response.status = data[1];
            response.channel = data[2];
            response.channelStatus = data[3];

            return response;
        }
    }
}
