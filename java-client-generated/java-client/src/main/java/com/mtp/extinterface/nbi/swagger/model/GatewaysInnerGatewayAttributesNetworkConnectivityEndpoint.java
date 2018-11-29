/*
 * MTP Manager API
 * MTP Manager API
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mtp.extinterface.nbi.swagger.model;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Information about network connectivity endpoints to the NFVI-PoP that the WIM manage.
 */
@ApiModel(description = "Information about network connectivity endpoints to the NFVI-PoP that the WIM manage.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint {
  @SerializedName("netGwIpAddress")
  private String netGwIpAddress = null;

  @SerializedName("netGwInterfceId")
  private BigDecimal netGwInterfceId = null;

  public GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint netGwIpAddress(String netGwIpAddress) {
    this.netGwIpAddress = netGwIpAddress;
    return this;
  }

   /**
   * 5GT - Reachable Gw IPv4 Address in terms of A.B.C.D (/32).
   * @return netGwIpAddress
  **/
  @ApiModelProperty(required = true, value = "5GT - Reachable Gw IPv4 Address in terms of A.B.C.D (/32).")
  public String getNetGwIpAddress() {
    return netGwIpAddress;
  }

  public void setNetGwIpAddress(String netGwIpAddress) {
    this.netGwIpAddress = netGwIpAddress;
  }

  public GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint netGwInterfceId(BigDecimal netGwInterfceId) {
    this.netGwInterfceId = netGwInterfceId;
    return this;
  }

   /**
   * 5GT - Reachable Gw interface ID.
   * @return netGwInterfceId
  **/
  @ApiModelProperty(required = true, value = "5GT - Reachable Gw interface ID.")
  public BigDecimal getNetGwInterfceId() {
    return netGwInterfceId;
  }

  public void setNetGwInterfceId(BigDecimal netGwInterfceId) {
    this.netGwInterfceId = netGwInterfceId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint gatewaysInnerGatewayAttributesNetworkConnectivityEndpoint = (GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint) o;
    return Objects.equals(this.netGwIpAddress, gatewaysInnerGatewayAttributesNetworkConnectivityEndpoint.netGwIpAddress) &&
        Objects.equals(this.netGwInterfceId, gatewaysInnerGatewayAttributesNetworkConnectivityEndpoint.netGwInterfceId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(netGwIpAddress, netGwInterfceId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint {\n");
    
    sb.append("    netGwIpAddress: ").append(toIndentedString(netGwIpAddress)).append("\n");
    sb.append("    netGwInterfceId: ").append(toIndentedString(netGwInterfceId)).append("\n");
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
