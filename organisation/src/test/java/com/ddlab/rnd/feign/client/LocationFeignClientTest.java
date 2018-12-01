package com.ddlab.rnd.feign.client;

import com.ddlab.boot.entity.Location;

import feign.Feign;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

public class LocationFeignClientTest {
  private static final Target<LocationFeign> target =
      new Target.HardCodedTarget<>(LocationFeign.class, Messages.getString("LocationFeignClientTest.0")); //$NON-NLS-1$

  public static void showLocationDetails() {
    LocationFeign feignLocation =
        Feign.builder()
            .client(new OkHttpClient())
            .encoder(new Encoder.Default())
            .decoder(new Decoder.Default())
            .logger(new Slf4jLogger(LocationFeign.class))
            .logLevel(feign.Logger.Level.BASIC)
            .target(target);
    System.out.println(Messages.getString("LocationFeignClientTest.1") + feignLocation.getLocation(Messages.getString("LocationFeignClientTest.2"))); //$NON-NLS-1$ //$NON-NLS-2$
  }

  public static void showCreatedLocation() {
    LocationFeign feignLocation =
        Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new Decoder.Default())
            .logger(new Slf4jLogger(LocationFeign.class))
            .logLevel(feign.Logger.Level.BASIC)
            .target(target);
    Location location = getLocation();
    System.out.println(Messages.getString("LocationFeignClientTest.3") + feignLocation.createLocation(location)); //$NON-NLS-1$
  }

  public static void showUpdatedLocation() {
    LocationFeign feignLocation =
        Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .logger(new Slf4jLogger(LocationFeign.class))
            .logLevel(feign.Logger.Level.BASIC)
            .target(target);
    Location location = getLocation();
    System.out.println(Messages.getString("LocationFeignClientTest.4") + feignLocation.updateLocation(location)); //$NON-NLS-1$
  }

  public static void showDeletedLocation() {
    LocationFeign feignLocation =
        Feign.builder()
            .client(new OkHttpClient())
            .encoder(new JacksonEncoder())
            .decoder(new Decoder.Default())
            .logger(new Slf4jLogger(LocationFeign.class))
            .logLevel(feign.Logger.Level.BASIC)
            .target(target);
    Location location = getLocation();
    System.out.println(Messages.getString("LocationFeignClientTest.5") + feignLocation.deleteLocation(location)); //$NON-NLS-1$
  }

  private static Location getLocation() {
    Location location = new Location();
    location.setOfficeName(Messages.getString("LocationFeignClientTest.6")); //$NON-NLS-1$
    location.setStreetName(Messages.getString("LocationFeignClientTest.7")); //$NON-NLS-1$
    location.setCity(Messages.getString("LocationFeignClientTest.8")); //$NON-NLS-1$
    location.setPincode(Messages.getString("LocationFeignClientTest.9")); //$NON-NLS-1$
    return location;
  }

  public static void main(String[] args) {
    showLocationDetails();
    showCreatedLocation();
    showUpdatedLocation();
    showDeletedLocation();
  }
}
