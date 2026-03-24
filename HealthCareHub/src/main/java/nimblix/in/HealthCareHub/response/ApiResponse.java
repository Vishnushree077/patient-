package nimblix.in.HealthCareHub.response;


import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;

//    public ApiResponse() {}
//
//    public ApiResponse(boolean success, String message, T data) {
//        this.success = success;
//        this.message = message;
//        this.data = data;
//    }



}
