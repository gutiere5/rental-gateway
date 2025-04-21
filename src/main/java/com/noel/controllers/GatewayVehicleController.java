package com.noel.controllers;

import com.noel.model.Vehicle;
import com.noel.proxy.VehicleProxy;
import com.noel.util.UserContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vehicles")
@AllArgsConstructor
public class GatewayVehicleController {
    private final VehicleProxy vehicleProxy;
    private final ObjectFactory<UserContext> context;

    @GetMapping
    public Vehicle[] getAllVehicles() {
        context.getObject().assertAdmin();
        return vehicleProxy.getAllVehicles();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable String vehicleId) {
        context.getObject().assertAdmin();
        return vehicleProxy.getVehicle(vehicleId);
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        context.getObject().assertAdmin();
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
