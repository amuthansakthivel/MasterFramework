package com.tmb.pages.web.validator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomePageValidator {
    private String headerName;
    private boolean isMarketplaceLinkPresent;
    private String logoSourceText;
}
