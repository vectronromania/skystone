//package org.firstinspires.ftc.teamcode.tests;
//
//import java.nio.ByteBuffer;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//public class DetectionTest extends LinearOpMode {
//
//    ByteBuffer buffer = ByteBuffer.allocate(1);
//    I2C sensor;
//
//    public DetectionTest() {
//
//         int COMMAND_REGISTER_BIT = 0x80;
//         int MULTI_BYTE_BIT = 0x20;
//         int ENABLE_REGISTER   = 0x00;
//         int ATIME_REGISTER    = 0x01;
//         int PPULSE_REGISTER   = 0x0E;
//
//        int ID_REGISTER       = 0x12;
//        int CDATA_REGISTER    = 0x14;
//        int RDATA_REGISTER    = 0x16;
//        int GDATA_REGISTER    = 0x18;
//        int BDATA_REGISTER    = 0x1A;
//        int PDATA_REGISTER    = 0x1C;
//
//        public DetectionTest(I2C.Port port) {
//            sensor = new I2C(port, 0x39); //port, I2c address
//
//            sensor.write(COMMAND_REGISTER_BIT | 0x00, 0b00000011);
//        }
//
//        int readWordRegister(int address) {
//            ByteBuffer buf = ByteBuffer.allocate(2);
//            sensor.read(COMMAND_REGISTER_BIT | MULTI_BYTE_BIT | address, 2, buf);
//            buf.order(ByteOrder.LITTLE_ENDIAN);
//            return buf.getShort(0);
//        }
//
//        public int red() {
//            return readWordRegister(RDATA_REGISTER);
//        }
//
//        public int green() {
//            return readWordRegister(GDATA_REGISTER);
//        }
//
//        public int blue() {
//            return readWordRegister(BDATA_REGISTER);
//        }
//
//        public int clear() {
//            return readWordRegister(CDATA_REGISTER);
//        }
//
//        public int proximity() {
//            return readWordRegister(PDATA_REGISTER);
//        }
//
//    @Override
//    public void runOpMode() throws InterruptedException {
//
//    }
//}