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
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourStorageAttributes;
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourVirtualCpu;
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourVirtualMemory;
import com.mtp.extinterface.nbi.swagger.model.CreateComputeResourceReservationRequestContainerFlavourVirtualNetworkInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The containerFlavour encapsulates information of the virtualisation container to be reserved.
 */
@ApiModel(description = "The containerFlavour encapsulates information of the virtualisation container to be reserved.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-08-05T11:05:49.089Z")
public class CreateComputeResourceReservationRequestContainerFlavour {
  @SerializedName("accelerationCapability")
  private String accelerationCapability = null;

  @SerializedName("flavourId")
  private String flavourId = null;

  @SerializedName("storageAttributes")
  private List<CreateComputeResourceReservationRequestContainerFlavourStorageAttributes> storageAttributes = new ArrayList<CreateComputeResourceReservationRequestContainerFlavourStorageAttributes>();

  @SerializedName("virtualCpu")
  private List<CreateComputeResourceReservationRequestContainerFlavourVirtualCpu> virtualCpu = new ArrayList<CreateComputeResourceReservationRequestContainerFlavourVirtualCpu>();

  @SerializedName("virtualMemory")
  private CreateComputeResourceReservationRequestContainerFlavourVirtualMemory virtualMemory = null;

  @SerializedName("virtualNetworkInterface")
  private CreateComputeResourceReservationRequestContainerFlavourVirtualNetworkInterface virtualNetworkInterface = null;

  public CreateComputeResourceReservationRequestContainerFlavour accelerationCapability(String accelerationCapability) {
    this.accelerationCapability = accelerationCapability;
    return this;
  }

   /**
   * Selected acceleration capabilities (e.g. crypto, GPU) from the set of capabilities offered by the compute node acceleration resources. The cardinality can be 0, if no particular acceleration capability is requested.
   * @return accelerationCapability
  **/
  @ApiModelProperty(required = true, value = "Selected acceleration capabilities (e.g. crypto, GPU) from the set of capabilities offered by the compute node acceleration resources. The cardinality can be 0, if no particular acceleration capability is requested.")
  public String getAccelerationCapability() {
    return accelerationCapability;
  }

  public void setAccelerationCapability(String accelerationCapability) {
    this.accelerationCapability = accelerationCapability;
  }

  public CreateComputeResourceReservationRequestContainerFlavour flavourId(String flavourId) {
    this.flavourId = flavourId;
    return this;
  }

   /**
   * Identifier given to the compute flavour.
   * @return flavourId
  **/
  @ApiModelProperty(required = true, value = "Identifier given to the compute flavour.")
  public String getFlavourId() {
    return flavourId;
  }

  public void setFlavourId(String flavourId) {
    this.flavourId = flavourId;
  }

  public CreateComputeResourceReservationRequestContainerFlavour storageAttributes(List<CreateComputeResourceReservationRequestContainerFlavourStorageAttributes> storageAttributes) {
    this.storageAttributes = storageAttributes;
    return this;
  }

  public CreateComputeResourceReservationRequestContainerFlavour addStorageAttributesItem(CreateComputeResourceReservationRequestContainerFlavourStorageAttributes storageAttributesItem) {
    this.storageAttributes.add(storageAttributesItem);
    return this;
  }

   /**
   * Element containing information about the size of virtualised storage resources (e.g. size of volume, in GB), the type of storage (e.g. volume, object).
   * @return storageAttributes
  **/
  @ApiModelProperty(required = true, value = "Element containing information about the size of virtualised storage resources (e.g. size of volume, in GB), the type of storage (e.g. volume, object).")
  public List<CreateComputeResourceReservationRequestContainerFlavourStorageAttributes> getStorageAttributes() {
    return storageAttributes;
  }

  public void setStorageAttributes(List<CreateComputeResourceReservationRequestContainerFlavourStorageAttributes> storageAttributes) {
    this.storageAttributes = storageAttributes;
  }

