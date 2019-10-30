package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListBook;
import model.BookDetails;


public class BookDetailsHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookDbWebApp2");

	public void insertNewBookDetails(BookDetails bd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<BookDetails> getBookDetails() {
		EntityManager em = emfactory.createEntityManager();
		List<BookDetails> allBookDetails = em.createQuery("SELECT d FROM BookDetails d").getResultList();
		return allBookDetails;
	}
	
	public BookDetails searchForBookDetailsByDetailId(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		BookDetails found = em.find(BookDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void deleteBookDetails(BookDetails detailToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();//ID or Id?
		TypedQuery<BookDetails> typedQuery = em.createQuery("select d from BookDetails d where d.id = :selectedId", BookDetails.class);
		typedQuery.setParameter("selectedId", detailToDelete.getDetailId());
	
		typedQuery.setMaxResults(1);
		
		BookDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBookDetails(BookDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
			
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
}
