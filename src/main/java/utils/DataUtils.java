package utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


public class DataUtils {
	
	public static String getRequestPostStr(HttpServletRequest request)
			throws IOException {

		byte buffer[] = getRequestPostBytes(request);
		String charEncoding = request.getCharacterEncoding();
		if (charEncoding == null) {
			charEncoding = "UTF-8";
		}
		return new String(buffer, charEncoding);
	}
	
//	public static  getPostJsonObject(String jsonStr){
//		
//	}


	public static void printRequestBodyStr(String tag, HttpServletRequest request){
		try {
			System.out.println("TAG: " + tag);
			System.out.println("RequestPostString: " + DataUtils.getRequestPostStr(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printData(String key, String value){
//		System.out.println("key: " + key + ", value: " + value);
		System.out.println("{\"" + key + "\":" + "\"" + value + "\"}");
	}
	
	private static byte[] getRequestPostBytes(HttpServletRequest request) throws IOException{
		int contentLength = request.getContentLength();
		if(contentLength<0){
			return null;
		}
		byte buffer[] = new byte[contentLength];
		for (int i = 0; i < contentLength;) {

			int readlen = request.getInputStream().read(buffer, i,
					contentLength - i);
			if (readlen == -1) {
				break;
			}
			i += readlen;
		}
		return buffer;
	}

}
