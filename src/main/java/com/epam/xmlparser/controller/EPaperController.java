package com.epam.xmlparser.controller;

import com.epam.xmlparser.mapper.EPaperRequestEventInfoMapper;
import com.epam.xmlparser.model.entities.EPaper;
import com.epam.xmlparser.model.exception.EPaperXMLDocumentException;
import com.epam.xmlparser.model.request.EpaperRequestType;
import com.epam.xmlparser.parser.XMLParser;
import com.epam.xmlparser.service.EPaperService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
public class EPaperController {

    private final XMLParser xmlParser;
    private final EPaperRequestEventInfoMapper ePaperRequestEventInfoMapper;
    private final EPaperService ePaperService;

    @PostMapping("/epaper-xml-file")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) throws JAXBException, IOException, EPaperXMLDocumentException {
        save(parseEventInfo(file));
        return ResponseEntity.status(HttpStatus.OK).body("file uploaded successfully " + file.getName());
    }

    @GetMapping("/epapers")
    public ResponseEntity<Collection<EPaper>> findAllEPapers() {
        return new ResponseEntity<>(ePaperService.findAll(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("epapers-pageable")
    public ResponseEntity<Collection<EPaper>> findAllPapersPageable(@RequestParam(defaultValue = "0") Integer pageNo,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<>(getAllEPapersPaged(pageNo, pageSize, sortBy),
                new HttpHeaders(), HttpStatus.OK);

    }

    private List<EPaper> getAllEPapersPaged(Integer pageNo, Integer pageSize, String sortBy) {
        return ePaperService.findAllEPapers(pageNo, pageSize, sortBy);
    }

    private void save(EPaper EPaper) {
        ePaperService.save(EPaper);
    }

    private EPaper parseEventInfo(MultipartFile multipartFile) throws IOException, JAXBException, EPaperXMLDocumentException {
        double start = System.currentTimeMillis();
        EpaperRequestType epaperRequest = parseFile(multipartFile);
        double finish = System.currentTimeMillis();
        double elapsedTime = start - finish;
        EPaper EPaper = ePaperRequestEventInfoMapper.mapEPaperRequestToEventInfo(epaperRequest.getDeviceInfo(), multipartFile.getName(), elapsedTime);
        return EPaper;
    }

    private EpaperRequestType parseFile(MultipartFile file) throws IOException, JAXBException, EPaperXMLDocumentException {
        return xmlParser.parseRequests(file);
    }

    public EPaperController(XMLParser xmlParser,
                            EPaperRequestEventInfoMapper ePaperRequestEventInfoMapper,
                            EPaperService ePaperService) {
        this.xmlParser = xmlParser;
        this.ePaperRequestEventInfoMapper = ePaperRequestEventInfoMapper;
        this.ePaperService = ePaperService;
    }

}
