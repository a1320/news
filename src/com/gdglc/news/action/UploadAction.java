package com.gdglc.news.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.gdglc.news.utils.StaticInfo;
import com.gdglc.news.utils.Uuid;

public class UploadAction extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		//获取临时存放文件的路径
		System.out.println("临时存放文件的路径"+fileItemFactory.getRepository());
		System.out.println(System.getProperty("java.io.tmpdir"));
		//获取保存在内存的边界值
		System.out.println("内存的边界值"+fileItemFactory.getSizeThreshold());
		ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
		//servletFileUpload.parseRequest(new RequestContext)
		//设置单个文件最大支持字节数
		servletFileUpload.setFileSizeMax(1024*300);
		//设置全部请求最大支持字节数
		servletFileUpload.setSizeMax(1024*3000);
		servletFileUpload.getHeaderEncoding();
		//设置头信息处理编码，建议主动设置
		servletFileUpload.setHeaderEncoding("UTF-8");
		System.out.println(System.getProperty("file.encoding"));
		try {
			Map<String, List<FileItem>> requestMap = servletFileUpload.parseParameterMap(request);
			String name = getParameter("name", requestMap);
			System.out.println(name);
			String[] values = getParameterValues("name", requestMap);
			System.out.println(values);
			for (String value : values) {
				System.out.println(value);
			}
			List<String> fileNameList = writeFile("uploadFile",requestMap);
			for (String item : fileNameList) {
				System.out.println(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<String> writeFile(String name,Map<String, List<FileItem>> requestMap)throws Exception {
		List<String> fileNameList = new ArrayList<String>();
		List<FileItem> list = requestMap.get(name);
		for (FileItem fileItem : list) {
			//获取上传文件的名称
			String fileName = fileItem.getName();
			if(null==fileName||"".equals(fileName)){
				continue;
			}
			//获取上传文件的mime类型
			String contentType = fileItem.getContentType();
			System.out.println("fileName:"+fileName);
			System.out.println("contentType:"+contentType);
			//获取当前项目的真实路径 如：c://
			String realPath = getServletContext().getRealPath("/");
			System.out.println(realPath);
			//创建文件的保存文件夹路径
			File pathFile = new File(realPath+"image");
			if(!pathFile.exists()){
				//如果原来不存在该文件夹，创建
				pathFile.mkdirs();
			}
			//设置文件路径
			String uuid = Uuid.create().toString32();
			String type = fileName.substring(fileName.lastIndexOf('.'));
			//做一个白名单的比较
			if(!StaticInfo.TYPE_MAP.containsKey(type.toLowerCase())){
				continue;
			}
			StringBuilder writeFileName = new StringBuilder();
			writeFileName.append(uuid).append(type);
			String filePath = realPath+"image"+File.separator+writeFileName;
			fileItem.write(new File(filePath));
			fileNameList.add(writeFileName.toString());
		}
		return fileNameList;
	}
	/**
	 * 按表单控件的name获取值
	 * @param name 对应表单name属性
	 * @param requestMap request解析后的map
	 * @return 第一个对应的表单元素值，如果找不到或者有异常返回null
	 */
	private String getParameter(String name,Map<String, List<FileItem>> requestMap){
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
	private String[] getParameterValues(String name,Map<String, List<FileItem>> requestMap){
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
	 * 打印请求内容，测试使用
	 * @param request
	 */
	private void printRequest(HttpServletRequest request) {
		BufferedReader reader = null;
		try {
			reader = request.getReader();
			while(true){
				String line = reader.readLine();
				if(null == line){
					break;
				}
				System.out.println(new String(line.getBytes("iso-8859-1"),"UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null!=reader){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}finally{
					reader=null;
				}
			}
		}
	}

	public static void main(String[] args) {
		String str = "180.gif";
		System.out.println(str.substring(str.indexOf('.')));
	}
}
