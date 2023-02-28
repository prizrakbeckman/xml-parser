package com.epam.xmlparser.validator;

import com.epam.xmlparser.model.exception.InvalidEPaperXMLFileException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

@Service
public class XmlDocumentValidator implements DocumentValidator<MultipartFile> {
    @Value("${filename.xsd.template}")
    private String xsdPath;
    public void validate(MultipartFile multipartFile) throws InvalidEPaperXMLFileException {
        try {
            Resource resource = new ClassPathResource(xsdPath);
            File file = resource.getFile();
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(file);
            schema.newValidator();
        } catch (SAXException | IOException e) {
            throw new InvalidEPaperXMLFileException();
        }
    }

}
