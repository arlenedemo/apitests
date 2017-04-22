package com.demo.digital.testautomation.request;

import com.demo.digital.testautomation.authentication.IAuthSamlTokenProvider;
import com.demo.digital.testautomation.authentication.SamlTokenProvider;
import com.demo.digital.testautomation.config.ConfigProvider;
import com.typesafe.config.Config;

import java.util.Locale;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class HeadersBuilder {

    private static Config config = ConfigProvider.config();
    IAuthSamlTokenProvider samlTokenProvider = SamlTokenProvider.getSamlTokenProvider();

    String hsbcSaml =String.format("%s", this.samlTokenProvider.getSamlToken());
    String hsbcLocale = Locale.ENGLISH.toString();

    public HeadersBuilder samlToken(final String samlToken){
        this.hsbcSaml=samlToken;
        return this;
    }

    public HeadersBuilder locale(final String locale){
        this.hsbcLocale=locale;
        return this;
    }

    public HeadersBuilder() throws Exception {
    }

    public Headers build(){
        return new Headers(this);
    }
}
