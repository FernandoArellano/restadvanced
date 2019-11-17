package fer.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test2")
public class MyResource2 {

    @PathParam("pathParam") private String pathParamExample;
    @QueryParam("queryParam") private String queryParamExample;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "works path param: "+ pathParamExample + " query param: " + queryParamExample;
    }
}
