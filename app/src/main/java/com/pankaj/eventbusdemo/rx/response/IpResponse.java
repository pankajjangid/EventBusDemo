package com.pankaj.eventbusdemo.rx.response;

/**
 * Created by user on 14-Mar-18.
 */

public class IpResponse {

    /**
     * status : success
     * data : {"ipv4":"8.8.8.8","continent_name":"North America","country_name":"United States","subdivision_1_name":"California","subdivision_2_name":null,"city_name":"Mountain View","latitude":"37.38600","longitude":"-122.08380"}
     */

    private String status;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ipv4 : 8.8.8.8
         * continent_name : North America
         * country_name : United States
         * subdivision_1_name : California
         * subdivision_2_name : null
         * city_name : Mountain View
         * latitude : 37.38600
         * longitude : -122.08380
         */

        private String ipv4;
        private String continent_name;
        private String country_name;
        private String subdivision_1_name;
        private Object subdivision_2_name;
        private String city_name;
        private String latitude;
        private String longitude;

        public String getIpv4() {
            return ipv4;
        }

        public void setIpv4(String ipv4) {
            this.ipv4 = ipv4;
        }

        public String getContinent_name() {
            return continent_name;
        }

        public void setContinent_name(String continent_name) {
            this.continent_name = continent_name;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getSubdivision_1_name() {
            return subdivision_1_name;
        }

        public void setSubdivision_1_name(String subdivision_1_name) {
            this.subdivision_1_name = subdivision_1_name;
        }

        public Object getSubdivision_2_name() {
            return subdivision_2_name;
        }

        public void setSubdivision_2_name(Object subdivision_2_name) {
            this.subdivision_2_name = subdivision_2_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }
}
