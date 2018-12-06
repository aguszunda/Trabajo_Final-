/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.Cobertura;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Agustin
 */
public class CoberturaJpaController implements Serializable {

    public CoberturaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Hospital_zunda_2.0PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cobertura cobertura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cobertura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cobertura cobertura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cobertura = em.merge(cobertura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cobertura.getNro_cobertura();
                if (findCobertura(id) == null) {
                    throw new NonexistentEntityException("The cobertura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cobertura cobertura;
            try {
                cobertura = em.getReference(Cobertura.class, id);
                cobertura.getNro_cobertura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cobertura with id " + id + " no longer exists.", enfe);
            }
            em.remove(cobertura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cobertura> findCoberturaEntities() {
        return findCoberturaEntities(true, -1, -1);
    }

    public List<Cobertura> findCoberturaEntities(int maxResults, int firstResult) {
        return findCoberturaEntities(false, maxResults, firstResult);
    }

    private List<Cobertura> findCoberturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cobertura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cobertura findCobertura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cobertura.class, id);
        } finally {
            em.close();
        }
    }

    public int getCoberturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cobertura> rt = cq.from(Cobertura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
