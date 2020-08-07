package br.com.cityconnect.integrador_sa_transportes.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.cityconnect.integrador_sa_transportes.util.Logger;

public abstract class GenericDao<T extends Serializable, PK> {

    private final EntityManagerFactory factory;

    private Class<?> clazz;
    
	///////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    ///////////////////////////////////////////////////////////////////
    public GenericDao() {
    	factory = DAOFactory.entityManagerFactorInstance();
    	
    	this.clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

	///////////////////////////////////////////////////////////////////
    // CRUD Methods
    ///////////////////////////////////////////////////////////////////
    protected Object executeQuery(String query, Object... params) {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
	        Query createdQuery = em.createQuery(query);
	
	        for (int i = 0; i < params.length; i++) {
	            createdQuery.setParameter(i, params[i]);            
	        }
	        
	        return createdQuery.getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return null;
		} finally{
			close(em);
		}
	        
    }
    
    protected Object executeQuery(String query, Long... params) {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
	        Query createdQuery = em.createQuery(query);
	
	        for (int i = 0; i < params.length; i++) {
	            createdQuery.setParameter(i, params[i]);            
	        }
	        
	        return createdQuery.getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return null;
		} finally{
			close(em);
		}
	        
    }
    
    protected Object executeQueryGenericParams(String query, Object... params) {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
	        Query createdQuery = em.createQuery(query);
	
	        for (int i = 0; i < params.length; i++) {
	        	if(params[i] instanceof String){
		            createdQuery.setParameter(i, (String)params[i]);            
	        	}else if(params[i] instanceof Integer){
		            createdQuery.setParameter(i, (Integer)params[i]);            
	        	}else if(params[i] instanceof Long){
		            createdQuery.setParameter(i, (Long)params[i]);            
	        	}else if(params[i] instanceof Boolean){
		            createdQuery.setParameter(i, (Boolean)params[i]);            
	        	}
	        }
	        
	        return createdQuery.getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return null;
		} finally{
			close(em);
		}
	        
    }

    protected List<T> findAll() {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
    		return em.createQuery(("FROM " + this.clazz.getName()))
                .getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return new ArrayList<>();
		} finally{
			close(em);
		}
    }
    
    protected List<T> findAll(String orderByField) {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
    		return em.createQuery(("FROM " + this.clazz.getName()+" order by "+orderByField))
                .getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return new ArrayList<>();
		} finally{
			close(em);
		}
    }
    
    public List<Long> findAllIDs() {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
    		return em.createQuery(("select id FROM " + this.clazz.getName()))
                .getResultList();
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return new ArrayList<>();
		} finally{
			close(em);
		}
    }

    public T findById(String pk) {
    	EntityManager em = null;
    	try {
    		if(pk!=null && pk.isEmpty()==false){
    			em  = factory.createEntityManager();    		
    			return (T) em.find(this.clazz, new Long(pk));
    		}else{
    			return null;
    		}
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return null;
		} finally{
			close(em);
		}
    }
    public T findById(PK pk) {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
    		return (T) em.find(this.clazz, pk);
    	}catch (Exception e) {
    		Logger.sendLog(this.clazz, Logger.ERROR, e);
    		rollBack(em);
        	return null;
		} finally{
			close(em);
		}
    }

    public List<T> findById(List<Long> ids, String orderField) {
		EntityManager em = null;
    	try {
    		em = getEntityManager();   		
    		
			CriteriaBuilder builder = em.getCriteriaBuilder();
			
			CriteriaQuery<T> criteria = (CriteriaQuery<T>) builder.createQuery(this.clazz);
			Root<T> root = (Root<T>) criteria.from(this.clazz);
			
			Predicate[] predicates = new Predicate[ids.size()];
			for (int cont = 0;cont < ids.size();cont++) {
				predicates[cont] = builder.equal(root.get("id"), ids.get(cont).toString());
	        }
			
			criteria.where(builder.or((Predicate[]) predicates));		
	
			if(orderField!=null && orderField.isEmpty()==false){
				criteria.orderBy(builder.asc(root.get(orderField)));
			}
		
			return em.createQuery(criteria).getResultList();
		}catch (Exception e) {
			Logger.sendLog(this.getClass(), Logger.ERROR, e);
	    	return new ArrayList<>();
		} finally{
			close(em);
		}        
	}
    
    public List<T> findByIdString(List<String> ids, String orderField) {
		EntityManager em = null;
    	try {
    		
    		List<Long> usuariosListAuxLong = new ArrayList<Long>();
			for (String s : ids) {
				usuariosListAuxLong.add(new Long(s));    		
			}
			
			return findById(usuariosListAuxLong, orderField);
		}catch (Exception e) {
			Logger.sendLog(this.getClass(), Logger.ERROR, e);
	    	return new ArrayList<>();
		} finally{
			close(em);
		}        
	}
    
    public boolean save(T entity)  {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
            beginTransaction(em);
            em.persist(entity);
            commit(em);
            
            return Boolean.TRUE;
	    }catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
			rollBack(em);
	    	return Boolean.FALSE;
		} finally{
			close(em);
		}
    }
    
    public T saveReturningEntity(T entity)  {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
            beginTransaction(em);
            em.persist(entity);
            commit(em);
            
            return entity;
	    }catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
			rollBack(em);
	    	return null;
		} finally{
			close(em);
		}
    }
    
    //esta protected pois e uma funcao muito sensivel precisando ser  analisada antes da atualizacao
    protected boolean update(T entity)  {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
            beginTransaction(em);
            em.merge(entity);
            commit(em);
            
            return Boolean.TRUE;
	    }catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
			rollBack(em);
	    	return Boolean.FALSE;
		} finally{
			close(em);
		}
    }

    public boolean delete(T entity)  {
    	EntityManager em = null;
    	try {
    		em  = factory.createEntityManager();
    		
            beginTransaction(em);
            em.remove(em.merge(entity));
            em.flush();
            commit(em);
            
            return Boolean.TRUE;
	    }catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
			rollBack(em);
	    	return Boolean.FALSE;
		} finally{
			close(em);
		}
    }

    //public abstract List<T> find(String search, Integer actual, Integer max, String field, String order);
    //public abstract Integer findSize(String search);

	///////////////////////////////////////////////////////////////////
    // Transaction Methods
    ///////////////////////////////////////////////////////////////////
    protected void beginTransaction(EntityManager entityManager) {
        entityManager.getTransaction().begin();
    }

    protected void commit(EntityManager entityManager) {
        entityManager.getTransaction().commit();
    }

    protected void close(EntityManager entityManager) {
    	try {
    		if(entityManager!=null){
    			entityManager.close();
    		}
    	} catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
		}
        //this.factory.close();
    }

    protected void rollBack(EntityManager entityManager) {
    	try {
    		if(entityManager!=null){
    			entityManager.getTransaction().rollback();
    		}
    	} catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
		}
    }

    protected EntityManager getEntityManager() {
    	try {
    		return factory.createEntityManager();
    	} catch (Exception e) {
			Logger.sendLog(this.clazz, Logger.ERROR, e);
			return null;
		}
    }


}
