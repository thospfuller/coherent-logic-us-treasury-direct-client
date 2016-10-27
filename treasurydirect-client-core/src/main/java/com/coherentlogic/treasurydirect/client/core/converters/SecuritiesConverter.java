package com.coherentlogic.treasurydirect.client.core.converters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.coherentlogic.treasurydirect.client.core.domain.Securities;

/**
 * @author <a href="https://www.linkedin.com/in/thomasfuller">Thomas P. Fuller</a>
 * @author <a href="mailto:support@coherentlogic.com">Support</a>
 */
public class SecuritiesConverter implements HttpMessageConverter<Securities> {

    @Override
    public boolean canRead(Class clazz, MediaType mediaType) {

        return (
            Securities.class.equals(clazz)
            &&
            (MediaType.APPLICATION_JSON.equals(mediaType) || MediaType.APPLICATION_JSON_UTF8.equals(mediaType))
        );

//        throw new UnsupportedOperationException("[canRead] The Securities class will never be read; class: "+ clazz +
//            ", mediaType: " + mediaType);
    }

    @Override
    public boolean canWrite(Class target, MediaType mediaType) {
        return Securities.class.equals(target)
            && (MediaType.APPLICATION_JSON.equals(mediaType) || MediaType.APPLICATION_JSON_UTF8.equals(mediaType));
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8);
    }

    @Override
    public Securities read(Class target, HttpInputMessage inputMessage)
        throws IOException, HttpMessageNotReadableException {

        Securities result = new Securities ();

        return result;
    }

    @Override
    public void write(Securities securities, MediaType contentType, HttpOutputMessage outputMessage)
        throws IOException, HttpMessageNotWritableException {
        throw new UnsupportedOperationException("[write] The Securities class will never be written.");
    }
}
