package ir.dayan.footballmatchproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {

    private final static String SUCCESS_MESSAGE = "عملیات با موفقیت انجام شد";

    private int status;

    private String message;

    private T data;

    public static <T> ResponseDTO<T> successful(T data) {
        ResponseDTO<T> generalResponse = new ResponseDTO<T>();
        generalResponse.setData(data);
        generalResponse.setStatus(200);
        generalResponse.setMessage(SUCCESS_MESSAGE);
        return generalResponse;
    }

}
