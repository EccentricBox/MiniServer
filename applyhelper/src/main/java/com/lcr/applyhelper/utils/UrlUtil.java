package com.lcr.applyhelper.utils;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
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

	public static String sendGet(String url, String param) {
		String result = "";
		StringBuilder jsonStr = new StringBuilder();
		BufferedReader in = null;
		try {
			String urlNameString = url + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}

			//ConstantUtil.UTF_CODE 编码格式
			InputStreamReader reader = new InputStreamReader(connection.getInputStream(), "utf-8");
			char[] buff = new char[1024];
			int length = 0;
			while ((length = reader.read(buff)) != -1) {
				result = new String(buff, 0, length);
				jsonStr.append(result);
			}


			Gson gson = new Gson();
			Map temp  = gson.fromJson("", Map.class);

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return jsonStr.toString();
	}
}
