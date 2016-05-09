package com.manvendrask.services

import com.manvendrask.domains.Vehicle

/**
 * @author Manvendra SK on 9/5/16.
 */
class VehicleService {

    def saveVehicle() {
        println "saving vehicle"
        new Vehicle(name: "Vento").save(flush:true)
    }

    def updateVehicle() {
        println "Updating vehicle"
    }
}
