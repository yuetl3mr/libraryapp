package dao;

import java.util.List;

import dao.template.AbstractHibernateDao;
import persistence.ManagerSystem;

public class HibernateManagerSystemDao extends AbstractHibernateDao implements ManagerSystemDao {
	private static final String getAllManagerSystem = "SELECT * FROM managersystem";
	
	@Override
	public List<ManagerSystem> getAll() {
		return openSession().createNativeQuery(getAllManagerSystem, ManagerSystem.class).getResultList();
	}
}
