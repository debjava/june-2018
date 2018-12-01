package com.ddlab.rnd.boot;

import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class Test1 {
    
    private static <T> T createClient(Class<T> type, String uri) {
        return Feign.builder()
            .client(new OkHttpClient())
            .encoder(new Encoder.Default())
            .decoder(new Decoder.Default())
            .logger(new Slf4jLogger(type))
//            .logLevel(Logger.Level.FULL)
            .target(type, uri);
    }

  public static void main(String[] args) {
      
      GetInfo obj =  createClient(GetInfo.class, "http://localhost:8081/org/home/");
      System.out.println("--------->"+obj);
      System.out.println("--------->"+obj.getName("11"));

  }
}
