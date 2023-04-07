<h1 style="background-color:white">Fun Facts</h1>
<h2 style="text-align:left; padding-left:0">Time for some fun facts about <?php echo $num ?></h2>
<p><strong>The number of digits in <?php echo $num ?> is <?php numDigits($num) ?></strong></p>
<br>
<h2 style="text-align:left; padding-left:0"></h2>
<p><strong>The sum of these digits is <?php sumDigits($num) ?></strong></p>
<br>
<h2 style="text-align:left; padding-left:0"></h2>
<p><strong>Finally, this number in reverse order is <?php reverse($num) ?></strong></p>

<?php
/**
 * Ian Kaiserman
 * Assignment 3: Fun With Integers
 * PHP file for calling and displaying functions and HTML related to the Fun Facts info
 */

function numDigits($num) {
    echo strlen($num), '<br>';
}

function sumDigits($num) {
    $sum = 0;
    while($num != 0) {
        $r = $num % 10;
        $sum += $r;
        $num = $num/10;
    }
    echo $sum, '<br>';
}

function reverse($num) {
    echo strrev($num), '<br>';
}