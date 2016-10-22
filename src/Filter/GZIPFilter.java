package Filter;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GZIPFilter implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		PrintWriter print = new PrintWriter(new OutputStreamWriter(bout,response.getCharacterEncoding()));
		
		chain.doFilter(request, (ServletResponse) Proxy.newProxyInstance(GZIPFilter.class.getClassLoader(), response.getClass().getInterfaces(),new InvocationHandler(){

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				if(method.getName().equals("getOutputStream")){
					
					return new GZIPServletOutputStream(bout);
					
				}else if(method.getName().equals("getWriter")){
					
					return print;
					
				}else{
					
					return method.invoke(response, args);
				}
			}
		}));
		
		print.close();
		bout.close();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] result = bout.toByteArray();
		GZIPOutputStream gout = new GZIPOutputStream(buffer);
		gout.write(result);
		gout.close();
		byte[] gzip = buffer.toByteArray();
		response.setHeader("content-encoding", "gzip");
		response.setContentLength(gzip.length);
		response.getOutputStream().write(gzip);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

class GZIPServletOutputStream extends ServletOutputStream{

	private ByteArrayOutputStream buffer = null;
	
	public GZIPServletOutputStream(ByteArrayOutputStream buffer){
		this.buffer = buffer;
	}
	@Override
	public void write(int b) throws IOException {
		
		buffer.write(b);
	}
}
