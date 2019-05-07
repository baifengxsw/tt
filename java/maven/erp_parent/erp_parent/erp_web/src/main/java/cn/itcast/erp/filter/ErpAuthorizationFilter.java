package cn.itcast.erp.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

public class ErpAuthorizationFilter extends AuthorizationFilter{
    //TODO - complete JavaDoc

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
    	/**
    	 * 获取主题
    	 */
        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;

        boolean isPermitted = true;
        if(null == perms || perms.length == 0) {
        	return isPermitted;
        }
        if (perms != null && perms.length > 0) {
           /* if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    isPermitted = false;
                }
            } else {
                if (!subject.isPermittedAll(perms)) {
                    isPermitted = false;
                }
            }*/
        	for(String perm:perms) {
        		if(subject.isPermitted(perm)) {
        			return true;
        		}
        	}
        }

        return false;
    }
}
