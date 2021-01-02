/**
 * ============================================================
 * Created by  - Pramoj Kumararathna
 * On          - Jan 03, 2021
 * At          - 12:13 AM
 * ============================================================
 */
package com.spacex.starlink.constellationmonitor.model;

public class ConstellationAssign {

    Long constellationAssignId;
    Long satelliteId;
    Double latitude;
    Double longitude;

    public Long getConstellationAssignId() {
        return constellationAssignId;
    }

    public void setConstellationAssignId(Long constellationAssignId) {
        this.constellationAssignId = constellationAssignId;
    }

    public Long getSatelliteId() {
        return satelliteId;
    }

    public void setSatelliteId(Long satelliteId) {
        this.satelliteId = satelliteId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "ConstellationAssign{" +
                "constellationAssignId=" + constellationAssignId +
                ", satelliteId=" + satelliteId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
