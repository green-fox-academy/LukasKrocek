package com.example.trialexam.services;

import com.example.trialexam.models.Link;
import com.example.trialexam.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public boolean aliasExists(String alias) {
        return linkRepository.findFirstByAlias(alias).isPresent();
    }

    public Link findLinkByAlias(String alias) {
        Optional<Link> linkOptional = linkRepository.findFirstByAlias(alias);
        if (linkOptional.isPresent()) {
            Link link = linkOptional.get();
            link.incrementHitCount();
            linkRepository.save(link);
            return link;
        }
        else return null;
    }

    public void saveLink(Link link) {
        linkRepository.save(link);
    }

    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public boolean iDExists(Long id) {
        return linkRepository.findFirstById(id).isPresent();
    }

    @Override
    public Link findLinkById(Long id) {
        return linkRepository.findFirstById(id).get();
    }

    public void deleteLink(Link link) {
        linkRepository.delete(link);
    }
}
