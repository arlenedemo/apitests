package com.hsbc.digital.testautomation.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by arlene.lehakra on 16/01/2017.
 */
public class ConfigProvider {

    private static Config config;

    public static Config config(){
        if (ConfigProvider.config==null){
            ConfigProvider.config=ConfigFactory.load();
            String env =ConfigProvider.config.getString("env");
            ConfigProvider.config=ConfigProvider.config.getConfig(env.toLowerCase()).withFallback(ConfigProvider.config);
        }
        return ConfigProvider.config;
    }


}
