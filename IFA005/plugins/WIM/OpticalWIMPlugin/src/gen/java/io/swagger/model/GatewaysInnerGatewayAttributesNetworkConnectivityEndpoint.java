/*
 * VIM Manager API
 * VIM Manager API
 *
 * OpenAPI spec version: 0.0.3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.*;

/**
 * Information about network connectivity endpoints to the NFVI-PoP that the WIM manage.
 */
@ApiModel(description = "Information about network connectivity endpoints to the NFVI-PoP that the WIM manage.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-11-29T11:25:16.593Z")
public class GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint   {
  @JsonProperty("netGwIpAddress")
  private String netGwIpAddress = null;

  @JsonProperty("netGwInterfceId")
  private BigDecimal netGwInterfceId = null;

  public GatewaysInnerGatewayAttributesNetworkConnectivityEndpoint netGwIpAddress(String netGwIpAddress) {
    this.netGwIpAddress = netGwIpAddress;
    return this;
  }

  /**
   * 5GT - Reachable Gw IPv4 Address in terms of A.B.C.D (/32).
   * @return netGwIpAddress
   **/
  @JsonProperty("netGwIpAddress")
  @ApiModelProperty(required = true, value = "5GT - Reachable Gw IPv4 Address in terms of A.B.C.D (/32).")
  @NotNull
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
  @JsonProperty("netGwInterfceId")
  @ApiModelProperty(required = true, value = "5GT - Reachable Gw interface ID.")
  @NotNull
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
