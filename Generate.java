package qifengle.javaProgram;
//import java.util.ArrayList;

public class Generate {

    static final int PARA = 3;
    // 1/4音的长度
    static int[] fullLength = { 10, 12, 13, 14, 16, 18, 20, 20, 24, 26, 28, 31, 35, 40, 42, 47, 53, 56, 63, 70, 79 };
    // 0x代表低音，1x代表中音，2x代表高音
    static int[] soundtone = { 12, 11, 12, 11, 12, 13, 15, 13, 12, 12, 11, 12, 11, 12, 13, 12, 11, 5, 12, 11, 12, 11,
            12, 13, 15, 13, 12, 12, 13, 12, 11, 12, 12, 12, 12, 11, 12, 11, 12, 13, 15, 13, 12, 12, 13, 12, 11, 6, 6,
            13, 12, 11, 12, 11, 13, 12, 11, 12, 11, 5, 13, 12, 11, 12, 11, 11, 11, 12, 13, 11, 16, 15, 16, 16, 11, 17,
            16, 17, 17, 17, 16, 17, 17, 13, 21, 22, 21, 17, 16, 15, 16, 15, 16, 16, 15, 16, 15, 16, 15, 12, 12, 15, 13,
            13, 13, 11, 12, 13, 11, 16, 15, 16, 16, 11, 17, 16, 17, 17, 17, 16, 16, 16, 13, 21, 22, 21, 17, 16, 15, 16,
            23, 23, 23, 15, 16, 23, 23, 23, 15, 16, 16, 16, 16, 21, 22, 23, 26, 25, 25, 26, 25, 25, 26, 25, 25, 22, 23,
            23, 26, 25, 25, 26, 25, 25, 26, 25, 25, 22, 23, 22, 21, 16, 16, 21, 21, 22, 21, 16, 16, 21, 23, 23, 24, 23,
            22, 23, 22, 21, 22, 23, 26, 25, 25, 26, 25, 25, 26, 25, 25, 23, 23, 26, 25, 25, 26, 25, 25, 26, 25, 25, 23,
            22, 21, 16, 16, 23, 22, 21, 16, 16, 21, 21, 21, 21, 16, 23, 22, 21, 16, 16, 23, 22, 22, 21, 16, 16, 21, 21, 21, 21, 21};
    // { 7, 11, 12, 13, 3, 15, 3, 2, 5, 12, 7, 11, 12, 12, 2, 15, 13, 12, 13, 11,
    // 12, 7, 11, 5, 7,
    // 11, 12, 13, 3, 15, 13, 2, 5, 12, 7, 11, 12, 13, 2, 15, 13, 12, 13, 11, 12, 7,
    // 11, 5, 7, 11, 12, 13, 3, 15,
    // 13, 2, 5, 12, 7, 11, 12, 13, 2, 15, 13, 12, 13, 11, 12, 7, 11, 5, 7, 11, 12,
    // 13, 3, 15, 13, 2, 5, 12, 12,
    // 12, 11, 11 };
    static int[] actualLength = { 3, 1, 3, 1, 2, 2, 2, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 4, 3, 1, 3, 1, 2, 2, 2, 1, 1, 3, 1,
            2, 1, 1, 4, 4, 3, 1, 3, 1, 2, 2, 2, 1, 1, 3, 1, 2, 1, 1, 4, 1, 1, 1, 1, 4, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 4,
            4, 2, 2, 2, 2, 2, 1, 1, 3, 1, 2, 1, 1, 4, 2, 1, 1, 3, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2,
            1, 1, 4, 4, 2, 2, 2, 2, 2, 1, 1, 3, 1, 2, 1, 1, 4, 2, 1, 1, 3, 1, 1, 1, 1, 1, 2, 2, 2, 1, 1, 2, 2, 2, 1, 1,
            2, 1, 1, 4, 4, 4, 2, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2,
            1, 1, 1, 1, 2, 1, 3, 4, 1, 1, 1, 1, 1, 3, 2, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1, 2, 2, 2, 1, 1, 2, 1, 1, 2, 1, 1,
            1, 3, 2, 1, 1, 1, 3, 1, 1, 2, 1, 3, 4, 4, 4, 1, 3, 2, 1, 1, 1, 2, 1, 1, 2, 1, 2, 2, 4, 4, 4, 4 };
    // { 1, 1, 1, 1, 2, 1, 1, 2, 2, 4, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1,
    // 1, 1, 1, 2,
    // 1, 1, 2, 2, 4, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1,
    // 2, 2, 4, 1, 1, 1, 1, 2, 1, 1,
    // 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 4, 4, 4, 4, 4 };

    public static void main(String[] args) {
        if (soundtone.length != actualLength.length) {
            System.out.println("soundtone length: " + soundtone.length);
            System.out.println("actualLength length: " + actualLength.length);
            System.out.println("长度不相等，请检查数组");
        } else {
            System.out.println("soundtone length: " + soundtone.length);
            System.out.println("actualLength length:" + actualLength.length);
            int arrayLength = soundtone.length;
            int[] outputSound = new int[arrayLength];
            int[] outputLength = new int[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                // 首先要把soundtone转换成标准输入：从低八度0-6开始到中八度7-13到高八度14-20
                int temp = soundtone[i];
                if (temp < 9) {
                    // 低音
                    outputSound[i] = temp - 1; // soundtone 是从1开始
                } else if (temp < 19) {
                    // 中音
                    outputSound[i] = temp - 4; // (temp-10)+7-1
                } else {
                    // 高音
                    outputSound[i] = temp - 7; // (temp-20)+14-1
                }
                // 根据outputSound和fulllength还有actualLength 算出持续时间
                int sound = outputSound[i];
                // 如果actuallylength是1的话代表1/4以此类推。一个声音的真正持续时间应该是
                // (actualLenth[i])*fullLength[sound];
                outputLength[i] = actualLength[i] * fullLength[sound] * PARA;
            }
            // 转换完成
            // 打印outputSound
            System.out.print("\n\nsound output: \n{");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print(outputSound[i] + ",");
            }
            System.out.print("}\n\n");

            System.out.print("length output: \n{");
            for (int i = 0; i < arrayLength; i++) {
                System.out.print(outputLength[i] + ",");
            }
            System.out.print("}\n");
            System.out.print("please delete the last ',' when copy :D");
        }
    }
}