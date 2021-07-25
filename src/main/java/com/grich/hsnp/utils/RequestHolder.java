package com.grich.hsnp.utils;



import com.grich.hsnp.model.user.VlabUser;

import javax.servlet.http.HttpServletRequest;

public class RequestHolder {

    private static final ThreadLocal<VlabUser> userHolder = new ThreadLocal<VlabUser>();
    private static final ThreadLocal<String> rolesHolder = new ThreadLocal<String>();


    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();

    public static void add(VlabUser VlabUser) {
        userHolder.set(VlabUser);
    }
    
    public static void add(String roleNames) {
    	rolesHolder.set(roleNames);
    }

    public static void add(HttpServletRequest request) {
        requestHolder.set(request);
    }

    public static VlabUser getCurrentUser() {
        return userHolder.get();
    }
    
    public static String getRoleNames() {
        return rolesHolder.get();
    }

    public static HttpServletRequest getCurrentRequest() {
        return requestHolder.get();
    }

    public static void remove() {
        userHolder.remove();
        requestHolder.remove();
        rolesHolder.remove();
    }
}
