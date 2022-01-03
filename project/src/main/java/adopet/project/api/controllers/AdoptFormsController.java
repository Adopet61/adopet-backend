package adopet.project.api.controllers;

import adopet.project.business.abstracts.AdoptFormService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.forms.AdoptForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/adoptForms")
public class AdoptFormsController {
    private AdoptFormService adoptFormService;

    @Autowired
    public AdoptFormsController(AdoptFormService adoptFormService) {
        super();
        this.adoptFormService = adoptFormService;
    }

    @GetMapping("/getAll")
    public DataResult<List<AdoptForm>> getAll(){
        return this.adoptFormService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody AdoptForm adoptForm){
        return ResponseEntity.ok(this.adoptFormService.add(adoptForm));
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.adoptFormService.delete(id);
    }

    @GetMapping("/getByFirstName")
    public DataResult<List<AdoptForm>> getByFirstName(@RequestParam String firstName){
        return this.adoptFormService.getByFirstName(firstName);
    }

    @GetMapping("/getByLastName")
    public DataResult<List<AdoptForm>> getByLastName(@RequestParam String lastName) {
        return this.adoptFormService.getByLastName(lastName);
    }

    @GetMapping("/getByPhoneNumber")
    public DataResult<List<AdoptForm>> getByPhoneNumber(@RequestParam String phoneNumber) {
        return this.adoptFormService.getByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getByEmail")
    public DataResult<List<AdoptForm>> getByEmail(@RequestParam String email) {
        return this.adoptFormService.getByEmail(email);
    }

    @GetMapping("/getByHaveAPet")
    public DataResult<List<AdoptForm>> getByHaveAPet(@RequestParam boolean haveAPet) {
        return this.adoptFormService.getByHaveAPet(haveAPet);
    }

    @GetMapping("/getByComment")
    public DataResult<List<AdoptForm>> getByComment(String comment) {
        return this.adoptFormService.getByComment(comment);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //AOP
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
