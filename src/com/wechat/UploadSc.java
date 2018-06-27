package com.wechat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import net.sf.json.JSONObject;

import com.entity.AccessToken;

public class UploadSc {

	/**
	 * �ϴ����������ز�(ͼƬ�زĵ�����Ϊ5000����������Ϊ1000)
	 *
	 * @return
	 * @throws Exception
	 */
	public static JSONObject addMaterialEver(String fileurl, String type, String token) {
	    try {
	        File file = new File(fileurl);
	        //�ϴ��ز�
	        String path = CommonConstant.ADD_SC_URL.replace("ACCESS_TOKEN", token).replace("TYPE", type);
	        String result = connectHttpsByPost(path, null, file);
	        result = result.replaceAll("[\\\\]", "");
	        System.out.println("result:" + result);
	        JSONObject resultJSON = JSONObject.fromObject(result);
	        if (resultJSON != null) {
	            if (resultJSON.get("media_id") != null) {
	                System.out.println("�ϴ�" + type + "�����زĳɹ�");
	                return resultJSON;
	            } else {
	                System.out.println("�ϴ�" + type + "�����ز�ʧ��");
	            }
	        }
	        return null;
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } catch (NoSuchProviderException e) {
	        e.printStackTrace();
	    } catch (KeyManagementException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public static  String connectHttpsByPost(String path, String KK, File file) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
	    URL urlObj = new URL(path);
	    //����
	    HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
	    String result = null;
	    con.setDoInput(true);

	    con.setDoOutput(true);

	    con.setUseCaches(false); // post��ʽ����ʹ�û���

	    // ��������ͷ��Ϣ
	    con.setRequestProperty("Connection", "Keep-Alive");
	    con.setRequestProperty("Charset", "UTF-8");
	    // ���ñ߽�
	    String BOUNDARY = "----------" + System.currentTimeMillis();
	    con.setRequestProperty("Content-Type",
	            "multipart/form-data; boundary="
	                    + BOUNDARY);

	    // ����������Ϣ
	    // ��һ���֣�
	    StringBuilder sb = new StringBuilder();
	    sb.append("--"); // �����������
	    sb.append(BOUNDARY);
	    sb.append("\r\n");
	    sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length() + "\";filename=\""

	            + file.getName() + "\"\r\n");
	    sb.append("Content-Type:application/octet-stream\r\n\r\n");
	    byte[] head = sb.toString().getBytes("utf-8");
	    // ��������
	    OutputStream out = new DataOutputStream(con.getOutputStream());
	    // �����ͷ
	    out.write(head);

	    // �ļ����Ĳ���
	    // ���ļ������ļ��ķ�ʽ ���뵽url��
	    DataInputStream in = new DataInputStream(new FileInputStream(file));
	    int bytes = 0;
	    byte[] bufferOut = new byte[1024];
	    while ((bytes = in.read(bufferOut)) != -1) {
	        out.write(bufferOut, 0, bytes);
	    }
	    in.close();
	    // ��β����
	    byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// ����������ݷָ���
	    out.write(foot);
	    out.flush();
	    out.close();
	    StringBuffer buffer = new StringBuffer();
	    BufferedReader reader = null;
	    try {
	        // ����BufferedReader����������ȡURL����Ӧ
	        reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            buffer.append(line);
	        }
	        if (result == null) {
	            result = buffer.toString();
	        }
	    } catch (IOException e) {
	        System.out.println("����POST��������쳣��" + e);
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            reader.close();
	        }
	    }
	    return result;
	}
	
	
	public static void main(String[] args) {
	    try {

	        AccessToken token=CommonMethod.getAccessToken();
//	        String path = "E:/china.jpg";
//	        String path = "E:/shanxi.jpg";
//	        String path = "E:/taiyuan.jpg";
	        String path = "E:/changzhi.jpg";
	        
	        JSONObject object = addMaterialEver(path,"image",token.getToken());
	        System.out.println(object.toString());
	    } catch (Exception e) {
	        System.out.println("---");
	    }
}
}
