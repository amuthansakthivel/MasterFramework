package com.tmb.pages.validator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomePageValidator {
    private String headerName;
    private boolean isMarketplaceLinkPresent;
    private String logoSourceText;
}
