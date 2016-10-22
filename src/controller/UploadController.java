package controller;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Utils.UniqueCode;
import domain.BuildingBean;
import service.Building2DB_ser;


public class UploadController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Building2DB_ser ser = new Building2DB_ser("dao.Building2DB");
		BuildingBean bean = new BuildingBean();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding(request.getCharacterEncoding());
		String path = this.getServletContext().getRealPath("/UploadFile");
		factory.setRepository(new File(this.getServletContext().getRealPath("/temp")));
		if(!upload.isMultipartContent(request)){
			return;
		}
		try {
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list){
				if(item.isFormField()){
					String filename = item.getFieldName();
					String value = item.getString(request.getCharacterEncoding());
					if(filename.equals("building_size") || filename.equals("building_max_hold") || filename.equals("building_cash")){
						if(filename.equals("building_max_hold")){
							int values = Integer.parseInt(value);
							PropertyDescriptor pd = new PropertyDescriptor(filename,BuildingBean.class);
							pd.getWriteMethod().invoke(bean, values);
						}else{
							double values = Double.parseDouble(value);
							PropertyDescriptor pd = new PropertyDescriptor(filename,BuildingBean.class);
							pd.getWriteMethod().invoke(bean, values);
						}
						continue;
					}
					PropertyDescriptor pd = new PropertyDescriptor(filename,BuildingBean.class);
					pd.getWriteMethod().invoke(bean, value);
				}else{
					String name = item.getName();
					if(name == null || name.trim().equals(""))continue;
					String fieldname = item.getFieldName();
					String filename = name.substring(name.lastIndexOf("\\") + 1);
					filename = UniqueCode.getUniqueCode() + "_" + filename;
					if(fieldname.equals("building_img")){
						PropertyDescriptor pd = new PropertyDescriptor("building_img",BuildingBean.class);
						int hashcode = filename.hashCode();
						int dir1 = hashcode&0xf;
						int dir2 = (hashcode&0xf0)>>4;
						String webpath = "/UploadFile/" + dir1 + "/" + dir2 + "/" + filename;
						pd.getWriteMethod().invoke(bean, webpath);
					}
					FileOutputStream out = new FileOutputStream(getPath(filename, path) + "\\" + filename);
					InputStream in = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = in.read(buffer);
					while(len != -1){
						out.write(buffer, 0, len);
						len = in.read(buffer);
					}
					in.close();
					out.close();
					item.delete();
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		bean.setBuilding_id(UniqueCode.getUniqueCode());
		if(ser.insert(bean) >=1){
			request.setAttribute("message", "注入成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "注入成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public String getPath(String path,String filepath){
		
		int hashcode = path.hashCode();
		int dir1 = hashcode&0xf;
		int dir2 = (hashcode&0xf0)>>4;
		File file = new File(filepath + "\\" + dir1 + "\\" + dir2);
		if(!file.exists()){
			file.mkdirs();
		}
		return file.getPath();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}