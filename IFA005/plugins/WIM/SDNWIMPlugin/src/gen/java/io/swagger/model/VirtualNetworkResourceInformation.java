/*
 * WIM Manager API
 * WIM Manager API
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
import io.swagger.model.VirtualNetworkResourceInformationNetworkQoS;
import java.math.BigDecimal;
import javax.validation.constraints.*;

/**
 * VirtualNetworkResourceInformation
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-11-02T11:54:01.688+01:00")
public class VirtualNetworkResourceInformation   {
  @JsonProperty("networkResourceTypeId")
  private String networkResourceTypeId = null;

  @JsonProperty("bandwidth")
  private BigDecimal bandwidth = null;

  @JsonProperty("networkQoS")
  private VirtualNetworkResourceInformationNetworkQoS networkQoS = null;

  @JsonProperty("networkType")
  private String networkType = null;

  public VirtualNetworkResourceInformation networkResourceTypeId(String networkResourceTypeId) {
    this.networkResourceTypeId = networkResourceTypeId;
    return this;
  }

  /**
   * Identifier of the network resource type.
   * @return networkResourceTypeId
   **/
  @JsonProperty("networkResourceTypeId")
  @ApiModelProperty(required = true, value = "Identifier of the network resource type.")
  @NotNull
  public String getNetworkResourceTypeId() {
    return networkResourceTypeId;
  }

  public void setNetworkResourceTypeId(String networkResourceTypeId) {
    this.networkResourceTypeId = networkResourceTypeId;
  }

  public VirtualNetworkResourceInformation bandwidth(BigDecimal bandwidth) {
    this.bandwidth = bandwidth;
    return this;
  }

  /**
   * Minimum network bandwidth (in Mbps).
   * @return bandwidth
   **/
  @JsonProperty("bandwidth")
  @ApiModelProperty(required = true, value = "Minimum network bandwidth (in Mbps).")
  @NotNull
  public BigDecimal getBandwidth() {
    return bandwidth;
  }

  public void setBandwidth(BigDecimal bandwidth) {
    this.bandwidth = bandwidth;
  }

  public VirtualNetworkResourceInformation networkQoS(VirtualNetworkResourceInformationNetworkQoS networkQoS) {
    this.networkQoS = networkQoS;
    return this;
  }

  /**
   * Get networkQoS
   * @return networkQoS
   **/
  @JsonProperty("networkQoS")
  @ApiModelProperty(required = true, value = "")
  @NotNull
  public VirtualNetworkResourceInformationNetworkQoS getNetworkQoS() {
    return networkQoS;
  }

  public void setNetworkQoS(VirtualNetworkResourceInformationNetworkQoS networkQoS) {
    this.networkQoS = networkQoS;
  }

  public VirtualNetworkResourceInformation networkType(String networkType) {
    this.networkType = networkType;
    return this;
  }

  /**
   * The type of network that maps to the virtualised network. Examples are: \&quot;local\&quot;, \&quot;vlan\&quot;, \&quot;vxlan\&quot;, \&quot;gre\&quot;, etc.
   * @return networkType
   **/
  @JsonProperty("networkType")
  @ApiModelProperty(required = true, value = "The type of network that maps to the virtualised network. Examples are: \"local\", \"vlan\", \"vxlan\", \"gre\", etc.")
  @NotNull
  public String getNetworkType() {
    return networkType;
  }

  public void setNetworkType(String networkType) {
    this.networkType = networkType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VirtualNetworkResourceInformation virtualNetworkResourceInformation = (VirtualNetworkResourceInformation) o;
    return Objects.equals(this.networkResourceTypeId, virtualNetworkResourceInformation.networkResourceTypeId) &&
        Objects.equals(this.bandwidth, virtualNetworkResourceInformation.bandwidth) &&
        Objects.equals(this.networkQoS, virtualNetworkResourceInformation.networkQoS) &&
        Objects.equals(this.networkType, virtualNetworkResourceInformation.networkType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(networkResourceTypeId, bandwidth, networkQoS, networkType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VirtualNetworkResourceInformation {\n");
    
    sb.append("    networkResourceTypeId: ").append(toIndentedString(networkResourceTypeId)).append("\n");
    sb.append("    bandwidth: ").append(toIndentedString(bandwidth)).append("\n");
    sb.append("    networkQoS: ").append(toIndentedString(networkQoS)).append("\n");
    sb.append("    networkType: ").append(toIndentedString(networkType)).append("\n");
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

