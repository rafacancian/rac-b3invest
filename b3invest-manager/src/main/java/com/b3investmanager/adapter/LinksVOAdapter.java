package com.b3investmanager.adapter;

import com.b3investmanager.model.LinksVO;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

public class LinksVOAdapter {

    public static LinksVO create(final Links links) {
        if (!ObjectUtils.isEmpty(links)) {
            return new ModelMapper().map(links, LinksVO.class);
        }
        return LinksVO.builder().build();
    }

    public static LinksVO create(PagedModel pagedModel) {
        return LinksVO.builder()
                .first(getLink(pagedModel.getLink(IanaLinkRelations.FIRST)))
                .next(getLink(pagedModel.getNextLink()))
                .self(getLink(pagedModel.getLink(IanaLinkRelations.SELF)))
                .prev(getLink(pagedModel.getPreviousLink()))
                .last(getLink(pagedModel.getLink(IanaLinkRelations.LAST)))
                .build();
    }

    private static String getLink(final Optional link) {
        return link.isPresent() ? ((Link) link.get()).getHref() : "";
    }

}
