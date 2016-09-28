package xtqh.framework.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * @author Yan Fugen
 *
 */
public class ApplicationContextLoaderListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		/**
		 * 加载sqlManager.xml
		 */
		
		System.out.println("##############################################");
		System.out.println("加载ConfigManager.xml，加载配置文件到内存");
		System.out.println("##############################################");
	}

}
