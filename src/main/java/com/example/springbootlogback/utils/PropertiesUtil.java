package com.example.springbootlogback.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties getFileProperties(String filePath) {
		Properties prop = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			prop.load(in);
		} catch (Exception e) {
			return null;
		} finally {
			close(in);
		}
		return prop;
	}

	public static Properties getSourceProperties(String sourcePath) {
		Properties prop = new Properties();
		InputStream in = null;
		String savePath = PropertiesUtil.class.getResource(sourcePath).getPath();
		try {
			in = new BufferedInputStream(new FileInputStream(savePath));
			prop.load(in);
		} catch (Exception e) {
			return null;
		} finally {
			close(in);
		}
		return prop;
	}

	private static void close(InputStream stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
			}
		}
	}
}