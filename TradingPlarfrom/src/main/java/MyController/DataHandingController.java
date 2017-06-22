/**
 * <p>author:lijie</p>
 * <p>下午12:15:38</p>
 */
package MyController;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * Title: DataHanding
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author lijie
 * @date 2017年6月22日 下午12:15:38
 */
@Controller
@RequestMapping("data-handing")
public class DataHandingController {

	@RequestMapping("/index")
	public String DataHandingIndex(HttpServletRequest request) {
		return "dataHanding/index.html";
	}

	@RequestMapping(value = "/save-data", method = { RequestMethod.POST })
	public void addData() {

	}
}
