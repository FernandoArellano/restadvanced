package fer.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("test3")
public class MyResource3 {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date test(){
        return Calendar.getInstance().getTime();
    }
}
