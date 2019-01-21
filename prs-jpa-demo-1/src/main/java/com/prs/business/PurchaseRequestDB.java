package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.prs.db.DBUtil;

public class PurchaseRequestDB {

	public static PurchaseRequest getPurchaseRequestById(int purchaseRequestID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequest purchaseRequest = em.find(PurchaseRequest.class, purchaseRequestID);			
			return purchaseRequest;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}		
	}

	public static List<PurchaseRequest> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequest> purchaseRequests = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT p FROM PurchaseRequest p");
			purchaseRequests = q.getResultList();			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return purchaseRequests;
	}
	
	public static boolean add(PurchaseRequest purchaseRequest) {
		//
		// need to make sure this is right
		//
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean success = false;
;
		try {
			trans.begin();
			em.persist(purchaseRequest);
			trans.commit();
			success = true;
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		return success;
	}
	
	public static void delete(PurchaseRequest purchaseRequest) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.remove(em.merge(purchaseRequest));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}		
	}
	
	public static double getPurchaseRequestTotal(int prid) {						
		// A - Get the PRID from PRLI		
		// B - Get all PRLIs for PRID
		
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequestLineItem> lineItems = new ArrayList<>();
		try {
			String qString = "SELECT p FROM PurchaseRequestLineItem p "
							+ "WHERE p.purchaseRequest.id = :inPrid";
			TypedQuery<PurchaseRequestLineItem> tq = em.createQuery(qString, PurchaseRequestLineItem.class);
			tq.setParameter("inPrid", prid);			
			
			lineItems = tq.getResultList();			
		}
		finally {
			em.close();
		}
				
		// C - Define total = 0
		double purchaseRequestTotal = 0.00;
		
		// D - Loop through PRLIs for each:
		for (int i = 0; i < lineItems.size(); i++) {
			// 		calculate subtotal (qty * price)
			//		add subtotal to total
			
			PurchaseRequestLineItem prli = lineItems.get(i);
			Product product = prli.getProduct();
			double price = product.getPrice();
			double quantity = prli.getQuantity();
			
			double subtotal = price * quantity;
			purchaseRequestTotal += subtotal;
		}					
					
		// E - Set new total in PR total
		return purchaseRequestTotal;
	}
}
