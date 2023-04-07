<?php
/**
 * Ian Kaiserman
 * CSCD 378
 * Assignment 4: PHP and External Data
 * Main project class, calls necessary functions from the other encapsulated project files
 */
include "CensusAPI.php";
include "CityAnalyzer.php";

$citiesJson = CensusAPI::fetchCities();
$analyzer = new CityAnalyzer($citiesJson);
echo "\n";
$analyzer->getHighestTen();
echo "\n";
$analyzer->getLowestTen();
echo "\n";
$analyzer->getRandom();
echo "\n";