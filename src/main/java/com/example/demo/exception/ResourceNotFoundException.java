
// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus(HttpStatus.NOT_FOUND)
// public class ResourceNotFoundException extends RuntimeException {

//     public ResourceNotFoundException(String entityName, Long id) {
//         super(entityName + " not found with id: " + id);
//     }

//     public ResourceNotFoundException(String message) {
//         super(message);
//     }
// }




package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
