package fer.rest;

import fer.rest.model.MyDate;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("date/{dateString}")
public class DateResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getRequestedDate(@PathParam("dateString") MyDate myDate, @QueryParam("dateString2") MyDate myDate2){
        return "got " + myDate.toString() + " query: " +myDate2.toString();
    }
}
