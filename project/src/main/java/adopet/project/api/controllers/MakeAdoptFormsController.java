package adopet.project.api.controllers;

import adopet.project.business.abstracts.MakeAdoptFormService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.ErrorDataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.forms.MakeAdoptForm;
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
@RequestMapping("/api/makeAdoptForms")
public class MakeAdoptFormsController {
    private MakeAdoptFormService makeAdoptFormService;

    @Autowired
    public MakeAdoptFormsController(MakeAdoptFormService makeAdoptFormService) {
        super();
        this.makeAdoptFormService = makeAdoptFormService;
    }

    @GetMapping("/getAll")
    public DataResult<List<MakeAdoptForm>> getAll(){
        return this.makeAdoptFormService.getAll();
    }

    @GetMapping("/getByFirstName")
    public DataResult<List<MakeAdoptForm>> getByFirstName(@RequestParam String firstName) {
        return this.makeAdoptFormService.getByFirstName(firstName);
    }

    @GetMapping("/getByLastName")
    public DataResult<List<MakeAdoptForm>> getByLastName(@RequestParam String lastName) {
        return this.makeAdoptFormService.getByLastName(lastName);
    }

    @GetMapping("/getByPhoneNumber")
    public DataResult<List<MakeAdoptForm>> getByPhoneNumber(@RequestParam String phoneNumber) {
        return this.makeAdoptFormService.getByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getByEmail")
    public DataResult<List<MakeAdoptForm>> getByEmail(@RequestParam String email) {
        return this.makeAdoptFormService.getByEmail(email);
    }

    @GetMapping("/getByAnimalName")
    public DataResult<List<MakeAdoptForm>> getByAnimalName(@RequestParam String animalName) {
        return this.makeAdoptFormService.getByAnimalName(animalName);
    }

    @GetMapping("/getByAnimalType")
    public DataResult<List<MakeAdoptForm>> getByAnimalType(@RequestParam String animalType) {
        return this.makeAdoptFormService.getByAnimalType(animalType);
    }

    @GetMapping("/getByAnimalBreed")
    public DataResult<List<MakeAdoptForm>> getByAnimalBreed(@RequestParam String animalBreed) {
        return this.makeAdoptFormService.getByAnimalBreed(animalBreed);
    }

    @GetMapping("/getByVaccine")
    public DataResult<List<MakeAdoptForm>> getByVaccine(@RequestParam String vaccine) {
        return this.makeAdoptFormService.getByVaccine(vaccine);
    }

    @GetMapping("/getByYearOfBirth")
    public DataResult<List<MakeAdoptForm>> getByYearOfBirth(@RequestParam int yearOfBirth) {
        return this.makeAdoptFormService.getByYearOfBirth(yearOfBirth);
    }

    @GetMapping("/getByAnimalSex")
    public DataResult<List<MakeAdoptForm>> getByAnimalSex(@RequestParam String animalSex) {
        return this.makeAdoptFormService.getByAnimalSex(animalSex);
    }

    @GetMapping("/getByBarren")
    public DataResult<List<MakeAdoptForm>> getByBarren(@RequestParam boolean barren) {
        return this.makeAdoptFormService.getByBarren(barren);
    }

    @GetMapping("/getByImageUrl")
    public DataResult<List<MakeAdoptForm>> getByImageUrl(@RequestParam String imageUrl) {
        return this.makeAdoptFormService.getByImageUrl(imageUrl);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody MakeAdoptForm makeAdoptForm){
        return ResponseEntity.ok(this.makeAdoptFormService.add(makeAdoptForm));
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.makeAdoptFormService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //AOP
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError: exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
