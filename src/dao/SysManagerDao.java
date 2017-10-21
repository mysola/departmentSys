package dao;

import domain.SysManager;

public interface SysManagerDao {
	/**
	 * 
	 * @param manager,包含username 和password
	 * @return
	 * @throws Exception
	 */
	public SysManager get(SysManager manager);
}
