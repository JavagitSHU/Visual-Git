package com.visualgit.MyGit;

public class ProxyOperation {
    public void set_porter(String porter) {
        System.setProperty("http.proxyPort", porter);
    }

    public void set_host(String host) {
        System.setProperty("http.proxyHost", host);
    }
}
