package persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class DAO<PersistentObj extends Serializable, KeyType> {

	protected Session session;

	protected DAO() {
		this.session = HibernateUtil.getSession();
	}

	protected void begin() {
		session.beginTransaction();
	}

	protected void commit() {
		session.getTransaction().commit();
	}

	protected void rollback() {
		session.getTransaction().rollback();
	}

	public void create(PersistentObj obj) {
		try {
			begin();
			session.save(obj);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
	}

	public void delete(PersistentObj obj) {
		try {
			begin();
			session.delete(obj);
			commit();
		} catch (HibernateException e) {
			rollback();
		}

	}

	public void update(PersistentObj obj) {
		try {
			begin();
			session.update(obj);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
	}

	public void load(PersistentObj obj) {
		try {
			begin();
			session.load(obj.getClass(), obj);
			commit();
		} catch (HibernateException e) {
			rollback();
		}
	}
	
	public abstract PersistentObj loadByID(KeyType obj);
	public abstract List<PersistentObj> list();
		
	

}
