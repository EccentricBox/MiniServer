package com.lcr.applyhelper.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

public class UrlUtil {
	
	public static String sendPost(String url, Map<String, ?> paramMap) {  
	      PrintWriter out = null;  
	      BufferedReader in = null;  
	      String result = "";  
	        
	      String param = "";  
	      Iterator<String> it = paramMap.keySet().iterator();  
	      while(it.hasNext()) {  
	    	  String key = it.next();  
	    	  param += key + "=" + paramMap.get(key) + "&";  
	    	  }  
	  
	      try {  
	          URL realUrl = new URL(url);  
	          // �򿪺�URL֮�������  
	          URLConnection conn = realUrl.openConnection();  
	          // ����ͨ�õ���������  
	          conn.setRequestProperty("accept", "*/*");  
	          conn.setRequestProperty("connection", "Keep-Alive");  
	          conn.setRequestProperty("Accept-Charset", "utf-8");  
	          conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");  
	          // ����POST�������������������  
	          conn.setDoOutput(true);  
	          conn.setDoInput(true);  
	          // ��ȡURLConnection�����Ӧ�������  
	          out = new PrintWriter(conn.getOutputStream());  
	          // �����������  
	          out.print(param);  
	          // flush������Ļ���  
	          out.flush();  
	          // ����BufferedReader����������ȡURL����Ӧ  
	          in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
	          String line;  
	          while ((line = in.readLine()) != null) {  
	              result += line;  
	          }  
	      } catch (Exception e) {  
	        e.printStackTrace(); 
	      }  
	      //ʹ��finally�����ر��������������  
	      finally{  
	          try{  
	              if(out!=null){  
	                  out.close();  
	              }  
	              if(in!=null){  
	                  in.close();  
	              }  
	          }  
	          catch(IOException ex){  
	              ex.printStackTrace();  
	          }  
	      }  
	      return result;  
	  }  
}
