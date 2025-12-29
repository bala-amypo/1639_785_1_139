



// package com.example.demo.controller;

// import com.example.demo.entity.TransferEvaluationResult;
// import com.example.demo.service.TransferEvaluationService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/transfer-evaluations")
// public class TransferEvaluationResultController {

//     private final TransferEvaluationService ser;

//     public TransferEvaluationResultController(TransferEvaluationService ser) {
//         this.ser = ser;
//     }

//     // simple create using repository-backed postData4
//     @PostMapping
//     public TransferEvaluationResult create(@RequestBody TransferEvaluationResult result) {
//         return ser.postData4(result);
//     }

//     @GetMapping
//     public List<TransferEvaluationResult> getAll() {
//         // matches getAllData4()
//         return ser.getAllData4();
//     }

//     @GetMapping("/{id}")
//     public TransferEvaluationResult getById(@PathVariable Long id) {
//         return ser.getEvaluationById(id);
//     }

//     @PutMapping("/{id}")
//     public TransferEvaluationResult update(@PathVariable Long id,
//                                            @RequestBody TransferEvaluationResult result) {
//         // matches updateData4(Long, TransferEvaluationResult)
//         return ser.updateData4(id, result);
//     }

//     @DeleteMapping("/{id}")
//     public void delete(@PathVariable Long id) {
//         // matches DeleteData4(Long)
//         ser.DeleteData4(id);
//     }
// }









package com.example.demo.controller;

import com.example.demo.dto.TransferEvaluationRequest;
import com.example.demo.dto.TransferEvaluationResponse;
import com.example.demo.entity.TransferEvaluationResult;
import com.example.demo.service.TransferEvaluationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfer-evaluations")
@Tag(name = "Transfer Evaluation")
public class TransferEvaluationController {

    private final TransferEvaluationService service;

    public TransferEvaluationController(TransferEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public TransferEvaluationResponse evaluate(@RequestBody TransferEvaluationRequest req) {

        TransferEvaluationResult res =
                service.evaluateTransfer(
                        req.getSourceProgramId(),
                        req.getTargetProgramId()
                );

        TransferEvaluationResponse dto = new TransferEvaluationResponse();
        dto.setTotalTransferableCredits(
                res.getCreditHourDifference() == null ? 0.0 :
                        (double) res.getCreditHourDifference()
        );
        dto.setStatus(res.getIsEligibleForTransfer() ? "APPROVED" : "REJECTED");
        dto.setRemarks(res.getNotes());

        return dto;
    }

    @GetMapping("/{id}")
    public TransferEvaluationResult getById(@PathVariable Long id) {
        return service.getEvaluationById(id);
    }
}
