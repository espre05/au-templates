import javax.servlet.ServletContext;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JettyMain {
	
	public static void main(String [] args){
/*		AbstractApplicationContext ctx = 
			    new ClassPathXmlApplicationContext("/org/springbyexample/ws/embedded/embedded-jetty-context.xml");  1
			ctx.registerShutdownHook();

			Server server = (Server) ctx.getBean("jettyServer");  

			ServletContext servletContext = null;

			for (Handler handler : server.getHandlers()) {
			    if (handler instanceof Context) {
			        Context context = (Context) handler;
			        
			        servletContext = context.getServletContext();3
			    }
			}

			XmlWebApplicationContext wctx = new XmlWebApplicationContext();  
			wctx.setParent(ctx);
			wctx.setConfigLocation("");
			wctx.setServletContext(servletContext);
			wctx.refresh();

			servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wctx);  5

			server.start();  
	*/}

}
