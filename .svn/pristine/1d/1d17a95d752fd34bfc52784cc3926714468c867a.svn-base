package kr.or.ddit.utiles;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadRequestWrapper extends HttpServletRequestWrapper {
	private Map<String, String[]> queryStringMap;
	// 파일 업로드 요청시 파일 저장
	private Map<String, FileItem[]> fileItemMap;
	
	private boolean multipartFlag = false;
	
	public FileUploadRequestWrapper(HttpServletRequest request) {
		this(request, -1, -1);
	}
	
	public FileUploadRequestWrapper(HttpServletRequest request, int threshold, int sizeMax) {
		super(request);
		
		parsing(request, threshold, sizeMax);
	}

	private void parsing(HttpServletRequest request, int threshold, int sizeMax) {
		this.multipartFlag = ServletFileUpload.isMultipartContent(request);
		
		if(this.multipartFlag) {  // 파일 업로드 일때
			this.queryStringMap = new HashMap<String, String[]>();
			this.fileItemMap = new HashMap<String, FileItem[]>();
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(threshold);
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setSizeMax(sizeMax);
			
			try {
				List<FileItem> items = fileUpload.parseRequest(request);
				
				for(FileItem item : items) {
					if(item.getSize() > 0) {
						// mem_id, mem_pass, mem_name, files*2
						String fieldName = item.getFieldName();
						
						if(item.isFormField()) {
							// mem_id, mem_pass, mem_name
							String value = item.getString("UTF-8");
							
							// queryStringMap 내 기존 해당 fieldName으로 저장된 값이 존재 또는 존재하지 않을때 처리 분기
							String[] values = this.queryStringMap.get(fieldName);  
							if( values == null ) {
								values = new String[]{ value };
							}else {
								String[] temp = new String[values.length + 1];
								
								System.arraycopy(values, 0, temp, 0, values.length);
								
								temp[temp.length -1] = value;
								
								values = temp;
							}
							this.queryStringMap.put(fieldName, values);
						}else {  // 업로드된 파일
							// files * 2
							FileItem[] values = this.fileItemMap.get(fieldName);
							if(values == null) { //values에 저장된 값 없을 때
								values = new FileItem[] { item };  // values가 null이 아니게 만든다.
							}else {
								FileItem[] temp = new FileItem[values.length + 1];
								System.arraycopy(values, 0, temp, 0, values.length);
								
								temp[temp.length -1] = item;
								
								values = temp;
							}
							this.fileItemMap.put(fieldName, values);
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getParameter(String name) {
		if(this.multipartFlag) {
			String[] values = this.queryStringMap.get(name);
			if(values == null) {
				return null;
			}else {
				return values[0];
			}
		}else {
			return super.getParameter(name);
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		if(this.multipartFlag) {
			return this.queryStringMap;
		}else {
			return super.getParameterMap();
		}
	}

	@Override
	public Enumeration<String> getParameterNames() {
		if(this.multipartFlag) {
			return new Enumeration<String>() {
				Iterator<String> keys = queryStringMap.keySet().iterator();
				
				@Override
				public boolean hasMoreElements() {
					return keys.hasNext();  // boolean 타입으로 반환
				}

				@Override
				public String nextElement() {
					return keys.next();
				}
			};
		}else {
			return super.getParameterNames();
		}
	}

	@Override
	public String[] getParameterValues(String name) {
		if(this.multipartFlag) {
			return this.queryStringMap.get(name);
		}else {
			return super.getParameterValues(name);
		}
	}
	
	public FileItem getFileItem(String name) {
		if(this.multipartFlag) {
			FileItem[] items = this.fileItemMap.get(name);
			if(items == null) {
				return null;
			}else {
				return items[0];
			}
		}else {
			return null;
		}
	}
	
	public Map<String, FileItem[]> getFileItemMap() {
		if(this.multipartFlag) {
			return this.fileItemMap;
		}else {
			return null;
		}
	}
	
	public FileItem[] getFileItemValues(String name) {
		if(this.multipartFlag) {
			return this.fileItemMap.get(name);
		}else{ 
			return null; // 파일 업로드 요청이 아닐때
		}
	}
}
