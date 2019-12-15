/**
 * @author Srinidhi Chaturvede
 *
 */
package test.framework.glue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * This class will compare two API responses present in two different file and
 * returns meaningful output in console.
 */
/**
 * @author SCHATUR1
 *
 */
public class ApiResponseComparator {

	private String fileName1 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "filedata" + File.separator + "file1.txt";
	private String fileName2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "filedata" + File.separator + "file2.txt";

	/**
	 * This method is used to store API URL from text file
	 */
	@Given("^Reading and comparing the API URL's from two files and parsing the response body and printing the output in console$")
	public void FileInitiliazation() {
		List<String> file1UrlList = readFileData(fileName1);
		List<String> file2UrlList = readFileData(fileName2);
		try {
			compareUrlResponse(file1UrlList, file2UrlList);
		} catch (Exception e) {
			System.out.println("Exception while processing the program");
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * This method is used to read API URL from text file
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<String> readFileData(String fileName) {
		List<String> urlList = new ArrayList<String>();
		File file = new File(fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			System.out.println("No File found with url data");
		}
		BufferedReader br = new BufferedReader(fr);
		String url;
		try {
			while ((url = br.readLine()) != null) {
				urlList.add(url);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("error while reading url data from file");
		}
		return urlList;
	}

	/**
	 * 
	 * This method is used to compare response of API URL
	 * 
	 * @param file1UrlList
	 * @param file2UrlList
	 * @throws Exception
	 */
	public static void compareUrlResponse(List<String> file1UrlList, List<String> file2UrlList) throws Exception {
		Iterator<String> file1UrlListIterator = file1UrlList.iterator();
		Iterator<String> file2UrlListIterator = file2UrlList.iterator();
		String url1Response;
		String url2Response;
		String url1;
		String url2;
		System.out.println("=======================API Response Comparision Begins=================================");
		while (file1UrlListIterator.hasNext() && file2UrlListIterator.hasNext()) {
			url1 = file1UrlListIterator.next();
			url2 = file2UrlListIterator.next();
			url1Response = getResponseData(url1);
			url2Response = getResponseData(url2);
			if ((null != url1 && !("".equals(url1))) || (null != url2 && !("".equals(url2)))) {
				if (url1Response.equals(url2Response)) {

					System.out.println(url1 + "   Equal   " + url2);
					System.out.println("=========================================================================");
				} else {

					System.out.println(url1 + "  Not Equal  " + url2);
					System.out.println("=========================================================================");
				}
			} else {
				System.out.println("No Api Url Found on both the files");
				System.out.println("=========================================================================");
			}
		}

	}

	/**
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String getResponseData(String url) throws Exception {
		StringBuilder response = new StringBuilder();

		if (null != url && !("".equals(url)) && ((url.startsWith("http:")) || url.startsWith("https:"))) {

			URLConnection connection = new URL(url).openConnection();
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			if (connection.getContentLength() > 2) {

				BufferedReader r = new BufferedReader(
						new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

				String line;
				while ((line = r.readLine()) != null) {
					response.append(line);
				}
			}
		}
		return response.toString();
	}

}
