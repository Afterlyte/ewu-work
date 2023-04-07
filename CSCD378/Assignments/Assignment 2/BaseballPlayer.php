<?php

## Player class with static method to return season of stats for a Player

class Player
{

    public static function get_stats()
    {
        $g1 = array("AB" => 3, "R" => 0, "H" => 1, "BB" => 1, "RBI" => 0);
        $g2 = array("AB" => 0, "R" => 1, "H" => 0, "BB" => 3, "RBI" => 0);
        $g3 = array("AB" => 4, "R" => 1, "H" => 2, "BB" => 1, "RBI" => 0);
        $g4 = array("AB" => 4, "R" => 2, "H" => 3, "BB" => 0, "RBI" => 3);
        $g5 = array("AB" => 2, "R" => 0, "H" => 2, "BB" => 1, "RBI" => 2);
        $games = array($g1, $g2, $g3, $g4, $g5);

        return array("name" => "Talbot Jenkins", "games" => $games);
    }
}
