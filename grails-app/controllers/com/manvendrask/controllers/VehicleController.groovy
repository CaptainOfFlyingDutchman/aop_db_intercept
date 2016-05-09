package com.manvendrask.controllers

/**
 * @author Manvendra SK on 9/5/16.
 */
class VehicleController {

    def vehicleService

    def index() {
        vehicleService.saveVehicle()
    }

    def update() {
        vehicleService.updateVehicle()

        render '.........'
    }
}
