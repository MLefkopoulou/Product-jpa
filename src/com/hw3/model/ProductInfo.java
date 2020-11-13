/* Programmer : Lefkopoulou Eleni Maria 
 * AEM : 2557 
 * class : ProductInfo
 * role : class for the product information
 */
package com.hw3.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class ProductInfo{

	@Column(name="name")
	protected String Name;
	@Column(name="color")
	protected String Color;
	@Column(name="description")
	protected String Description;
	@Id
	@Column(name="barcode")
	protected String Barcode;

	public ProductInfo() {
		super();
		this.Name = "";
		this.Color = "";
		this.Description = "";
		this.Barcode = "";
	}
	public ProductInfo(String Name,String Color,String Description,String Barcode) {
		super();
		this.Name = Name;
		this.Color = Color;
		this.Description = Description;
		this.Barcode = Barcode;
		
	}
	//Name
	public String getName() {
		return Name;
		
	}
	public void setName(String Name){
		this.Name = Name;
		
	}
	//Color
	public String getColor() {
		return Color;
		
	}
	public void setColor(String Color){
		this.Color = Color;
		
	}
	//Description
	public String getDescription() {
		return Description;
		
	}
	public void setDescription(String Description) {
		this.Description = Description;
		
	}
	//
	public String getBarcode() {
		return Barcode;
		
	}
	public void setBarcode(String Barcode){
		this.Barcode = Barcode;
		
	}
	
}