package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.prs.db.DBUtil;

public class PurchaseRequestLineItemDB {
	
	public static PurchaseRequestLineItem getPurchaseRequestLineItemById(int purchaseRequestLineItemID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequestLineItem purchaseRequestLineItem = em.find(PurchaseRequestLineItem.class, purchaseRequestLineItemID);
			
			return purchaseRequestLineItem;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
	}

	public static List<PurchaseRequestLineItem> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequestLineItem> purchaseRequestLineItems = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT p FROM PurchaseRequestLineItem p");
			purchaseRequestLineItems = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return purchaseRequestLineItems;
	}
	
	public static boolean add(PurchaseRequestLineItem purchaseRequestLineItem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean success = false;
;
		try {
			trans.begin();
			em.persist(purchaseRequestLineItem);
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
	
	public static void delete(PurchaseRequestLineItem purchaseRequestLineItem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.remove(em.merge(purchaseRequestLineItem));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}

}
