package com.epam.xmlparser.model.exception;

public class InvalidEPaperXMLFileException extends EPaperXMLDocumentException {

    private static final String MESSAGE = "This xml file is not valid";
    public InvalidEPaperXMLFileException() {
        super(MESSAGE);
    }
}
