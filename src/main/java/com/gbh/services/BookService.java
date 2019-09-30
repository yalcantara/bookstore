package com.gbh.services;

import com.gbh.entities.Book;
import com.gbh.entities.BookPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.List;

import static com.gbh.core.Utils.*;

@Service
public class BookService {

    public static final int DEFAULT_LIMIT = 1000;

    @PersistenceContext
    private EntityManager em;


    public long count(){
        String jpql;
        jpql = "select count(b) ";
        jpql += "from Book b ";

        Query q = em.createQuery(jpql);
        q.setMaxResults(1);

        long count = ((Number)q.getSingleResult()).longValue();

        return count;
    }

    @SuppressWarnings("unchecked")
    public List<Book> list() {

        String jpql;

        jpql = "select b ";
        jpql += "from Book b ";
        jpql += "order by b.title asc";

        Query q = em.createQuery(jpql);
        q.setMaxResults(DEFAULT_LIMIT);

        List<Book> list = q.getResultList();


        //It is a good practice to detach the entities when returning them to the
        //controller or non managed class.

        //Es siempre una buena practica el desvincular las entidades cuando se
        //retornan al controllador o una clase no gestionada.
        detach(list);

        return list;
    }

    public Book find(long id){
        checkParamIsPositive("id", id);

        Book ent = em.find(Book.class, id);
        detach(ent);

        return ent;
    }

    @Transactional
    public long save(Book book){
        checkParamNotNull("book", book);

        em.persist(book);
        em.flush();
        detach(book);
        long id = book.getId();
        return id;
    }

    public BookPage findPage(long bookId, int page){

        checkParamIsPositive("bookId", bookId);
        checkParamIsPositive("page", page);

        String jpql;
        jpql = "select  p ";
        jpql += "from BookPage p ";
        jpql += "where p.bookId.id = :id ";
        jpql += "and p.page = :page";

        Query q = em.createQuery(jpql);
        q.setMaxResults(1);
        q.setParameter("id", bookId);
        q.setParameter("page", page);

        // Even tho we setMaxResults to 1, it is a good practice to call
        // getResultList in this case, because a book may not contain any pages
        // (db issues), and the method getSingleResult will throw an exception.

        // Aunque hemos asignado 1 al metodo setMaxResults, en este caso es una
        // buena practica llamar el metodo getResultList, ya que un libro puede
        // que no contenga paginas (error de data), entonces el metodo
        // getSingleResult lanzaría una exception.
        List<BookPage> list = q.getResultList();

        if(list.isEmpty()){
            return null;
        }

        BookPage ans = list.get(0);

        return ans;
    }

    @Transactional
    public void savePages(long bookId, List<BookPage> pages){
        checkParamIsPositive("bookId", bookId);
        checkParamNotNull("pages", pages);

        Book ref = em.getReference(Book.class, bookId);

        if(ref == null){
            throw new BadRequestException("Could not find a book with id " + bookId + ".");
        }

        for(BookPage page:pages){
            page.setBookId(ref);
            em.persist(page);
        }

        em.flush();
    }


    @SuppressWarnings("rawtypes")
    private void detach(Object obj) {
        if (obj == null) {
            return;
        }

        if (obj instanceof Collection) {
            detach((Collection) obj);
            return;
        }

        em.detach(obj);
    }

    @SuppressWarnings("rawtypes")
    private void detach(Collection list) {
        if (list == null) {
            return;
        }

        for (Object e : list) {
            if (e != null) {
                em.detach(e);
            }
        }
    }

}
