package build.dream.wwm.listeners;

import build.dream.wwm.utils.ApplicationHandler;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BasicServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext.getAutowireCapableBeanFactory();
        autowireCapableBeanFactory.autowireBean(this);
        ApplicationHandler.setApplicationContext(webApplicationContext);
        ApplicationHandler.setServletContext(servletContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    public void previousInjectionBean(ServletContext servletContext, Class<?>... beanClasses) {
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        for (Class<?> beanClass : beanClasses) {
            webApplicationContext.getBean(beanClass);
        }
    }
}
