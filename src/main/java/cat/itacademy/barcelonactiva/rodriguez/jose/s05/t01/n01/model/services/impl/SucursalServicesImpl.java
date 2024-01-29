package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.impl;


import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.entity.Sucursal;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalAlreadyExistException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.repository.SucursalRepository;
import cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.model.services.SucursalServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServicesImpl implements SucursalServices {

    private final SucursalRepository sucursalRepository;

    public SucursalServicesImpl(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    @Override
    public List<Sucursal> getAllSucursals() {
        return sucursalRepository.findAllByOrderById();
    }

    @Override
    public Sucursal getSucursalById(Long id) {
        return sucursalRepository.findById(id).orElseThrow(() -> new SucursalNotFoundException("Sucursal Not Found with ID: " + id));
    }

    @Override
    public List<Sucursal> getSucursalContaining(String name) {
        return sucursalRepository.findByNameContainingIgnoreCaseOrderById(name);
    }

    @Override
    SucursalDto createSucursal(SucursalDto sucursalDto) {
        sucursalRepository.findByNameIgnoreCase(sucursalDto.getNomSucursal())
                .ifPresent(sucursal1 -> {
                    throw new SucursalAlreadyExistException("Already exist sucursal with given name:" + sucursalDto.getNomSucursal());
                });
        // Convert UserDto into User JPA Entity
        Sucursal sucursal = SucursalMapper.mapToUser(sucursalDto);

        Sucursal savedSucursal = sucursalRepository.save(sucursal);

        // Convert User JPA entity to UserDto
        SucursalDto savedSucursalDto = SucursalMapper.mapToSucDto(savedSucursal);

        return savedSucursalDto;
    }

    @Override
    public Sucursal updateSucursal(Long id, Sucursal sucursal) {
        if (id == null) {
            throw new IllegalArgumentException("Sucursal ID cannot be null");
        }
        Sucursal existingSucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Fruit Not Found with ID: " + id));
        existingSucursal.setNomSucursal(sucursal.getNomSucursal());
        existingSucursal.setPaisSucursal(sucursal.getPaisSucursal());
        return sucursalRepository.save(existingSucursal);
    }

    @Override
    public void deleteSucursalById(Long id) {
        Sucursal existingSucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal Not Found with ID: " + id));
        sucursalRepository.deleteById(existingSucursal.getPk_SucursalID());

    }

    /*@Service
    @AllArgsConstructor
    public class UserServiceImpl implements UserService {

        private UserRepository userRepository;



        @Override
        public UserDto getUserById(Long userId) {
            Optional<User> optionalUser = userRepository.findById(userId);
            User user = optionalUser.get();
            return UserMapper.mapToUserDto(user);
        }

        @Override
        public List<UserDto> getAllUsers() {
            List<User> users = userRepository.findAll();
            return users.stream().map(UserMapper::mapToUserDto)
                    .collect(Collectors.toList());
        }

        @Override
        public UserDto updateUser(UserDto user) {
            User existingUser = userRepository.findById(user.getId()).get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            User updatedUser = userRepository.save(existingUser);
            return UserMapper.mapToUserDto(updatedUser);
        }

        @Override
        public void deleteUser(Long userId) {
            userRepository.deleteById(userId);
        }
    }*/
}
