package com.mannai.dto;

import lombok.Builder;

@Builder
public record ErrorDto(String msg) {
}
