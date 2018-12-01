package com.ddlab.boot.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"officeName", "streetName", "city", "pincode"})
public class Location {

  @JsonProperty private String officeName;
  @JsonProperty private String streetName;
  @JsonProperty private String city;
  @JsonProperty private String pincode;

  public String toJSON() {
    ObjectMapper mapper = new ObjectMapper();
    String toJson = null;
    try {
      toJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return toJson;
  }
}
