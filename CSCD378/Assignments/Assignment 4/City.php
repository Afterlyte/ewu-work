<?php
/**
 * Ian Kaiserman
 * CSCD 378
 * Assignment 4: PHP and External Data
 * City class for storing necessary information for each city in contained objects
 */
class City {
    private $cityName;
    private $population;

    public function __construct($cityName, $population) {
        $this->cityName = $cityName;
        $this->population = $population;
    }

    public function getCityName() {
        return $this->cityName;
    }

    public function getPopulation() {
        return $this->population;
    }

    public function __toString() {
        return $this->cityName." (".$this->population.")";
    }
}