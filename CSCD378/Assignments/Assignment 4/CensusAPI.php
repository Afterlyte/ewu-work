<?php
/**
 * Ian Kaiserman
 * CSCD 378
 * Assignment 4: PHP and External Data
 * Census API class for retrieving JSON data from database
 */
include "vendor/autoload.php";

class CensusAPI {
    public static function fetchCities():array {
        $client = new GuzzleHttp\Client();
        $res = $client->request('GET', 'http://data.wa.gov/resource/ktqk-i4iw.json');
        $result = json_decode($res->getBody()->getContents(), true);
        return $result;
    }
}