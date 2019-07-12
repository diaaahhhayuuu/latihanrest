package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//@Getter @Setter  //
//@EqualsAndHashCode
//@ToString

@Data // bisa dipersingkat gettersetter, equals dan tostring 
@EqualsAndHashCode(callSuper = true) // artinya ikut sm parents. kalo false enggak
@ToString(callSuper = true)
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {
	
	@ApiModelProperty(value = "Brand's ID (Primary key)")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // karena auto increment
	private Long id;

	@ApiModelProperty(value = "Brand's Name", required = true)
	@Column(nullable = false)
	private String name;

	@ApiModelProperty(value = "Product's Type", required = true)
	@Column(name = "product_type")
	private String productType;
}
