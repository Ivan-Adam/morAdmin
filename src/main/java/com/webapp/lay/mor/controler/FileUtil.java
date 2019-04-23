package com.webapp.lay.mor.controler;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@WebServlet("/file")
public class FileUtil {
    public static String fileUpload(HttpServletRequest request, HttpServlet servlet, String fileType) {
        String savePath = null;

        //这里的代码是我为了把文件分类保存到不同的文件夹中
        if (fileType.equals("Video")){
		    savePath = servlet.getServletContext().getRealPath("\\WEB-INF\\upload\\") + "\\" + fileType;
        } else{
            savePath = servlet.getServletContext().getRealPath("\\WEB-INF\\upload\\office\\") + "\\" + fileType;
        }

        File file = new File(savePath);
        if (!file.exists() && !file.isDirectory()) {
		    file.mkdir();
        }
        String fileName = null;
        try {
            Collection<Part> parts = request.getParts();
		    if (parts.size() == 1) {
		        Part part = request.getPart("file");
                String header = part.getHeader("content-disposition");
                fileName =getFileName(header);
                part.write(savePath + File.separator + fileName);
		    } else {
                for (Part part : parts) {
			        String header = part.getHeader("content-disposition");
			        if(header.indexOf("filename") != -1) {
			            fileName = getFileName(header);
			            part.write(savePath + File.separator + fileName);
			        }
		        }
		    }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
		    e.printStackTrace();
        }
	    return (savePath + "\\" + fileName);
    }


    public static String getFileName(String header) {//这个方法通过header获取文件的名字
	    String fileName = null;
	    fileName = header.substring(header.indexOf("filename") + 2 + "filename".length(), header.length() - 1);
	    return fileName;
    }
}