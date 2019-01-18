package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
}
