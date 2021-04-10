package com.labregister.model.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"category",
"lastUpdate",
"name",
"brand",
"initialQuantity"
})
@ToString
public class ItemDTO {

@JsonProperty("id")
private Long id;
@NotNull(message="Category Id is Mandatory")
@JsonProperty("category")
private CategoryDTO category;
@JsonProperty("lastUpdate")
private String lastUpdate;
@JsonProperty("name")
private String name;
@JsonProperty("brand")
private String brand;
@JsonProperty("initialQuantity")
private Long initialQuantity;


}