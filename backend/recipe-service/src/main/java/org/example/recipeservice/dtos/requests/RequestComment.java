package org.example.recipeservice.dtos.requests;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestComment {

    private String content;

    private Long userId;

    private Long recipeId;
}
