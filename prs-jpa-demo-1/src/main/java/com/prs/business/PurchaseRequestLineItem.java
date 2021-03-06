package com.prs.business;

import javax.persistence.*;

@Entity
public class PurchaseRequestLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private int purchaseRequestId;
    @ManyToOne
    @JoinColumn(name="purchaseRequestId")
    private PurchaseRequest purchaseRequest;
//    private int productId;
    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	@Override
	public String toString() {
		return "PurchaseRequestLineItem [id=" + id + ", Purchase Request: " + purchaseRequest.getId() + " " + purchaseRequest.getUser() + ", Product: "
				+ product + ", quantity=" + quantity + "]";
	}
    
    
}
