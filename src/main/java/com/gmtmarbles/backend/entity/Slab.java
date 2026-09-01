package com.gmtmarbles.backend.entity;
import java.math.BigDecimal;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Slab {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String slabCode;
	private String material;
	private BigDecimal length;
	private BigDecimal width;
	private BigDecimal thickness;
	private BigDecimal purchasePrice;
	@Enumerated(EnumType.STRING)
	private SlabStatus status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSlabCode() {
		return slabCode;
	}
	public void setSlabCode(String slabCode) {
		this.slabCode = slabCode;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public BigDecimal getLength() {
		return length;
	}
	public void setLength(BigDecimal length) {
		this.length = length;
	}
	public BigDecimal getWidth() {
		return width;
	}
	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	public BigDecimal getThickness() {
		return thickness;
	}
	public void setThickness(BigDecimal thickness) {
		this.thickness = thickness;
	}
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public SlabStatus getStatus() {
		return status;
	}
	public void setStatus(SlabStatus status) {
		this.status = status;
	}
}
