package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("/api")
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    //@RequestMapping(path = "/hotels", method = RequestMethod.GET)
    @GetMapping("/hotels")
    public List<Hotel> list() {
        List<Hotel> hotelList = hotelDao.getHotels();
        return hotelList;
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    //@RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    @GetMapping("/hotels/{id}")
    public Hotel get(@PathVariable int id) {
        Hotel hotel = hotelDao.getHotelById(id);
        return hotel;
    }


    /**
     * Returns all reservations in the system
     *
     * @return all reservations
     */
    @GetMapping("/reservations")
    public List<Reservation> listReservations(){
        List<Reservation> reservations = reservationDao.getReservations();
        return reservations;
    }


    /**
     * Get a reservation by its id
     *
     * @param id
     * @return a single reservation
     *
     */
    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable int id){
        Reservation reservation = reservationDao.getReservationById(id);
        return reservation;
    }


    /**
     * List of reservations by hotel
     *
     * @param hotelId
     * @return all reservations for a given hotel
     *
     */
    @GetMapping("/hotels/{id}/reservations")
    public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId){
        List<Reservation> reservations = reservationDao.getReservationsByHotel(hotelId);
        return reservations;
    }


    /**
     * Create a new reservation for a given hotel
     *
     * @param reservation
     */
    @PostMapping("/reservations")
    public Reservation addReservation(@RequestBody Reservation reservation){
        Reservation newReservation = reservationDao.createReservation(reservation);
        return newReservation;
    }


    /**
     * Filter hotels by state and city
     *
     * @param state the state to filter by
     * @param city the city to filter by
     * @return a list of hotels that match the city and state
     *
     */
    //example client request:  http://localhost:8080/filteredHotels?state=ohio&city=cleveland
    @GetMapping("/filteredHotels")
    public List<Hotel> filterByStateAndCity(@RequestParam String state, @RequestParam(defaultValue = "") String city){
        List<Hotel> filteredHotels = hotelDao.getHotelsByStateAndCity(state, city);
        return filteredHotels;

    }



}
