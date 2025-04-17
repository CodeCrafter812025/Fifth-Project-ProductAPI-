package net.holosen.app.model;

import lombok.*;
import net.holosen.app.model.enums.APIStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
    private String message = "";
    private APIStatus status;
    private T data;
}
