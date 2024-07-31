/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banckend.curso.repositories.impl;

import com.banckend.curso.entities.Alumno;
import com.banckend.curso.repositories.AlumnosRepository;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Marcos
 */
public class AlumnosRepositoryImpl implements AlumnosRepository {

    private final EntityManagerFactory manager;    
    
    public AlumnosRepositoryImpl(){
        manager = Persistence
                .createEntityManagerFactory("com.banckend_curso_jar_1.0.0PU");
    }
    
    @Override
    public Optional<Alumno> findById(Long id) {
         EntityManager entityManage = null;
        try {
            entityManage = manager.createEntityManager();
            Alumno alumno = entityManage.find(Alumno.class, id);
            if (alumno != null) {
             return Optional.of(alumno);
            }
            return Optional.empty();
        } catch(Exception ex) {
            throw ex;
        }
        finally {
           if( entityManage != null) {
               entityManage.close();
           }
        }
    }

    @Override
    public Alumno save(Alumno alumno) {
        EntityManager entityManage = null;
        try {
            entityManage = manager.createEntityManager();
            entityManage.getTransaction().begin();
            entityManage.persist(alumno);
            entityManage.getTransaction().commit();
           return alumno;
        } catch(Exception ex) {
            if( entityManage != null) {
               entityManage.getTransaction().rollback();
            }
            throw ex;
        }
        finally {
           if( entityManage != null) {
               entityManage.close();
           }
        }
    }

    @Override
    public Alumno update(Alumno alumno) {
         EntityManager entityManage = null;
        try {
            entityManage = manager.createEntityManager();
            entityManage.getTransaction().begin();
            entityManage.merge(alumno);
            entityManage.getTransaction().commit();
           return alumno;
        } catch(Exception ex) {
            if( entityManage != null) {
               entityManage.getTransaction().rollback();
            }
            throw ex;
        }
        finally {
           if( entityManage != null) {
               entityManage.close();
           }
        }
    }

    @Override
    public void delete(Alumno alumno) {
         EntityManager entityManage = null;
        try {
            entityManage = manager.createEntityManager();
            entityManage.getTransaction().begin();
            entityManage.remove(alumno);
            entityManage.getTransaction().commit();
        } catch(Exception ex) {
            if( entityManage != null) {
               entityManage.getTransaction().rollback();
            }
            throw ex;
        }
        finally {
           if( entityManage != null) {
               entityManage.close();
           }
        }
    }

    @Override
    public  Optional<Alumno> findByCurp(String curp) {
         EntityManager entityManage = null;
        try {
            entityManage = manager.createEntityManager();
            Query query = entityManage.createNamedQuery("Alumno.findByCurp", Alumno.class);
            query.setParameter("curp", curp);
            if (!query.getResultList().isEmpty()) {                
              Alumno alumno = (Alumno)query.getResultList().get(0);
              return Optional.of(alumno);
            }
            return Optional.empty();
        } catch(Exception ex) {
            throw ex;
        }
        finally {
           if( entityManage != null) {
               entityManage.close();
           }
        }
    }
    
}
