package com.demo.digital.testautomation.request;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class Headers {

    private String demoSaml;
    private String hsbcLocale;

    Headers(final HeadersBuilder builder){
        this.demoSaml = builder.demoSaml;
        //this.demoLocale=builder.demoLocale;
    }

    public static class Builder{

    }

    public Map<String, String> getMappedHeaderValues(){
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("X-DEMO-Saml", this.demoSaml);
        //headers.put("X-HSBC-Locale",demoLocale);

        return headers;
    }
}
