package controller;

import model.ListBook;

//import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Robert Hoehle
 */
//@Entity
public class ListBookHelper {

    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BookDbWebApp2");

    public void insertBook(ListBook lb) {
        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(lb);
        em.getTransaction().commit();
        em.close();
    }

    public List<ListBook> showAllBooks() {
        EntityManager em = emfactory.createEntityManager();
		List<ListBook> allBooks = em.createQuery("SELECT lb FROM ListBook lb").getResultList();
        return allBooks;
    }

    public void deleteBook(ListBook toDelete) {

        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListBook> typedQuery = em.createQuery(
                "select lb from ListBook lb where lb.title = :selectedTitle and lb.author = :selectedAuthor",
                ListBook.class);
        // Substitute parameter with actual data from the toDelete item
        typedQuery.setParameter("selectedTitle", toDelete.getTitle());
        typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());

        // we only want one result
        typedQuery.setMaxResults(1);

        // get the result and save it into a new list item
        ListBook result = typedQuery.getSingleResult();

        // remove it
        em.remove(result);
        em.getTransaction().commit();
        em.close();

    }

    public ListBook searchForBookById(int idToEdit) {

        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        ListBook found = em.find(ListBook.class, idToEdit);
        em.close();
        return found;
    }

    public void updateBook(ListBook toEdit) {

        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();

        em.merge(toEdit);
        em.getTransaction().commit();
        em.close();
    }

    public List<ListBook> searchForBookByTitle(String titleName) {

        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListBook> typedQuery = em.createQuery("select lb from ListItem lb where lb.title = :selectedTitle", ListBook.class);
        typedQuery.setParameter("selectedTitle", titleName);

        List<ListBook> foundBooks = typedQuery.getResultList();
        em.close();
        return foundBooks;
    }

    public List<ListBook> searchForBookByAuthor(String authorName) {

        EntityManager em = emfactory.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<ListBook> typedQuery = em.createQuery("select lb from ListItem lb where lb.author = :selectedAuthor", ListBook.class);
        typedQuery.setParameter("selectedAuthor", authorName);

        List<ListBook> foundBooks = typedQuery.getResultList();
        em.close();
        return foundBooks;
    }

    public void cleanUp(){
        emfactory.close();
    }

}
