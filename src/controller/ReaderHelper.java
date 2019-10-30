package controller;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import model.Reader;

public class ReaderHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookDbWebApp2");

	public void insertReader(Reader r) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}

	public List<Reader> showAllReaders() {
		EntityManager em = emfactory.createEntityManager();
		List<Reader> allReaders = em.createQuery("SELECT r FROM Reader r").getResultList();
		return allReaders;
	}
	
	public void	deleteReader(Reader toDelete)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Reader>typedQuery = em.createQuery(
				"select r from Reader r where r.readerId = :selectedId",
				Reader.class);
		typedQuery.setParameter("selectedId", toDelete.getReaderId());
		
		typedQuery.setMaxResults(1);
		
		Reader result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Reader searchForReaderById(int idToEdit)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    Reader found = em.find(Reader.class, idToEdit);
	    em.close();
	    return found;
	}
	
	public Reader searchForReaderByName(String readerName)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<Reader> typedQuery = em.createQuery("select r from Reader r where r.readerName = :selectedName", Reader.class);
	    typedQuery.setParameter("selectedName", readerName);
	    typedQuery.setMaxResults(1);
	    
	    Reader	found =	typedQuery.getSingleResult();
	    
	    em.close();
	    return found;
	}
	
	public void updateReader(Reader toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);	
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
