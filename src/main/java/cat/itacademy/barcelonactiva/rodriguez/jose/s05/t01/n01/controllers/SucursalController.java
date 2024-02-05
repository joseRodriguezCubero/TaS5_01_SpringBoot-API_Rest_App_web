package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Country;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.CountryServices;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/views/sucursal")
@RequiredArgsConstructor
public class SucursalController {
    private SucursalServices sucursalServices;

    private CountryServices countryServices;

    @Autowired
    public SucursalController(SucursalServices sucursalServices, CountryServices countryServices) {
        this.sucursalServices = sucursalServices;
        this.countryServices = countryServices;
    }


    @GetMapping(path = "/getAll")
    public String getAllSucursals(Model model) {
        List<SucursalDto> sucursalList = sucursalServices.getAllSucursals();
        model.addAttribute("title", "Listado de Sucursales");
        model.addAttribute("sucursales", sucursalList);
        return "views/sucursal/list";
    }


    @GetMapping(path = "/getOne/{id}")
    public ResponseEntity<SucursalDto> getSucursalById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sucursalServices.getSucursalById(id));
    }

    @GetMapping(path = "/add")
    public String createSucursal(Model model){
        SucursalDto sucursalDto = new SucursalDto();
        List<Country> countryList = countryServices.countryList();
        model.addAttribute("title", "Formulario de Sucursales");
        model.addAttribute("sucursal",sucursalDto);
        model.addAttribute("countries",countryList);
        //sucursalServices.createSucursal(sucursalDto);
        return "views/sucursal/frmCreate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute SucursalDto sucursalDto){
        sucursalServices.createSucursal(sucursalDto);
        return "redirect:/views/sucursal/getAll";
    }


    @PutMapping(path = "/update{id}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable(value = "id") Long id,
                                                      @RequestBody SucursalDto sucursalDto) {
        SucursalDto updatedSucursal = sucursalServices.updateSucursal(sucursalDto);
        return new ResponseEntity<>(updatedSucursal, HttpStatus.OK);
    }


    @DeleteMapping(value = "/sucursal/delete/{id}")
    public ResponseEntity<String> deleteSucursal(@PathVariable Long id) {
        sucursalServices.deleteSucursalById(id);
        return new ResponseEntity<>(("Sucursal deleted successfully- Sucursal ID:" + id), HttpStatus.OK);
    }
}