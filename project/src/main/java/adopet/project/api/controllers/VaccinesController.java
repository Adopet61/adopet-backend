package adopet.project.api.controllers;

import adopet.project.business.abstracts.VaccineService;
import adopet.project.core.utilities.results.DataResult;
import adopet.project.core.utilities.results.Result;
import adopet.project.entities.concretes.Vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vaccines")
@CrossOrigin
public class VaccinesController {

    private VaccineService vaccineService;

    @Autowired
    public VaccinesController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping("/getall")
    public DataResult<List<Vaccine>> getAll() {
        return this.vaccineService.getAll();
    }

    @GetMapping("/getByVaccineId")
    public DataResult<Vaccine> getByVaccineId(@RequestParam int vaccineId) {
        return this.vaccineService.getByVaccineId(vaccineId);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Vaccine vaccine) {
        return this.vaccineService.add(vaccine);
    }
    @PostMapping("/update")
    public Result update(@RequestBody Vaccine vaccine){
        return this.vaccineService.update((vaccine));
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int vaccineId){
        return this.vaccineService.delete(vaccineId);
    }
}
