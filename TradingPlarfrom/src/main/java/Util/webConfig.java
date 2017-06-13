/**
 * <p>author:lijie</p>
 * <p>����5:10:40</p>
 */
package Util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
* <p>Title: webConfig</p>  
* <p>Description: </p>  
* <p>Company: </p>   
* @author lijie 
* @date 2017��6��2��  ����5:10:40  
*/
@Configuration
@EnableWebMvc
public class webConfig extends WebMvcConfigurerAdapter {
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
registry.addResourceHandler("/js/**").addResourceLocations("/js/");
registry.addResourceHandler("/css/**").addResourceLocations("/css/");
}
}