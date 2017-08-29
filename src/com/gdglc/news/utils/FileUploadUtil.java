package com.gdglc.news.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * 
 * 上传文件的帮助类，用来处理以流的方式提交的请求
 * <p>
 * DOCUMENTME 补充详细描述.
 *
 * @author allan
 * @version $Date: 2017年8月29日 $
 */
public class FileUploadUtil {
	/**
	 * 默认值为1024*300
	 */
	public static long fileSizeMax = 307200l;
	public static long sizeMax = 3072000l;

	private Map<String, List<FileItem>> requestMap;
	private HttpServletRequest request;
	public FileUploadUtil(HttpServletRequest request) throws FileUploadException{
		this.request = request;
		//初始化ServletFileUpload，并设置相关解析过程的配置
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		//设置临时存放文件的路径
		//设置保存在内存的边界值，默认是10KB
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		//设置单个文件最大支持字节数
		servletFileUpload.setFileSizeMax(fileSizeMax);
		//设置全部请求最大支持字节数
		servletFileUpload.setSizeMax(sizeMax);
		//设置头信息处理编码，建议主动设置
		servletFileUpload.setHeaderEncoding("UTF-8");
		//解析请求
		requestMap = servletFileUpload.parseParameterMap(request);
		if(null==requestMap){
			throw new FileUploadException("解析请求出错");
		}
	}
	
	/**
	 * 按表单控件的name获取值
	 * @param name 对应表单name属性
	 * @param requestMap request解析后的map
	 * @return 第一个对应的表单元素值，如果找不到或者有异常返回null
	 */
	public String getParameter(String name){
		List<FileItem> list = requestMap.get(name);
		if(null!=list&&list.size()>0){
			try {
				return list.get(0).getString("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 按表单控件的name获取值
	 * @param name 对应表单name属性
	 * @param requestMap request解析后的map
	 * @return String[] 返回全部对应的表单元素值，如果找不到或者有异常返回null
	 */
	public String[] getParameterValues(String name){
		List<FileItem> list = requestMap.get(name);
		if(null!=list&&list.size()>0){
			String[] values = new String[list.size()];
			int i = 0;
			for (FileItem fileItem : list) {
				try {
					values[i] = fileItem.getString("UTF-8");
					i++;
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return null;
				}
			}
			return values;
		}
		return null;
	}
	
	/**
	 * 
	 * @param name 表单元素名称
	 * @param pathName 保存文件的文件夹，
	 * 	默认保存在当前项目的upload文件夹下面，
	 * 	如果有值，则路径为当前项目路径+pathName，注意该参数不需要开头文件分割符号
	 * @return 保存成功的文件名称集合,如果没有写入任何文件，返回为一个空集合
	 * @throws Exception
	 */
	public List<String> writeFile(String name,String pathName)throws Exception {
		List<String> fileNameList = new ArrayList<String>();
		List<FileItem> list = requestMap.get(name);
		for (FileItem fileItem : list) {
			//获取上传文件的名称
			String fileName = fileItem.getName();
			if(null==fileName||"".equals(fileName)){
				continue;
			}
			String type = fileName.substring(fileName.lastIndexOf('.'));
			//做一个白名单的比较
			if(!StaticInfo.TYPE_MAP.containsKey(type.toLowerCase())){
				System.out.println(fileName+"不符合上传文件格式");
				continue;
			}
			//获取当前项目的真实路径 如：c://
			String realPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println(realPath);
			//创建文件的保存文件夹路径
			if(null==pathName||"".equals(pathName.trim())){
				pathName = "upload";
			}
			File pathFile = new File(realPath+pathName);
			if(!pathFile.exists()){
				//如果原来不存在该文件夹，创建
				pathFile.mkdirs();
			}
			//设置文件路径
			//获取文件名称，使用uuid全球唯一
			String uuid = Uuid.create().toString32();
			StringBuilder writeFileName = new StringBuilder();
			writeFileName.append(uuid).append(type);
			String filePath = realPath+pathName+File.separator+writeFileName;
			fileItem.write(new File(filePath));
			fileNameList.add(writeFileName.toString());
		}
		return fileNameList;
	}
}
