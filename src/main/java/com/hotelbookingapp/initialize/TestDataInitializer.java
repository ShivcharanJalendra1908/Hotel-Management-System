package com.hotelbookingapp.initialize;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hotelbookingapp.model.*;
import com.hotelbookingapp.model.enums.RoleType;
import com.hotelbookingapp.model.enums.RoomType;
import com.hotelbookingapp.repository.*;

import java.time.LocalDate;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestDataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final HotelManagerRepository hotelManagerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AddressRepository addressRepository;
    private final HotelRepository hotelRepository;
    private final AvailabilityRepository availabilityRepository;

    @Override
    @Transactional
    public void run(String... args) {

        try {
            log.warn("Checking if test data persistence is required...");

            if (roleRepository.count() == 0 && userRepository.count() == 0) {
                log.info("Initiating test data persistence");

                Role adminRole = new Role(RoleType.ADMIN);
                Role customerRole = new Role(RoleType.CUSTOMER);
                Role hotelManagerRole = new Role(RoleType.HOTEL_MANAGER);

                roleRepository.save(adminRole);
                roleRepository.save(customerRole);
                roleRepository.save(hotelManagerRole);
                log.info("Role data persisted");

                User user1 = User.builder().username("admin@hotel.com").password(passwordEncoder.encode("1")).name("Admin").lastName("Admin").role(adminRole).build();
                User user2 = User.builder().username("customer1@hotel.com").password(passwordEncoder.encode("1")).name("Shivcharan").lastName("Jalendra").role(customerRole).build();
                User user3 = User.builder().username("manager1@hotel.com").password(passwordEncoder.encode("1")).name("Anju").lastName("Kumari").role(hotelManagerRole).build();
                User user4 = User.builder().username("manager2@hotel.com").password(passwordEncoder.encode("1")).name("Mahesh").lastName("Kumar").role(hotelManagerRole).build();

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
                userRepository.save(user4);

                Admin admin1 = Admin.builder().user(user1).build();
                Customer c1 = Customer.builder().user(user2).build();
                HotelManager hm1 = HotelManager.builder().user(user3).build();
                HotelManager hm2 = HotelManager.builder().user(user4).build();

                adminRepository.save(admin1);
                customerRepository.save(c1);
                hotelManagerRepository.save(hm1);
                hotelManagerRepository.save(hm2);
                log.info("User data persisted");

                Address address1 = Address.builder().addressLine("Near Golden Temple").city("Punjab")
                        .country("India").build();
                Address address2 = Address.builder().addressLine("Near Airport").city("Chandigarh")
                        .country("India").build();
                Address address3 = Address.builder().addressLine("Near IGI Airport").city("Delhi")
                        .country("India").build();
                Address address4 = Address.builder().addressLine("Near CDAC Noida").city("Noida")
                        .country("India").build();
                Address address5 = Address.builder().addressLine("Near Gateway of India").city("Mumbai")
                        .country("India").build();
                Address address6 = Address.builder().addressLine("Near Solang Valley, Manali").city("Himachal")
                        .country("India").build();

                addressRepository.save(address1);
                addressRepository.save(address2);
                addressRepository.save(address3);
                addressRepository.save(address4);
                addressRepository.save(address5);
                addressRepository.save(address6);

                Hotel hotel1 = Hotel.builder().name("Mannat Hotel")
                        .address(address1).hotelManager(hm1).build();
                Hotel hotel2 = Hotel.builder().name("Hotel Sky")
                        .address(address2).hotelManager(hm1).build();
                Hotel hotel3 = Hotel.builder().name("Hotel Raddisson Blu")
                        .address(address3).hotelManager(hm1).build();
                Hotel hotel4 = Hotel.builder().name("Hotel Surya Palace")
                        .address(address4).hotelManager(hm2).build();
                Hotel hotel5 = Hotel.builder().name("Hotel Taj")
                        .address(address5).hotelManager(hm2).build();
                Hotel hotel6 = Hotel.builder().name("The Himalayans")
                        .address(address6).hotelManager(hm2).build();

                Room singleRoom1 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(800).roomCount(35).hotel(hotel1).build();
                Room doubleRoom1 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(1500).roomCount(45).hotel(hotel1).build();

                Room singleRoom2 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(1500).roomCount(25).hotel(hotel2).build();
                Room doubleRoom2 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(2500).roomCount(30).hotel(hotel2).build();

                Room singleRoom3 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(2500).roomCount(30).hotel(hotel3).build();
                Room doubleRoom3 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(5000).roomCount(75).hotel(hotel3).build();

                Room singleRoom4 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(600).roomCount(25).hotel(hotel4).build();
                Room doubleRoom4 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(1100).roomCount(15).hotel(hotel4).build();

                Room singleRoom5 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(5000).roomCount(50).hotel(hotel5).build();
                Room doubleRoom5 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(9000).roomCount(50).hotel(hotel5).build();

                Room singleRoom6 = Room.builder().roomType(RoomType.SINGLE)
                        .pricePerNight(1500).roomCount(45).hotel(hotel6).build();
                Room doubleRoom6 = Room.builder().roomType(RoomType.DOUBLE)
                        .pricePerNight(2500).roomCount(25).hotel(hotel6).build();

                hotel1.getRooms().addAll(Arrays.asList(singleRoom1,doubleRoom1));
                hotel2.getRooms().addAll(Arrays.asList(singleRoom2,doubleRoom2));
                hotel3.getRooms().addAll(Arrays.asList(singleRoom3,doubleRoom3));
                hotel4.getRooms().addAll(Arrays.asList(singleRoom4,doubleRoom4));
                hotel5.getRooms().addAll(Arrays.asList(singleRoom5,doubleRoom5));
                hotel6.getRooms().addAll(Arrays.asList(singleRoom6,doubleRoom6));

                hotelRepository.save(hotel1);
                hotelRepository.save(hotel2);
                hotelRepository.save(hotel3);
                hotelRepository.save(hotel4);
                hotelRepository.save(hotel5);
                hotelRepository.save(hotel6);
                log.info("Hotel data persisted");

                Availability av1 = Availability.builder().hotel(hotel4)
                        .date(LocalDate.of(2024,9,1)).room(singleRoom4).availableRooms(5).build();
                Availability av2 = Availability.builder().hotel(hotel4)
                        .date(LocalDate.of(2024,9,2)).room(doubleRoom4).availableRooms(7).build();

                availabilityRepository.save(av1);
                availabilityRepository.save(av2);
                log.info("Availability data persisted");

            } else {
                log.info("Test data persistence is not required");
            }
            log.warn("App ready");
        } catch (DataAccessException e) {
            log.error("Exception occurred during data persistence: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected exception occurred: " + e.getMessage());
        }
    }
}
