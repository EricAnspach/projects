package com.prs.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.prs.db.DBUtil;

public class VendorDB {
	
	public static Vendor getVendorById(int vendorID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Vendor vendor = em.find(Vendor.class, vendorID);
			
			return vendor;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<Vendor> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Vendor> vendors = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT v FROM Vendor v");
			vendors = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return vendors;
	}
	
	public static boolean add(Vendor vendor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean success = false;
;
		try {
			trans.begin();
			em.persist(vendor);
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
	
	public static void delete(Vendor vendor) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		
		try {
			trans.begin();
			em.remove(em.merge(vendor));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}
}





