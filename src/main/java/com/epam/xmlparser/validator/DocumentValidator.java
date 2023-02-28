package com.epam.xmlparser.validator;

import com.epam.xmlparser.model.exception.EPaperXMLDocumentException;

public interface DocumentValidator<T> {

    void validate(T file) throws EPaperXMLDocumentException;

}
