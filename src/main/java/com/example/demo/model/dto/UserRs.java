package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRs {
    private Long id;
    private String email;
    @Builder.Default
    private List<DocShortRs> listDoc = new ArrayList<>();
}
