package com.utils;

/**
 * Created by Administrator on 2017/3/21.
 */
public class HexUtil {
    /**
     * 16进制 To byte[]<br>
     * fix byte[] en_pwd = new BigInteger(pwd, 16).toByteArray();这行代码生成的字节数组位数不固定，会导致后面的解密失败
     * 秘文传过来一共有256个字符，通过上面的代码转成字节数组，同样的明文，有时传过来转成的字节数组长度为128，有的时候却又是129
     *
     * @param hexString
     * @return byte[]
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }


    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
