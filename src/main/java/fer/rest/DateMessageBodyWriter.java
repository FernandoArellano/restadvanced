package fer.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date> {

    @Override
    public boolean isWriteable(Class<?> classType, Type type, Annotation[] annotations, MediaType mediaType) {
        return Date.class.isAssignableFrom(classType);
    }

    @Override
    public long getSize(Date date, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Date date, Class<?> classType, Type type, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap,
                        OutputStream outputStream) throws IOException, WebApplicationException {

        outputStream.write(date.toString().getBytes());

    }
}
