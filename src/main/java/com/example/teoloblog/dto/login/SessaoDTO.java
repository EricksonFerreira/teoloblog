package com.example.teoloblog.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SessaoDTO {
    private String login;
    private String token;
    private String prefix;
}
