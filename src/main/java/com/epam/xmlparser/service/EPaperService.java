package com.epam.xmlparser.service;

import com.epam.xmlparser.model.entities.EPaper;
import com.epam.xmlparser.repository.EPaperRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Service
public class EPaperService {

    private final EPaperRepository ePaperRepository;

    public EPaperService(EPaperRepository ePaperRepository) {
        this.ePaperRepository = ePaperRepository;
    }


    public List<EPaper> findAllEPapers(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<EPaper> pagedResult = ePaperRepository.findAll(paging);

        return getEPapers(pagedResult);
    }

    public List<EPaper> findAll(){
        return ePaperRepository.findAll();
    }

    public EPaper save(EPaper ePaper){
        return ePaperRepository.save(ePaper);
    }

    private static List<EPaper> getEPapers(Page<EPaper> pagedResult) {
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }


}
