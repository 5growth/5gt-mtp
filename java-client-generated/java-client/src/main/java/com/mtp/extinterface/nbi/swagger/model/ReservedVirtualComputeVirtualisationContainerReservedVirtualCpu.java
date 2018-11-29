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
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * The virtual CPU(s) of the reserved virtualisation container.
 */
@ApiModel(description = "The virtual CPU(s) of the reserved virtualisation container.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-11-28T16:39:06.525Z")
public class ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu {
  @SerializedName("cpuArchitecture")
  private String cpuArchitecture = null;

  @SerializedName("cpuClock")
  private BigDecimal cpuClock = null;

  @SerializedName("numVirtualCpu")
  private Integer numVirtualCpu = null;

  @SerializedName("virtualCpuOversubscriptionPolicy")
  private String virtualCpuOversubscriptionPolicy = null;

  @SerializedName("virtualCpuPinning")
  private CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning virtualCpuPinning = null;

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu cpuArchitecture(String cpuArchitecture) {
    this.cpuArchitecture = cpuArchitecture;
    return this;
  }

   /**
   * CPU architecture type. Examples are x86, ARM.
   * @return cpuArchitecture
  **/
  @ApiModelProperty(required = true, value = "CPU architecture type. Examples are x86, ARM.")
  public String getCpuArchitecture() {
    return cpuArchitecture;
  }

  public void setCpuArchitecture(String cpuArchitecture) {
    this.cpuArchitecture = cpuArchitecture;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu cpuClock(BigDecimal cpuClock) {
    this.cpuClock = cpuClock;
    return this;
  }

   /**
   * Minimum CPU clock rate (e.g. in MHz) available for the virtualised CPU resources.
   * @return cpuClock
  **/
  @ApiModelProperty(required = true, value = "Minimum CPU clock rate (e.g. in MHz) available for the virtualised CPU resources.")
  public BigDecimal getCpuClock() {
    return cpuClock;
  }

  public void setCpuClock(BigDecimal cpuClock) {
    this.cpuClock = cpuClock;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu numVirtualCpu(Integer numVirtualCpu) {
    this.numVirtualCpu = numVirtualCpu;
    return this;
  }

   /**
   * Number of virtual CPUs.
   * @return numVirtualCpu
  **/
  @ApiModelProperty(required = true, value = "Number of virtual CPUs.")
  public Integer getNumVirtualCpu() {
    return numVirtualCpu;
  }

  public void setNumVirtualCpu(Integer numVirtualCpu) {
    this.numVirtualCpu = numVirtualCpu;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu virtualCpuOversubscriptionPolicy(String virtualCpuOversubscriptionPolicy) {
    this.virtualCpuOversubscriptionPolicy = virtualCpuOversubscriptionPolicy;
    return this;
  }

   /**
   * The CPU core oversubscription policy, e.g. the relation of virtual CPU cores to physical CPU cores/threads. The cardinality can be 0 if no policy has been defined during the allocation request.
   * @return virtualCpuOversubscriptionPolicy
  **/
  @ApiModelProperty(required = true, value = "The CPU core oversubscription policy, e.g. the relation of virtual CPU cores to physical CPU cores/threads. The cardinality can be 0 if no policy has been defined during the allocation request.")
  public String getVirtualCpuOversubscriptionPolicy() {
    return virtualCpuOversubscriptionPolicy;
  }

  public void setVirtualCpuOversubscriptionPolicy(String virtualCpuOversubscriptionPolicy) {
    this.virtualCpuOversubscriptionPolicy = virtualCpuOversubscriptionPolicy;
  }

  public ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu virtualCpuPinning(CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning virtualCpuPinning) {
    this.virtualCpuPinning = virtualCpuPinning;
    return this;
  }

   /**
   * Get virtualCpuPinning
   * @return virtualCpuPinning
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning getVirtualCpuPinning() {
    return virtualCpuPinning;
  }

  public void setVirtualCpuPinning(CreateComputeResourceReservationRequestContainerFlavourVirtualCpuPinning virtualCpuPinning) {
    this.virtualCpuPinning = virtualCpuPinning;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu reservedVirtualComputeVirtualisationContainerReservedVirtualCpu = (ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu) o;
    return Objects.equals(this.cpuArchitecture, reservedVirtualComputeVirtualisationContainerReservedVirtualCpu.cpuArchitecture) &&
        Objects.equals(this.cpuClock, reservedVirtualComputeVirtualisationContainerReservedVirtualCpu.cpuClock) &&
        Objects.equals(this.numVirtualCpu, reservedVirtualComputeVirtualisationContainerReservedVirtualCpu.numVirtualCpu) &&
        Objects.equals(this.virtualCpuOversubscriptionPolicy, reservedVirtualComputeVirtualisationContainerReservedVirtualCpu.virtualCpuOversubscriptionPolicy) &&
        Objects.equals(this.virtualCpuPinning, reservedVirtualComputeVirtualisationContainerReservedVirtualCpu.virtualCpuPinning);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpuArchitecture, cpuClock, numVirtualCpu, virtualCpuOversubscriptionPolicy, virtualCpuPinning);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ReservedVirtualComputeVirtualisationContainerReservedVirtualCpu {\n");
    
    sb.append("    cpuArchitecture: ").append(toIndentedString(cpuArchitecture)).append("\n");
    sb.append("    cpuClock: ").append(toIndentedString(cpuClock)).append("\n");
    sb.append("    numVirtualCpu: ").append(toIndentedString(numVirtualCpu)).append("\n");
    sb.append("    virtualCpuOversubscriptionPolicy: ").append(toIndentedString(virtualCpuOversubscriptionPolicy)).append("\n");
    sb.append("    virtualCpuPinning: ").append(toIndentedString(virtualCpuPinning)).append("\n");
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

