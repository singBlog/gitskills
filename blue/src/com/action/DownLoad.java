package com.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownLoad extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location = "E:\\upload\\1.rar";
		downFile(response,request, location);
	
	}
	private void downFile(HttpServletResponse response, HttpServletRequest request, String location){
	    BufferedInputStream bis = null;
	    try {
	        File file = new File(location);
	        if (file.exists()) {
	            long p = 0L;
	            long toLength = 0L;
	            long contentLength = 0L;
	            int rangeSwitch = 0; // 0,��ͷ��ʼ��ȫ�����أ�1,��ĳ�ֽڿ�ʼ�����أ�bytes=27000-����2,��ĳ�ֽڿ�ʼ��ĳ�ֽڽ��������أ�bytes=27000-39000��
	            long fileLength;
	            String rangBytes = "";
	            fileLength = file.length();
	 
	            // get file content
	            InputStream ins = new FileInputStream(file);
	            bis = new BufferedInputStream(ins);
	 
	            // tell the client to allow accept-ranges
	            response.reset();
	            response.setHeader("Accept-Ranges", "bytes");
	 
	            // client requests a file block download start byte
	            String range = request.getHeader("Range");
	            if (range != null && range.trim().length() > 0 && !"null".equals(range)) {
	                response.setStatus(javax.servlet.http.HttpServletResponse.SC_PARTIAL_CONTENT);
	                rangBytes = range.replaceAll("bytes=", "");
	                if (rangBytes.endsWith("-")) {  // bytes=270000-
	                    rangeSwitch = 1;
	                    p = Long.parseLong(rangBytes.substring(0, rangBytes.indexOf("-")));
	                    contentLength = fileLength - p;  // �ͻ����������270000֮����ֽڣ�����bytes�±�����Ϊ270000���ֽڣ�
	                } else { // bytes=270000-320000
	                    rangeSwitch = 2;
	                    String temp1 = rangBytes.substring(0, rangBytes.indexOf("-"));
	                    String temp2 = rangBytes.substring(rangBytes.indexOf("-") + 1, rangBytes.length());
	                    p = Long.parseLong(temp1);
	                    toLength = Long.parseLong(temp2);
	                    contentLength = toLength - p + 1; // �ͻ���������� 270000-320000 ֮����ֽ�
	                }
	            } else {
	                contentLength = fileLength;
	            }
	 
	            // �����������Content-Length����ͻ��˻��Զ����ж��߳����ء������ϣ��֧�ֶ��̣߳���Ҫ�������������
	            // Content-Length: [�ļ����ܴ�С] - [�ͻ�����������ص��ļ���Ŀ�ʼ�ֽ�]
	            response.setHeader("Content-Length", new Long(contentLength).toString());
	 
	            // �ϵ㿪ʼ
	            // ��Ӧ�ĸ�ʽ��:
	            // Content-Range: bytes [�ļ���Ŀ�ʼ�ֽ�]-[�ļ����ܴ�С - 1]/[�ļ����ܴ�С]
	            if (rangeSwitch == 1) {
	                String contentRange = new StringBuffer("bytes ").append(new Long(p).toString()).append("-")
	                        .append(new Long(fileLength - 1).toString()).append("/")
	                        .append(new Long(fileLength).toString()).toString();
	                response.setHeader("Content-Range", contentRange);
	                bis.skip(p);
	            } else if (rangeSwitch == 2) {
	                String contentRange = range.replace("=", " ") + "/" + new Long(fileLength).toString();
	                response.setHeader("Content-Range", contentRange);
	                bis.skip(p);
	            } else {
	                String contentRange = new StringBuffer("bytes ").append("0-")
	                        .append(fileLength - 1).append("/")
	                        .append(fileLength).toString();
	                response.setHeader("Content-Range", contentRange);
	            }
	 
	            String fileName = file.getName();
	            response.setContentType("application/octet-stream");
	            response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
	 
	            OutputStream out = response.getOutputStream();
	            int n = 0;
	            long readLength = 0;
	            int bsize = 1024;
	            byte[] bytes = new byte[bsize];
	            if (rangeSwitch == 2) {
	                // ��� bytes=27000-39000 �����󣬴�27000��ʼд����                    
	                while (readLength <= contentLength - bsize) {
	                    n = bis.read(bytes);
	                    readLength += n;
	                    out.write(bytes, 0, n);
	                }
	                if (readLength <= contentLength) {
	                    n = bis.read(bytes, 0, (int) (contentLength - readLength));
	                    out.write(bytes, 0, n);
	                }                   
	            } else {
	                while ((n = bis.read(bytes)) != -1) {
	                    out.write(bytes,0,n);                                                      
	                }                   
	            }
	            out.flush();
	            out.close();
	            bis.close();
	        } else {
	        	System.out.println(" location +  not found");
//	            if (logger.isDebugEnabled()) {
//	                logger.debug("Error: file " + location + " not found.");
//	            }                
	        }
	    } catch (IOException ie) {
	        // ���� ClientAbortException ֮����쳣
	    } catch (Exception e) {
	    	e.printStackTrace();
	       // logger.error(e);
	    }
	}
}

