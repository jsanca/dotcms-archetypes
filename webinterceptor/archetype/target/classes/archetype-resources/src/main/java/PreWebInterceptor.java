#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ${groupId}.filters.interceptor.Result;
import ${groupId}.filters.interceptor.WebInterceptor;
import com.dotmarketing.filters.Constants;

/**
 * This web interceptor adds the access control allow origin in addition to overrides the request and response
 * @author jsanca
 */
public class PreWebInterceptor implements WebInterceptor {

    @Override
    public String[] getFilters() {
        return new String[] {"/app/helloworld"};
    }

    @Override
    public Result intercept(final HttpServletRequest request,
                            final HttpServletResponse response) throws IOException {


        final String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
        switch (action) {
            case "break":
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getOutputStream().println("Breaking the PreWebInterceptor and sending 400 error code - bad request");
                return Result.SKIP_NO_CHAIN;
                
            case "rewrite":
                request.setAttribute(Constants.CMS_FILTER_URI_OVERRIDE, "/");
                return Result.NEXT;
                
            case "redirect":
                response.sendRedirect("/");
                return Result.SKIP_NO_CHAIN;
                
            default:
                response.getOutputStream().println("Hello PreWebInterceptor! Try passing ${symbol_escape}n${symbol_escape}n"
                                + "?action=break     - Stops processing${symbol_escape}n"
                                + "?action=rewrite   - rewrites the url to /${symbol_escape}n"
                                + "?action=redirect  - redirects the url to / ");
                return Result.SKIP_NO_CHAIN;
                
                
        }


    }

}
