package com.wechat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignUtil {
	private static String token = "WinXinSPFB";

    /**
     * У��ǩ��
     * @param signature ǩ��
     * @param timestamp ʱ���
     * @param nonce �����
     * @return ����ֵ
     */
    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String checktext = null;
        if (null != signature) {
            //��ToKen,timestamp,nonce ���ֵ�����
            String[] paramArr = new String[]{token,timestamp,nonce};
            Arrays.sort(paramArr);
            //�������Ľ��ƴ��һ���ַ���
            String content = paramArr[0].concat(paramArr[1]).concat(paramArr[2]);

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-1");
                //�ԽӺ���ַ�������sha1����
                byte[] digest = md.digest(content.toString().getBytes());
                checktext = byteToStr(digest);
            } catch (NoSuchAlgorithmException e){
                e.printStackTrace();
            }
        }
        //�����ܺ���ַ�����signature���жԱ�
        return checktext !=null ? checktext.equals(signature.toUpperCase()) : false;
    }

    /**
     * ���ֽ�����ת����16�����ַ���
     * @param byteArrays �ַ�����
     * @return �ַ���
     */
    private static String byteToStr(byte[] byteArrays){
        String str = "";
        for (int i = 0; i < byteArrays.length; i++) {
            str += byteToHexStr(byteArrays[i]);
        }
        return str;
    }

    /**
     *  ���ֽ�ת��Ϊʮ�������ַ���
     * @param myByte �ֽ�
     * @return �ַ���
     */
    private static String byteToHexStr(byte myByte) {
        char[] Digit = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        char[] tampArr = new char[2];
        tampArr[0] = Digit[(myByte >>> 4) & 0X0F];
        tampArr[1] = Digit[myByte & 0X0F];
        String str = new String(tampArr);
        return str;
    }

}
