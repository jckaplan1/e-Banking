package com.inetBanking.testUtilties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File file = new File("./Configuration/Config.properties");

		try {
			FileInputStream src = new FileInputStream(file);
			pro = new Properties();
			pro.load(src);

		} catch (Exception e) {
			System.out.println("Exception error is " + e.getMessage());
		}

	}

	public String getBaseUrl() {
		String baseUrl = pro.getProperty("baseurl");
		return baseUrl;
	}

	public String getUserName() {
		String Username = pro.getProperty("username");
		return Username;
	}

	public String getPassword() {
		String UserPasword = pro.getProperty("password");
		return UserPasword;
	}
}
