/**
 * <p>author:lijie</p>
 * <p>下午5:07:42</p>
 */
package MyController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import MyService.UserService;

/**
 * <p>
 * Title: HelloCtroller
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author lijie
 * @date 2017年6月10日 下午5:07:42
 */
@Controller
@RequestMapping("main")
public class HelloCtroller {

	@Autowired
	private UserService userfacade;

	@RequestMapping("/login")
	public String Login(HttpServletRequest request) {
//		if (userfacade.getUser("admin", "admin")) {
//			System.out.print("successfully");
//		}
		return "/main/login.html";
	}
	
	@RequestMapping("/hello")
	public String Hello(HttpServletRequest request) {
		if (userfacade.getUser("admin", "admin")) {
			System.out.print("successfully");
		}
		return "/main/index.html";
	}

}
