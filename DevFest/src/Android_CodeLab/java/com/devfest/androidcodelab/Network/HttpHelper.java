package com.devfest.androidcodelab.Network;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/**
 * @author: Kioko
 * @description: This method contains all HTTP Methods used to Send and receive data from a Web Service.
 *
 */


public class HttpHelper {

    //Declaration
    DefaultHttpClient httpClient;
    HttpContext httpContext;
    HttpResponse httpResponse;
    HttpGet httpGet;

    private String response;

    /** constructor:
     * This is a block of code similar to the method that is called when
     * an instance of an object is created.
     **/
    public HttpHelper(){

        HttpParams httpParams = new BasicHttpParams();

        HttpConnectionParams.setConnectionTimeout(httpParams, 1000);
        HttpConnectionParams.setSoTimeout(httpParams, 1000);
        httpClient = new DefaultHttpClient(httpParams);
        httpContext = new BasicHttpContext();
    }

    //All HTTP Methods Go here


}
