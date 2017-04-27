package cn.tst.sbjxzzglxt.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 业务类基类
 *
 * @author ps_xy@pscp.co.jp
 */
public class SecurityUtils {

    /**
     * MD5 加密函数
     *
     * @param plainText 要加密的字符串
     * @return
     */
    public static String MD5(String plainText) {

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            //System.out.println("result: " + buf.toString());//32位的加密
            //System.out.println("result: " + buf.toString().substring(8, 24));//16位的加密
            return buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 生成随机密码
     *
     * @return 随机密码
     */
    public static String generateRandomPassword() {
        /// TODO 根据具体情况修改回来
//        SecureRandom random = new SecureRandom();
//        return new BigInteger(130, random).toString(32).substring(0, 10);
        return SepC.DEFAULT_LOGIN_PASSWORD;
    }
}
