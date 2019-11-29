/*
 * MTP Manager API
 * MTP Manager API
 *
 * OpenAPI spec version: 2.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mtp.extinterface.nbi.swagger.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.mtp.extinterface.nbi.swagger.model.Gateways;
import com.mtp.extinterface.nbi.swagger.model.VirtualLinks;
import java.io.IOException;

/**
 * InlineResponse2002
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class InlineResponse2002 {
  @SerializedName("gateways")
  private Gateways gateways = null;

  @SerializedName("virtualLinks")
  private VirtualLinks virtualLinks = null;

  public InlineResponse2002 gateways(Gateways gateways) {
    this.gateways = gateways;
    return this;
  }

   /**
   * Get gateways
   * @return gateways
  **/
  @ApiModelProperty(value = "")
  public Gateways getGateways() {
    return gateways;
  }

  public void setGateways(Gateways gateways) {
    this.gateways = gateways;
  }

  public InlineResponse2002 virtualLinks(VirtualLinks virtualLinks) {
    this.virtualLinks = virtualLinks;
    return this;
  }

   /**
   * Get virtualLinks
   * @return virtualLinks
  **/
  @ApiModelProperty(value = "")
  public VirtualLinks getVirtualLinks() {
    return virtualLinks;
  }

  public void setVirtualLinks(VirtualLinks virtualLinks) {
    this.virtualLinks = virtualLinks;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2002 inlineResponse2002 = (InlineResponse2002) o;
    return Objects.equals(this.gateways, inlineResponse2002.gateways) &&
        Objects.equals(this.virtualLinks, inlineResponse2002.virtualLinks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gateways, virtualLinks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("    gateways: ").append(toIndentedString(gateways)).append("\n");
    sb.append("    virtualLinks: ").append(toIndentedString(virtualLinks)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

