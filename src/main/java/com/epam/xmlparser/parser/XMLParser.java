package com.epam.xmlparser.parser;

import com.epam.xmlparser.model.exception.EPaperXMLDocumentException;
import com.epam.xmlparser.model.request.EpaperRequestType;
import com.epam.xmlparser.validator.XmlDocumentValidator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

@Service
public class XMLParser {

    private final XmlDocumentValidator xmlDocumentValidator;

    public EpaperRequestType parseRequests(MultipartFile inputFile)
            throws JAXBException, EPaperXMLDocumentException, IOException {
        xmlDocumentValidator.validate(inputFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(EpaperRequestType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (EpaperRequestType) jaxbUnmarshaller.unmarshal(inputFile.getInputStream());
    }

    public XMLParser(XmlDocumentValidator xmlDocumentValidator) {
        this.xmlDocumentValidator = xmlDocumentValidator;
    }

}
