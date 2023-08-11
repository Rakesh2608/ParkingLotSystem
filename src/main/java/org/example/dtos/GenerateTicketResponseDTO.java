package org.example.dtos;


public class GenerateTicketResponseDTO {
    private Long generatedTicketId;
    private String message;
    private ResponseStatus responseStatus;

    public Long getGeneratedTicketId() {
        return generatedTicketId;
    }

    public void setGeneratedTicketId(Long generatedTicketId) {
        this.generatedTicketId = generatedTicketId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
