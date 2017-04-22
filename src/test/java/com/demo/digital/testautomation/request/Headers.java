package com.demo.digital.testautomation.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class Headers {

    private String hsbcSaml;
    private String hsbcLocale;

    Headers(final HeadersBuilder builder){
        this.hsbcSaml= builder.hsbcSaml;
        //this.hsbcLocale=builder.hsbcLocale;
    }

    public static class Builder{

    }

    public Map<String, String> getMappedHeaderValues(){
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("X-HSBC-Saml", this.hsbcSaml);
        //headers.put("X-HSBC-Locale",hsbcLocale);

        return headers;
    }
}
