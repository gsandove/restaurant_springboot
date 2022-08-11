package com.dev.restaurants.repository;

import com.dev.restaurants.domain.Personals;
import com.dev.restaurants.dto.response.Restaurants.PersonalsRestaurantsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonalsRespository extends JpaRepository<Personals, Long> {

    @Query(value = "SELECT new com.dev.restaurants.dto.response.Restaurants.PersonalsRestaurantsResponse(per.id,per.persons.fullname,per.persons.sex,per.personalsTypes.name) " +
            "FROM Personals per " +
            "WHERE per.restaurants.id=:restaurantId")
    List<PersonalsRestaurantsResponse> getPersonalsByRestaurantsId(@Param("restaurantId")Long restaurantId) throws Exception;

    Personals findPersonalsByPersons_DocumentNumber(String documentNumber)throws Exception;
}