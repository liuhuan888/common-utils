package liuhuan.common.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流处理工具类
 * @author 83795
 *
 */
public class StreamUtil {

	/*
	* 批量关闭流，参数能传入无限个。
	* 例如传入FileInputStream对象、JDBC中Connection对象都可以关闭，并且参数个数不限。
	*/
	public static void closeAll(Closeable...closeables){
		try {
			for (Closeable closeable : closeables) {
				if(closeable!=null) {
					closeable.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	* 传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，
	* 要求方法内部调用上面第1个方法关闭流
	*/
	public static String readTextFile(InputStream src) throws IOException{
		int i = 0;
		byte[] b =null;
		if(src!=null) {
			b=new byte[1024];
			while ((i=src.read(b))!=-1) {
				
			}
			closeAll(src);
		}
		
		return new String(b);
	}
	
	
	/*
	* 传入文本文件对象，返回该文件内容，
	* 并且要求内部调用上面第2个方法。
	*/
	public static String readTextFile(File txtFile){
		try {
			String textFile = readTextFile(new FileInputStream(txtFile));
			return textFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
