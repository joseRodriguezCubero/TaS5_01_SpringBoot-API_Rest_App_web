package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.controllers;



import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SucursalController {

    private final SucursalServices sucursalServices;


    @GetMapping(path = "/sucursal/getAll")
    public ResponseEntity<List<SucursalDto>> getAllSucursals() {
        return ResponseEntity.ok().body(sucursalServices.getAllSucursals());
    }


    @GetMapping(path = "/sucursal/getOne/{id}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable Long id) {
        return ResponseEntity.ok().body(sucursalServices.getSucursalById(id));
    }


    @GetMapping(path = "/sucursal/getOne/{name}")
    public ResponseEntity<List<SucursalDto>> getSucursalsByNameContaining(@PathVariable String name) {
        return ResponseEntity.ok().body(sucursalServices.getSucursalContaining(name));
    }


    @PostMapping(path = "/sucursal/add",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SucursalDto> saveSucursal(@RequestBody SucursalDto sucursal){
        SucursalDto savedSucursal = sucursalServices.createSucursal(sucursal);
        return new ResponseEntity<>(savedSucursal, HttpStatus.CREATED);
    }


    @PutMapping(path = "/sucursal/update{id}")
    public ResponseEntity<SucursalDto> updateSucursal(@PathVariable(value = "id") Long id,
                                             @RequestBody SucursalDto sucursalDto) {
        return ResponseEntity.ok().body(sucursalServices.updateSucursal(id,sucursalDto));
    }


    @DeleteMapping(value = "/sucursal/delete/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable Long id) {
        sucursalServices.deleteSucursalById(id);
        return new ResponseEntity<>(("Sucursal deleted successfully- Sucursal ID:" + id), HttpStatus.OK);
    }
}

/*@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

        SucursalDto savedSucursal = sucursalServices.createSucursal(sucursal);
        return new ResponseEntity<>(savedSucursal, HttpStatus.CREATED);

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }*/