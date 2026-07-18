package com.yeoonsuk.smart_planner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides a lightweight endpoint for checking whether the API process is reachable.
 *
 * <p>This endpoint does not access external infrastructure such as the database.
 * It confirms that the Spring Web application is running and can serve HTTP requests.</p>
 */
@RestController
public class HealthController {

    /**
     * Returns the current application health status.
     *
     * @return HTTP 200 with the API availability status and a human-readable message
     */
    @GetMapping("/api/health")
    public ResponseEntity<HealthResponse> health() {
        // Return a successful HTTP response when the application can handle this request.
        return ResponseEntity.ok(new HealthResponse("UP", "Smart Planner API is running"));
    }

    /**
     * Immutable response body serialized by Spring MVC into the health-check JSON payload.
     */
    private record HealthResponse(String status, String message) {
    }
}
