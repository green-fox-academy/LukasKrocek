package com.example.trialexam.services;


import com.example.trialexam.models.Link;

import java.util.List;

public interface LinkService {

    boolean aliasExists(String alias);

    void saveLink (Link link);

    Link findLinkByAlias(String alias);

    List <Link> getAllLinks ();

    boolean iDExists (Long id);

    Link findLinkById (Long id);

    void deleteLink (Link link);
}
