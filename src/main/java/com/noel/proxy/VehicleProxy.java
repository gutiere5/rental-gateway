package com.noel.proxy;

import com.noel.model.Vehicle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Component
public class VehicleProxy {
    private final RestTemplate restTemplate;
    private final String url;

    public VehicleProxy(@Value("${url.rental}") String url, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public Vehicle[] getAllVehicles() {
        return restTemplate.getForObject(url + "vehicles", Vehicle[].class);
    }

    public Vehicle getVehicle(String vehicleId) {
        return restTemplate.getForObject(url + "vehicles/{vehicleID}", Vehicle.class, Map.of("vehicleID", vehicleId));
    }

    public Vehicle create(Vehicle vehicle) {
        return restTemplate.postForObject(url + "vehicles", vehicle, Vehicle.class);
    }

    public void associate(String vehicleId, String userId) {
        restTemplate.postForObject(url + "vehicles/{vehicleId}/user/{userId}", null, Void.class, Map.of("vehicleId", vehicleId, "userId", userId));
    }

    public void removeAssociation(String vehicleId, String userId) {
        restTemplate.delete(url + "vehicles/{vehicleId}/user/{userId}", Map.of("vehicleId", vehicleId, "userId", userId));
    }
}
