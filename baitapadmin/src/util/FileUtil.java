package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileUtil {
	public static String upload(String nameInput, HttpServletRequest request) throws IOException, ServletException {
		Part filePart = request.getPart(nameInput);
		String fileName = filePart.getSubmittedFileName();
		if (!fileName.equals("")) {
			String dirPath = request.getServletContext().getRealPath("/images/hoa");
			File saveDir = new File(dirPath);
			if (!saveDir.exists()) {
				saveDir.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			filePart.write(filePath);
		}
		return fileName;
	}
	public static boolean delFile(String fileName, HttpServletRequest request) {
		if(!fileName.equals("")) {
			String filePath = request.getServletContext().getRealPath("/images/hoa") + File.separator + fileName;
			File file = new File(filePath);
			return file.delete();
		}
		return false;
	}
}
