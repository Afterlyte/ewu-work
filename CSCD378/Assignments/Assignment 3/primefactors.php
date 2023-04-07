<h1 style="background-color:white">Prime Factors</h1>
<h2 style="text-align:left; padding-left:0">Here are the prime factors of <?php echo $num ?></h2>
<p><strong><?php primeFactors($num); ?></strong></p>

<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Prime Factors info
 */

function primeFactors($num) {
    $factors = array();
    $sq = bcsqrt($num);
    for($i = 2; $i <= $sq; $i++) {
        while($num % $i == 0) {
            $factors[] = $i;
            $num = $num / $i;
        }
    }
    if($num != 1) {
        $factors[] = $num;
    }
    for($j = 0; $j < count($factors) - 1; $j++) {
        echo $factors[$j], ", ";
    }
    echo $factors[count($factors) - 1];
    echo '<br>';
}
