package no.fhe.gui.login;

import lombok.Builder;
import lombok.Data;
import org.joda.time.LocalDate;

public @Data @Builder
class LoginVo {
    private final String userId;
    private final String firstname;
    private final String lastname;
    private final String mobilephone;
    private final String email;
    private final String password;
    private final int loginAttempts;
    private final LocalDate loginDate;
    private final String loginKey;
    private final String role;
}
