package com.demo.digital.testautomation.authentication;

import com.demo.digital.testautomation.config.ConfigProvider;
import com.typesafe.config.Config;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class SamlTokenProvider {

    public static IAuthSamlTokenProvider getSamlTokenProvider() throws Exception{
        Config config= ConfigProvider.config();

        IAuthSamlTokenProvider selectedTokenProvider;

        if(config.getString("env").equals("cert")) {
            selectedTokenProvider = new CertAuthHeader();
        }
        else {
            selectedTokenProvider= new GenericAuthHeader();
        }
        return selectedTokenProvider;
    }
}
