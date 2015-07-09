package no.fhe.gui.search;

import lombok.Builder;
import lombok.Data;

public @Data @Builder class SearchVo {
    private final String userId;
    private final String firstname;
    private final String lastname;
    private final String mobilephone;
    private final String email;
}
