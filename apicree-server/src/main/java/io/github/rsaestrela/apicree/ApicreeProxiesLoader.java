package io.github.rsaestrela.apicree;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@Component
public class ApicreeProxiesLoader {

    public ApicreeProxies getApicreeProxies() {
        try {
            JAXBContext context = JAXBContext.newInstance(ApicreeProxies.class);
            Unmarshaller unMarshaller = context.createUnmarshaller();
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("ApicreeProxies.xml");
            return (ApicreeProxies) unMarshaller.unmarshal(is);
        } catch (Exception e) {
            throw new IllegalStateException("Failed reading ApicreeProxies configuration file!");
        }
    }

}