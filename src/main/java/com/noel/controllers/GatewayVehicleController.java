package com.noel.controllers;

import com.noel.model.Vehicle;
import com.noel.proxy.VehicleProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicles")
@AllArgsConstructor
public class GatewayVehicleController {
    private final VehicleProxy vehicleProxy;

    @GetMapping
    public Vehicle[] getAllVehicles() {
        return vehicleProxy.getAllVehicles();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable String vehicleId) {
        return vehicleProxy.getVehicle(vehicleId);
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleProxy.create(vehicle);
    }

    @PostMapping("/{vehicleId}/user/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void associateVehicle(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleProxy.associate(vehicleId, userId);
    }

    @DeleteMapping("/{vehicleId}/user/{userId}")
    public void removeAssociation(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleProxy.removeAssociation(vehicleId, userId);
    }
}
