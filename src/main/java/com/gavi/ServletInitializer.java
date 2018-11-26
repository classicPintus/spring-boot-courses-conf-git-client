package com.gavi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//        Aggiungere i vecchi <context-param>
//        servletContext.setInitParameter(name, value);

//        Aggiungere i vecchi <listener>
//        servletContext.addListener(listenerClass);

//        Aggiungere i vecchi <filter>
//        servletContext.addFilter(filterName, filterClass);

//        Aggiungere le vecchie <servlet>
//        servletContext.addServlet(servletName, servlet)

//        Settare la sessione
//        Guardare le properties
        super.onStartup(servletContext); 
    }
    
    

}
