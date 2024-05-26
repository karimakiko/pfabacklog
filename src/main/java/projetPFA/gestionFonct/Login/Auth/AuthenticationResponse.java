package projetPFA.gestionFonct.Login.Auth;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder


public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
}
