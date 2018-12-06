/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Entidades.OSocial;
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
public class OSocialJpaController implements Serializable {

    public OSocialJpaController() {
        this.emf = Persistence.createEntityManagerFactory("Hospital_zunda_2.0PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OSocial OSocial) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(OSocial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OSocial OSocial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OSocial = em.merge(OSocial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = OSocial.getCodigoOoss();
                if (findOSocial(id) == null) {
                    throw new NonexistentEntityException("The oSocial with id " + id + " no longer exists.");
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
            OSocial OSocial;
            try {
                OSocial = em.getReference(OSocial.class, id);
                OSocial.getCodigoOoss();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The OSocial with id " + id + " no longer exists.", enfe);
            }
            em.remove(OSocial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OSocial> findOSocialEntities() {
        return findOSocialEntities(true, -1, -1);
    }

    public List<OSocial> findOSocialEntities(int maxResults, int firstResult) {
        return findOSocialEntities(false, maxResults, firstResult);
    }

    private List<OSocial> findOSocialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OSocial.class));
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

    public OSocial findOSocial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OSocial.class, id);
        } finally {
            em.close();
        }
    }

    public int getOSocialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OSocial> rt = cq.from(OSocial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
