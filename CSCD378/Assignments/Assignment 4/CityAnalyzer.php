<?php
/**
 * Ian Kaiserman
 * CSCD 378
 * Assignment 4: PHP and External Data
 * City Analyzer class for calculating, formatting, and printing data based on requirements
 */
include "City.php";

class CityAnalyzer {
    private $cityArray = [];

    public function __construct($citiesJson) {
        foreach($citiesJson as $c) {
            $this->cityArray[] = new City((string)$c["place_name"], (integer)$c["total_population_2010"]);
        }
    }

    public function getHighestTen() {
        echo "10 highest populated cities:\n";
        echo "----------------------------\n";
        $arrayCopy = $this->cityArray;
        usort($arrayCopy, function($a, $b) {
            return $a->getPopulation() < $b->getPopulation();
        });
        for($i = 0; $i < 10; $i++) {
            echo $arrayCopy[$i]->__toString()."\n";
        }
    }

    public function getLowestTen() {
        echo "10 lowest populated cities:\n";
        echo "---------------------------\n";
        $arrayCopy = $this->cityArray;
        usort($arrayCopy, function($a, $b) {
            return $a->getPopulation() > $b->getPopulation();
        });
        for($i = 0; $i < 10; $i++) {
            echo $arrayCopy[$i]->__toString()."\n";
        }
    }

    public function getRandom() {
        $random = $this->cityArray[random_int(0, count($this->cityArray) - 1)];
        echo "Random City: ".$random->__toString();
    }

    public function getCities() {
        return $this->cityArray;
    }
}