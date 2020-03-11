package liuhuan.common.utils;

/**
 * 文件工具类
 * @author 83795
 *
 */
public class FileUtil {

	/*
	* 给定一个文件名，返回该文件名的扩展名，例如“aaa.jpg”，返回“.jpg”
	*/
	public static String getExtendName(String fileName){
		
		return fileName.substring(fileName.lastIndexOf("."), fileName.length());
	}
}
