/* Programmer : Lefkopoulou Eleni Maria 
 * AEM : 2557 
 * class : ProductDao
 * role : makes the sql quire
 */

package com.hw3.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hw3.model.ProductInfo;
import com.hw3.util.HibernateUtil;

public class ProductDao {
	
	/**
	 * Save User
	 * @param user
	 */
	public int saveUser(ProductInfo product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(product);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			//e.printStackTrace();
			return(1);
		}
		return(0);
	}



}