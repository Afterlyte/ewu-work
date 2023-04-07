<h1 style="background-color:white">Divisors</h1>
<h2 style="text-align:left; padding-left:0">Here are the divisors of <?php echo $num ?></h2>
<p><strong><?php divisors($num); ?></strong></p>

<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Divisors info
 */

function divisors($num) {
    $div = array();
    for($i = 1; $i <= $num; $i++) {
        if($num % $i == 0) {
            $div[] = $i;
        }
    }
    for($j = 0; $j < count($div) - 1; $j++) {
        echo $div[$j], ", ";
    }
    echo $div[count($div) - 1];
    echo '<br>';
}