/**
 * <p>author:lijie</p>
 * <p>上午9:50:46</p>
 */
package MyService;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Entity.UserMain;



/**  
* <p>Title: userFacade</p>  
* <p>Description: </p>  
* <p>Company: </p>   
* @author lijie 
* @date 2017年6月8日  上午9:50:46  
*/
@Component
public class UserService extends BaseService {
	
	public boolean getUser(String userName,String passWord){
		boolean isSuccessfully = false;
//		entityManager.find(UserMain.class, arg1)
//		String Sql = "select u from UserMain u where u.userName = '"+userName+"' and u.userPwd ='"+passWord+"'";
		String Sql = "select u from UserMain u where u.userName = '"+userName+"' and u.userPwd ='"+passWord+"'";
		Session session = HibernateSessionFactory.getSession();
		List<UserMain> userList= (List<UserMain>) session.createQuery(Sql);
		if (userList.size()>0) {
			isSuccessfully = true;
		}
		return isSuccessfully;
		
		
	} 
}
