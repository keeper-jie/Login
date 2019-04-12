package Dao.proxy;

import Dao.IUserDAO;
import Dao.UserDAOImpI;
import Dbc.DatabaseConnection;
import Vo.User;

public class UserDAOProxy implements IUserDAO {

	private DatabaseConnection dbc=null;//定义数据库连接
    private IUserDAO dao=null;//定义DAO接口
    public UserDAOProxy(){
    	try {
			dbc=new DatabaseConnection();//实例化数据库连接
		} catch (Exception e) {
			e.printStackTrace();
		}
    	dao=new UserDAOImpI(dbc.getConnection());
    	
    }
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag=false;
		try {
			flag=dao.findLogin(user);//调用真实主题
		} catch (Exception e) {
			throw e;
		}finally{
			dbc.close();
		}
		return flag;
	}


}
