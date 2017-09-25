package com.gdglc.news.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyRequestListener
 *
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent event) {
    		System.out.println("request销毁完毕");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0) {
    		System.out.println("request创建完毕");
    }
	
}
