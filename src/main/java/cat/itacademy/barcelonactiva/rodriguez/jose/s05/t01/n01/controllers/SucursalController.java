package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.controllers;

import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Country;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.CountryServices;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        model.addAttribute("title", "Formulario de Sucursal");
        model.addAttribute("sucursal",sucursalDto);
        model.addAttribute("countries",countryList);
        return "/views/sucursal/frmCreate";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute SucursalDto sucursalDto, BindingResult result, Model model){
        List<Country> countryList = countryServices.countryList();
        if(result.hasErrors()){
            model.addAttribute("title", "Formulario de Sucursal");
            model.addAttribute("sucursal",sucursalDto);
            model.addAttribute("countries",countryList);
            System.out.println("Errors in Form!");
            return "/views/sucursal/frmCreate";
        }
        sucursalServices.createSucursal(sucursalDto);
        System.out.println("Sucursal saved!");
        return "redirect:/views/sucursal/getAll";
    }

    @GetMapping(path = "/update/{id}")
    public String updateSucursal(@PathVariable("id") Long idSucursal, Model model){
        SucursalDto updatedSucursal = sucursalServices.getSucursalById(idSucursal);
        List<Country> countryList = countryServices.countryList();
        model.addAttribute("title", "Actualizar Sucursal");
        model.addAttribute("sucursal",updatedSucursal);
        model.addAttribute("countries",countryList);
        return "/views/sucursal/frmCreate";
    }
    @GetMapping(path = "/delete/{id}")
    public String deleteSucursal(@PathVariable("id") Long idSucursal){
        sucursalServices.deleteSucursalById(idSucursal);
        System.out.println("Sucursal deleted!");
        return "redirect:/views/sucursal/getAll";
    }
}