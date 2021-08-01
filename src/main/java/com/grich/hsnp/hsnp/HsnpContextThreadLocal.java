package com.grich.hsnp.hsnp;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lucas
 */
public class HsnpContextThreadLocal {

    private static final ThreadLocal<HsnpRequest>  hsnpRequestThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<HsnpResponse> hsnpResponseThreadLocal = new ThreadLocal<>();


    public static void add(HsnpRequest hsnpRequest) {
        hsnpRequestThreadLocal.set(hsnpRequest);
    }

    public static void add(HsnpResponse hsnpResponse) {
        hsnpResponseThreadLocal.set(hsnpResponse);
    }


    public static HsnpRequest getHsnpRequest() {
        return hsnpRequestThreadLocal.get();
    }

    public static HsnpResponse getHsnpResponse() {
        return hsnpResponseThreadLocal.get();
    }


    public static void remove() {
        hsnpRequestThreadLocal.remove();
        hsnpResponseThreadLocal.remove();
    }
}
