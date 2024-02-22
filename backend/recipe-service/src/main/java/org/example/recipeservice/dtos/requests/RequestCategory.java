package org.example.recipeservice.dtos.requests;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCategory {
    private Long id;
    private String name;
}
