<?php

/**
 * Ian Kaiserman
 * Assignment 2: Player Statistics
 * EXTRA CREDIT ATTEMPTED
 */

// Import BaseballPlayer file for Player class
require_once(".\BaseballPlayer.php");

// Create new Player object, get stats, initialize variables
$p = new Player();
$pstats = $p->get_stats();
$AB = 0;
$R = 0;
$H = 0;
$BB = 0;
$RBI = 0;
$BA = 0.0;

// Called by array walk to add each game's stats to the total
function addStats($game) {
    global $AB, $R, $H, $BB, $RBI;
    $AB += $game['AB'];
    $R += $game['R'];
    $H += $game['H'];
    $BB += $game['BB'];
    $RBI += $game['RBI'];
}

// Walk through games array and calls addStats to add each stat to total
array_walk($pstats['games'], 'addStats');

// Calculate batting average using new totals
$BAVG = $H/$AB * 1.0;

// Print to the screen (EXTRA CREDIT ATTEMPTED)
// (Spacing is relative to name length, the formatting worked for the player stats given in the example file download, may not work for all tests.)
printf("Name\t\t\tG\tAB\tR\tH\tBB\tRBI\tBA\n%s\t%d\t%d\t%d\t%d\t%d\t%d\t%.2f", $pstats['name'], count($pstats), $AB, $R, $H, $BB, $RBI, $BAVG);