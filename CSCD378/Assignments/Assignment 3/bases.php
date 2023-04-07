<h1 style="background-color:white">Base Equivalents</h1>
<h2 style="text-align:left; padding-left:0"><?php echo $num ?> in different bases</h2>
<h3>Binary</h3>
<p><strong><?php binary($num); ?></strong></p>
<br>
<h3>Octal</h3>
<p><strong><?php octal($num); ?></strong></p>
<br>
<h3>Hexadecimal</h3>
<p><strong><?php hex($num); ?></strong></p>

<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Base Equivalents info
 */

function binary($num) {
    echo base_convert($num, 10, 2), "<br>";
}

function octal($num) {
    echo base_convert($num, 10, 8), "<br>";
}

function hex($num) {
    echo base_convert($num, 10, 16), "<br>";
}
