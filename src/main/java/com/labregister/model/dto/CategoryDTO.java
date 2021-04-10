package com.labregister.model.dto;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"items",
"lastUpdate",
"name",
"attribute1",
"attribute2",
"attribute3"
})
public class CategoryDTO {

@JsonProperty("id")
private Long id;
@JsonProperty("items")
private Set<ItemDTO> items;
@JsonProperty("lastUpdate")
private String lastUpdate;
@NotBlank(message="Name field is mandatory")
@JsonProperty("name")
private String name;
@JsonProperty("attribute1")
private String attribute1;
@JsonProperty("attribute2")
private String attribute2;
@JsonProperty("attribute3")
private String attribute3;

}