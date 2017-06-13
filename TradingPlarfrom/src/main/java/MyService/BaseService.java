/**
 * <p>author:lijie</p>
 * <p>上午9:51:10</p>
 */
package MyService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


	
/**  
* <p>Title: baseFacade</p>  
* <p>Description: </p>  
* <p>Company: </p>   
* @author lijie 
* @date 2017年6月8日  上午9:51:10  
*/
public abstract class BaseService {

	@PersistenceContext
	protected EntityManager entityManager;

	protected BaseService() {
	}
		
}
