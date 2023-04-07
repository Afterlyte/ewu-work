<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for handling menu inputs and calling appropriate sections based on selection
 */
    include "index.html";
    include "inputs.php";
?>
<hr>
<?php
    if(!$num) {
        echo '<h2 style="text-align:center">Looks like you didn\'t input a number!<br>Use the form above to input a number and select from the menu!</h2>';
    } else if(strval($num) != strval(intval($num)) || $num > 2147483647 || $num < 0) {
        echo '<h2 style="text-align:center">Oops, that input is invalid! This application currently only supports positive 32-bit integers.</h2>';
    } else {
        echo '<h2 style="text-align:center">Here are your results! Your number is '.$num.'</h2><h3>You selected:</h3>';
        echo "<ul>";
        $menu = array("Names", "Prime Factors", "Divisors", "Base Equivalents", "Squares and Roots", "Fun Facts");
        foreach($choices as $i) {
            echo "<li>".$menu[$i]."</li>";
        }
        echo "</ul>";
        echo "<hr>";
        $files = array("names.php", "primefactors.php", "divisors.php", "bases.php", "squaresroots.php", "funfacts.php");

        foreach($choices as $i) {
            require $files[$i];
        }
    }
?>
<hr>