  public CreateComputeResourceReservationRequestContainerFlavour virtualCpu(List<CreateComputeResourceReservationRequestContainerFlavourVirtualCpu> virtualCpu) {
    this.virtualCpu = virtualCpu;
    return this;
  }

  public CreateComputeResourceReservationRequestContainerFlavour addVirtualCpuItem(CreateComputeResourceReservationRequestContainerFlavourVirtualCpu virtualCpuItem) {
    this.virtualCpu.add(virtualCpuItem);
    return this;
  }

   /**
   * The virtual CPU(s) of the virtualised compute.
   * @return virtualCpu
  **/
  @ApiModelProperty(required = true, value = "The virtual CPU(s) of the virtualised compute.")
  public List<CreateComputeResourceReservationRequestContainerFlavourVirtualCpu> getVirtualCpu() {
    return virtualCpu;
  }

  public void setVirtualCpu(List<CreateComputeResourceReservationRequestContainerFlavourVirtualCpu> virtualCpu) {
    this.virtualCpu = virtualCpu;
  }

  public CreateComputeResourceReservationRequestContainerFlavour virtualMemory(CreateComputeResourceReservationRequestContainerFlavourVirtualMemory virtualMemory) {
    this.virtualMemory = virtualMemory;
    return this;
  }

   /**
   * Get virtualMemory
   * @return virtualMemory
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateComputeResourceReservationRequestContainerFlavourVirtualMemory getVirtualMemory() {
    return virtualMemory;
  }

  public void setVirtualMemory(CreateComputeResourceReservationRequestContainerFlavourVirtualMemory virtualMemory) {
    this.virtualMemory = virtualMemory;
  }

  public CreateComputeResourceReservationRequestContainerFlavour virtualNetworkInterface(CreateComputeResourceReservationRequestContainerFlavourVirtualNetworkInterface virtualNetworkInterface) {
    this.virtualNetworkInterface = virtualNetworkInterface;
    return this;
  }

   /**
   * Get virtualNetworkInterface
   * @return virtualNetworkInterface
  **/
  @ApiModelProperty(required = true, value = "")
  public CreateComputeResourceReservationRequestContainerFlavourVirtualNetworkInterface getVirtualNetworkInterface() {
    return virtualNetworkInterface;
  }

  public void setVirtualNetworkInterface(CreateComputeResourceReservationRequestContainerFlavourVirtualNetworkInterface virtualNetworkInterface) {
    this.virtualNetworkInterface = virtualNetworkInterface;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateComputeResourceReservationRequestContainerFlavour createComputeResourceReservationRequestContainerFlavour = (CreateComputeResourceReservationRequestContainerFlavour) o;
    return Objects.equals(this.accelerationCapability, createComputeResourceReservationRequestContainerFlavour.accelerationCapability) &&
        Objects.equals(this.flavourId, createComputeResourceReservationRequestContainerFlavour.flavourId) &&
        Objects.equals(this.storageAttributes, createComputeResourceReservationRequestContainerFlavour.storageAttributes) &&
        Objects.equals(this.virtualCpu, createComputeResourceReservationRequestContainerFlavour.virtualCpu) &&
        Objects.equals(this.virtualMemory, createComputeResourceReservationRequestContainerFlavour.virtualMemory) &&
        Objects.equals(this.virtualNetworkInterface, createComputeResourceReservationRequestContainerFlavour.virtualNetworkInterface);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accelerationCapability, flavourId, storageAttributes, virtualCpu, virtualMemory, virtualNetworkInterface);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateComputeResourceReservationRequestContainerFlavour {\n");
    
    sb.append("    accelerationCapability: ").append(toIndentedString(accelerationCapability)).append("\n");
    sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
    sb.append("    storageAttributes: ").append(toIndentedString(storageAttributes)).append("\n");
    sb.append("    virtualCpu: ").append(toIndentedString(virtualCpu)).append("\n");
    sb.append("    virtualMemory: ").append(toIndentedString(virtualMemory)).append("\n");
    sb.append("    virtualNetworkInterface: ").append(toIndentedString(virtualNetworkInterface)).append("\n");
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

