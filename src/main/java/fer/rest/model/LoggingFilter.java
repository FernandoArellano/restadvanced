package fer.rest.model;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("Request Filter");
        System.out.println("headers: " + containerRequestContext.getHeaders());
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        System.out.println("Response Filter");
        System.out.println("headers: " + containerResponseContext.getHeaders());
    }
}
