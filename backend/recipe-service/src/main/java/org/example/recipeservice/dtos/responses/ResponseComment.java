package org.example.recipeservice.dtos.responses;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseComment {

    private Long id;
    private String content;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime createdAt;

}
