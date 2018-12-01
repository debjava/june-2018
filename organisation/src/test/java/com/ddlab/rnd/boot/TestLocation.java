//package com.ddlab.rnd.boot;
//
//import com.ddlab.boot.entity.Location;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//
//import feign.Feign;
//import feign.Target;
//import feign.codec.Decoder;
//import feign.codec.Encoder;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
//import feign.okhttp.OkHttpClient;
//import feign.slf4j.Slf4jLogger;
//
//public class TestLocation {
//
//  public static void main(String[] args) {
//      
//
//      Target<GetLocation> target = new Target.HardCodedTarget<>(GetLocation.class,"http://localhost:8081/org/home/");
//      
//      GetLocation location = Feign.builder()
//      .client(new OkHttpClient())
//      .encoder(new Encoder.Default())
//      .decoder(new Decoder.Default())
//      .logger(new Slf4jLogger(GetLocation.class))
//      .logLevel(feign.Logger.Level.BASIC)
//      .target(target);
//      System.out.println("===>"+location);
//      System.out.println("---->\n"+location.getLocation("11"));
//      
//      
//      
//      ObjectMapper mapper = new ObjectMapper()
//              .setSerializationInclusion(JsonInclude.Include.NON_NULL)
//              .configure(SerializationFeature.INDENT_OUTPUT, true)
//              .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//      
//      
//      GetLocation location2 = Feign.builder()
//              .client(new OkHttpClient())
//              .encoder(new JacksonEncoder())
//              .decoder(new Decoder.Default())
//              .logger(new Slf4jLogger(GetLocation.class))
//              .logLevel(feign.Logger.Level.BASIC)
//              .target(target);
//      Location location1 = new Location();
//      location1.setOfficeName("DDLab Inc");
//      location1.setStreetName("14th Cannin Stree");
//      location1.setCity("Bangalore");
//      location1.setPincode("123456");
//      System.out.println("~~~~~~~~~~~~~"+location2.createLocation(location1));
//      
//      
//      
//      
//  }
//}
