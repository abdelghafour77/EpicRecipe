package org.example.recipeservice.dtos.responses;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategory {
    private Long id;
    private String name;
    private String image;
}
